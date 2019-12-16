package org.vmdevel.ejercicio.converter;

import org.springframework.core.convert.converter.Converter;
import org.vmdevel.ejercicio.domain.User;
import org.vmdevel.ejercicio.dto.UserResponseDto;

public class UserResponseDtoConverter implements Converter<User, UserResponseDto> {

    @Override
    public UserResponseDto convert(User source) {
        UserResponseDto dto = new UserResponseDto();
        dto.setId(source.getId());
        dto.setName(source.getName());
        dto.setEmail(source.getEmail());
        dto.setCreated(source.getCreated());
        dto.setModified(source.getModified());
        dto.setLastLogin(source.getLastLogin());
        dto.setId(source.getId());
        dto.setActive(source.getActive());
        dto.setToken(source.getUserToken().getToken());

        return dto;
    }
}
