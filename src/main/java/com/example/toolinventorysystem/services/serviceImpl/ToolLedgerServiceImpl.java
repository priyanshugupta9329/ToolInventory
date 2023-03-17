package com.example.toolinventorysystem.services.serviceImpl;
import com.example.toolinventorysystem.Dto.OutputDto.ToolLedgerOutputDto;
import com.example.toolinventorysystem.models.ToolLedger;
import com.example.toolinventorysystem.repository.ToolLedgerRepository;
import com.example.toolinventorysystem.services.ToolLedgerService;
import lombok.AllArgsConstructor;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ToolLedgerServiceImpl implements ToolLedgerService {
    private final ToolLedgerRepository toolLedgerRepository;

    private ModelMapper modelMapper;

    public List<ToolLedgerOutputDto> findAll() {
        List<ToolLedger> toolLedger1 = toolLedgerRepository.findAll();
        Type listType = new TypeToken<List<ToolLedgerOutputDto>>(){}.getType();
        List<ToolLedgerOutputDto> dtoList = modelMapper.map(toolLedger1, listType);
        return dtoList;
    }

    public List<ToolLedgerOutputDto> findByUserId(String showUserId) {
        List<ToolLedgerOutputDto> toolLedger1 = toolLedgerRepository.findByUsername(showUserId);
        Type listType = new TypeToken<List<ToolLedgerOutputDto>>(){}.getType();
        List<ToolLedgerOutputDto> dtoUserIdList= modelMapper.map(toolLedger1, listType);
        return dtoUserIdList;
    }
    public List<ToolLedgerOutputDto> findByUsername(String username){
        List<ToolLedgerOutputDto> toolLedger1 = toolLedgerRepository.findByUsername(username);
        Type listType = new TypeToken<List<ToolLedgerOutputDto>>(){}.getType();
        List<ToolLedgerOutputDto> dtoUserList = modelMapper.map(toolLedger1, listType);
        return dtoUserList;
    }
}
