package org.vmdevel.ejercicio.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.vmdevel.ejercicio.domain.User;
import org.vmdevel.ejercicio.domain.UserToken;
import org.vmdevel.ejercicio.exception.RegisteredEmailException;
import org.vmdevel.ejercicio.repository.PhoneRepository;
import org.vmdevel.ejercicio.repository.UserRepository;
import org.vmdevel.ejercicio.repository.UserTokenRepository;
import org.vmdevel.ejercicio.service.UserService;
import org.vmdevel.ejercicio.util.JwtUtil;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

@Service
@Transactional(propagation = Propagation.NEVER)
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PhoneRepository phoneRepository;
    @Autowired
    private UserTokenRepository userTokenRepository;

    @Override
    public User createUser(User user) throws RegisteredEmailException {
        try {

            user.setCreated(LocalDateTime.now(ZoneId.of("Chile/Continental")));
            user.setLastLogin(user.getCreated());
            user.setActive(true);
            User persisted = userRepository.saveAndFlush(user);
            UserToken userToken = new UserToken();
            userToken.setToken(jwtUtil.generateNewToken(user));
            userToken.setUser(user);
            userTokenRepository.save(userToken);
            persisted.setUserToken(userToken);
            if(user.getPhones() != null){
                user.getPhones().stream().forEach(phone -> {
                    phone.setUser(persisted);
                    phoneRepository.saveAndFlush(phone);
                });
            }

            return persisted;
        }catch (DataIntegrityViolationException ex) {
            throw new RegisteredEmailException();
        }

    }

    @Override
    public User updateUser(User user) {
        Optional<User> optionalUser = userRepository.findById(user.getId());
        if(optionalUser.isPresent()){
            User fromDb = optionalUser.get();
            fromDb.setPassword(user.getPassword());
            fromDb.setName(user.getName());
            fromDb.setModified(LocalDateTime.now(ZoneId.of("Chile/Continental")));
            UserToken userToken = fromDb.getUserToken();
            userToken.setToken(jwtUtil.generateNewToken(fromDb));
            userTokenRepository.save(userToken);
            User updated = userRepository.save(fromDb);
            return updated;
        }
        return user;
    }
}
