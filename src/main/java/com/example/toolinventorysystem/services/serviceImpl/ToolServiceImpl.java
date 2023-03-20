package com.example.toolinventorysystem.services.serviceImpl;

import com.example.toolinventorysystem.Dto.InputDto.ToolDto;
import com.example.toolinventorysystem.Dto.InputDto.ToolInput;
import com.example.toolinventorysystem.enums.ToolType;
import com.example.toolinventorysystem.repository.ToolRepository;
import com.example.toolinventorysystem.services.ToolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ToolServiceImpl implements ToolService {


    private final ToolRepository toolRepository;
    @Override
    public List<ToolDto> addTools(ToolInput input) {
        List<ToolDto> toSave = new ArrayList<>();
        if(input.getHammer() != null){
            int numberOfTools = input.getHammer();
            for(int i = 0; i < numberOfTools ; i++ ){
                ToolDto toolDto = new ToolDto();
                toolDto.setToolType(ToolType.HAMMER);
                toolDto.setLifecycle(100.0F);
                toolDto.setNumberOfResharpen(0);
                toSave.add(toolDto);
            }
        }
        if (input.getSaw() != null) {
            int numberOfTools = input.getSaw();
            for(int i = 0; i < numberOfTools ; i++ ){
                ToolDto toolDto= new ToolDto();
                toolDto.setToolType(ToolType.SAW);
                toolDto.setLifecycle(100.0F);
                toolDto.setNumberOfResharpen(0);
                toSave.add(toolDto);
            }
        }

        return toolRepository.saveAll(toSave);
    }
}
