package com.rpg.dto;

import lombok.Data;

@Data
public class UserDto {

    private Integer id;
    private String login;
    private String password;
    private String passwordRepeat;
    private String phone;
    private String email;
    private String role;
    private HeroDto heroDto;

    public UserDto() {
    }

    public UserDto(Integer id, String login, String password, String passwordRepeat, String phone, String email, String role, HeroDto heroDto) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.passwordRepeat = passwordRepeat;
        this.phone = phone;
        this.email = email;
        this.role = role;
        this.heroDto = heroDto;
    }

    public UserDto(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
