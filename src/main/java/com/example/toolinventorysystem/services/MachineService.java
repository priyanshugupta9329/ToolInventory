package com.example.toolinventorysystem.services;

import com.example.toolinventorysystem.Dto.InputDto.MachineInputDto;
import com.example.toolinventorysystem.Dto.InputDto.UserInputDto;
import com.example.toolinventorysystem.Dto.OutputDto.MachineOutputDto;
import com.example.toolinventorysystem.Dto.OutputDto.UserOutputDto;
import com.example.toolinventorysystem.models.Machine;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface MachineService {

    public List<MachineOutputDto> findAll();
    public MachineOutputDto saveMachine(MachineInputDto machine);
    public ResponseEntity<MachineOutputDto> deleteMachine(UUID id);

}
