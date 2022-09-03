package com.rpg.exception;

import com.rpg.entity.Monster;

public class HeroDeadException extends RuntimeException {

   private Monster whoKillMe;

    public HeroDeadException(String message, Monster whoKillMe) {
        super(message);
        this.whoKillMe = whoKillMe;
    }
}
