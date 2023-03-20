package com.example.toolinventorysystem.services;

import com.example.toolinventorysystem.Dto.InputDto.ToolDto;
import com.example.toolinventorysystem.Dto.InputDto.ToolInput;
import com.example.toolinventorysystem.models.Tool;

import java.util.List;

public interface ToolService {
    List<ToolDto> addTools(ToolInput input);
}
