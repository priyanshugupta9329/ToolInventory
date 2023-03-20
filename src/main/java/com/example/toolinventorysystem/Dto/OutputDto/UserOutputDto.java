package com.example.toolinventorysystem.Dto.OutputDto;

import com.example.toolinventorysystem.enums.Role;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;
@Data
public class UserOutputDto {
    private UUID id;
    private String showUserId;
    private String name;
    private String password;
    private List<UUID> currentMachine;
    private Role role;
}
