package com.example.toolinventorysystem.services.serviceImpl;
import com.example.toolinventorysystem.Dto.InputDto.MachineInputDto;
import com.example.toolinventorysystem.Dto.InputDto.UserInputDto;
import com.example.toolinventorysystem.Dto.OutputDto.MachineOutputDto;
import com.example.toolinventorysystem.Dto.OutputDto.UserOutputDto;
import com.example.toolinventorysystem.models.Machine;
import com.example.toolinventorysystem.models.User;
import com.example.toolinventorysystem.repository.MachineRepository;
import com.example.toolinventorysystem.services.MachineService;
import lombok.AllArgsConstructor;
import org.modelmapper.TypeToken;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.lang.reflect.Type;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class MachineServiceImpl implements MachineService {
    private final MachineRepository machineRepository;
    private ModelMapper modelMapper;

    public List<MachineOutputDto> findAll(){
        List<Machine> machine1 = machineRepository.findAll();
        Type listType = new TypeToken<List<MachineOutputDto>>(){}.getType();
        List<MachineOutputDto> dtoMachineList = modelMapper.map(machine1, listType);
        return dtoMachineList;
    }
    public MachineOutputDto saveMachine(MachineInputDto machine) {
        Machine machine1 = modelMapper.map(machine, Machine.class);
        machine1 = machineRepository.save(machine1);
        return modelMapper.map(machine1, MachineOutputDto.class);
    }

    public ResponseEntity<MachineOutputDto> deleteMachine(UUID id) {
        Machine machine = machineRepository.findById(id).orElseThrow(() -> new RuntimeException());
        machineRepository.delete(machine);
        return ResponseEntity.ok(modelMapper.map(machine, MachineOutputDto.class));
    }
}
