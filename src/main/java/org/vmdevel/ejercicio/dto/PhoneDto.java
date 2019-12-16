package org.vmdevel.ejercicio.dto;

import javax.validation.constraints.NotBlank;

public class PhoneDto {

    private Integer id;
    @NotBlank(message = "Numero telefonico requerido.")
    private String number;
    @NotBlank(message = "Codigo ciudad requerido.")
    private String cityCode;
    @NotBlank(message = "Codigo pais requerido.")
    private String countryCode;
    private Integer user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }
}
