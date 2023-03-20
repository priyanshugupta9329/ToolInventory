package com.example.toolinventorysystem.controllers;

import com.example.toolinventorysystem.Dto.InputDto.MachineInputDto;
import com.example.toolinventorysystem.Dto.InputDto.UserInputDto;
import com.example.toolinventorysystem.Dto.OutputDto.MachineOutputDto;
import com.example.toolinventorysystem.Dto.OutputDto.UserOutputDto;
import com.example.toolinventorysystem.models.BaseModel;
import com.example.toolinventorysystem.models.Machine;
import com.example.toolinventorysystem.services.serviceImpl.MachineServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/machines")
@AllArgsConstructor
public class MachineController {
    private final MachineServiceImpl machineServiceImpl;

    @PostMapping
    public MachineOutputDto saveMachine(@RequestBody MachineInputDto machine){
        return machineServiceImpl.saveMachine(machine);
    }

    @GetMapping
    public List<MachineOutputDto> findAll(){
        return machineServiceImpl.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MachineOutputDto> deleteById(@PathVariable UUID id){

        return machineServiceImpl.deleteMachine(id);
    }

}
