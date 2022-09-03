package com.rpg.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name = "player")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nickName;

    private String password;

    private String phone;

    private String email;

    @OneToMany(mappedBy = "user")
    private List<Hero> heroes;


    @Enumerated(EnumType.STRING)
    private Role role;

}
