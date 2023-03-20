package com.example.toolinventorysystem.Dto.OutputDto;

import lombok.Data;

import java.util.UUID;
@Data
public class MachineOutputDto {
    private UUID id;
    private String name;
    private String description;
}
