package com.example.toolinventorysystem.controllers;


import com.example.toolinventorysystem.Dto.InputDto.ToolDto;
import com.example.toolinventorysystem.Dto.InputDto.ToolInput;
import com.example.toolinventorysystem.models.Tool;
import com.example.toolinventorysystem.services.ToolService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tools")
@RequiredArgsConstructor
public class ToolController {

    private final ToolService toolService;

    @PostMapping("/add")
    public List<ToolDto> addTools(@RequestBody ToolInput input){
        return toolService.addTools(input);
    }

}
