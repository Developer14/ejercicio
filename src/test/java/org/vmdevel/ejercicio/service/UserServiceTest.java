package org.vmdevel.ejercicio.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.vmdevel.ejercicio.EjercicioApplication;
import org.vmdevel.ejercicio.domain.User;
import org.vmdevel.ejercicio.domain.UserToken;
import org.vmdevel.ejercicio.repository.PhoneRepository;
import org.vmdevel.ejercicio.repository.UserRepository;
import org.vmdevel.ejercicio.repository.UserTokenRepository;
import org.vmdevel.ejercicio.service.impl.UserServiceImpl;
import org.vmdevel.ejercicio.util.JwtUtil;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock private JwtUtil jwtUtil;
    @Mock private UserRepository userRepository;
    @Mock private UserTokenRepository userTokenRepository;
    @Mock private PhoneRepository phoneRepository;

    @InjectMocks private UserService userService = new UserServiceImpl();

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test() throws Exception {

        User expected = new User();
        expected.setName("dummy");
        expected.setPassword("Dummy2019");
        expected.setEmail("dummy@mail.com");
        User param = new User();

        Mockito.when(userRepository.saveAndFlush(param)).thenReturn(expected);

        User created = userService.createUser(param);
        Assert.assertNotNull(created.getUserToken());
    }
}
