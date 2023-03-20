package com.example.toolinventorysystem.Dto.InputDto;

import com.example.toolinventorysystem.enums.ToolType;
import lombok.Data;

@Data
public class ToolDto {
    private ToolType toolType;
    private Float lifecycle;
    private Integer numberOfResharpen;
}
