package br.com.uema.davimc.SafeUber.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class User {
    private UUID id;
    private String name;
    private String login;
    private String password;
}
