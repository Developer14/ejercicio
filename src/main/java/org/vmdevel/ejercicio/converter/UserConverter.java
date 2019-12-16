package org.vmdevel.ejercicio.converter;

import org.springframework.core.convert.converter.Converter;
import org.vmdevel.ejercicio.dto.PhoneDto;
import org.vmdevel.ejercicio.dto.UserDto;
import org.vmdevel.ejercicio.domain.Phone;
import org.vmdevel.ejercicio.domain.User;

import java.util.stream.Collectors;

public class UserConverter implements Converter<UserDto, User> {

    @Override
    public User convert(UserDto source) {
        User user = new User();

        user.setId(source.getId());
        user.setName(source.getName());
        user.setEmail(source.getEmail());
        user.setPassword(source.getPassword());
        if(source.getPhones() != null){
            user.setPhones(source.getPhones().stream().map(phoneDto -> {
                phoneDto.setUser(user.getId());
                return toPhone(phoneDto, user);
            }).collect(Collectors.toList()));
        }
        return user;
    }

    private Phone toPhone(PhoneDto dto, User user) {
        Phone phone = new Phone();
        phone.setUser(user);
        phone.setNumber(dto.getNumber());
        phone.setCityCode(dto.getCityCode());
        phone.setCountryCode(dto.getCountryCode());
        phone.setId(dto.getId());
        return phone;
    }
}
