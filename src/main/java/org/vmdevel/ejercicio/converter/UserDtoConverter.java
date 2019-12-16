package org.vmdevel.ejercicio.converter;

import org.springframework.core.convert.converter.Converter;
import org.vmdevel.ejercicio.dto.PhoneDto;
import org.vmdevel.ejercicio.dto.UserDto;
import org.vmdevel.ejercicio.domain.Phone;
import org.vmdevel.ejercicio.domain.User;

import java.util.stream.Collectors;

public class UserDtoConverter implements Converter<User, UserDto> {

    @Override
    public UserDto convert(User source) {
        UserDto dto = new UserDto();
        dto.setId(source.getId());
        dto.setName(source.getName());
        dto.setEmail(source.getEmail());
        dto.setPhones(source.getPhones().stream().map(phone -> toPhoneDto(phone)).collect(Collectors.toList()));;

        return dto;
    }

    private PhoneDto toPhoneDto(Phone phone) {
        PhoneDto dto = new PhoneDto();
        dto.setId(phone.getId());
        dto.setNumber(phone.getNumber());
        dto.setCityCode(phone.getCityCode());
        dto.setCountryCode(phone.getCountryCode());
        dto.setUser(phone.getUser().getId());
        return dto;
    }
}
