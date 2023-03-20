package com.example.toolinventorysystem.Dto.InputDto;

import com.example.toolinventorysystem.enums.Role;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document
public class UserInputDto {
//    private String showUserId;
    private String name;
    private String password;
//    private List<UUID> currentMachine;
    private Role role;
}
