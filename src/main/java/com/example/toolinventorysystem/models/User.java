package com.example.toolinventorysystem.models;

import com.example.toolinventorysystem.enums.Role;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Document
public class User extends BaseModel{
    private String showUserId;
    private String name;
    private String password;
    private List<UUID> currentMachine;
    private Role role;

}
