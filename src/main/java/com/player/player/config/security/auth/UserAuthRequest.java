package com.player.player.config.security.auth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAuthRequest {

    private String username;

    private String password;
}