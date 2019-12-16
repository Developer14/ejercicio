package org.vmdevel.ejercicio.dto;

import org.vmdevel.ejercicio.domain.validation.PasswordConstraint;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

public class UserDto {

    private Integer id;
    @NotBlank(message = "Nombre de usuario requerido.")
    private String name;
    @Email(message = "El formato del email es invalido.")
    private String email;
    @PasswordConstraint(message = "La password debe contener una letra Mayuscula, minusculas y al menos dos numeros.")
    private String password;
    @Valid
    private List<PhoneDto> phones;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<PhoneDto> getPhones() {
        return phones;
    }

    public void setPhones(List<PhoneDto> phones) {
        this.phones = phones;
    }
}
