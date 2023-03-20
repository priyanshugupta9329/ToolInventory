package com.example.toolinventorysystem.models;

import com.example.toolinventorysystem.enums.Role;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Document
@ToString
public class User extends BaseModel{
    private Long showUserId;
    private String name;
    private String password;
    private List<UUID> currentMachine;
    private Role role;

}
