package org.vmdevel.ejercicio.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.vmdevel.ejercicio.converter.UserConverter;
import org.vmdevel.ejercicio.converter.UserDtoConverter;
import org.vmdevel.ejercicio.converter.UserResponseDtoConverter;

@Configuration
public class ApplicationConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new UserConverter());
        registry.addConverter(new UserDtoConverter());
        registry.addConverter(new UserResponseDtoConverter());
    }
}
