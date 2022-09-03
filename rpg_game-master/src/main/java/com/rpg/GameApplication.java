package com.rpg;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class GameApplication{


    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(GameApplication.class, args);

    }


}
