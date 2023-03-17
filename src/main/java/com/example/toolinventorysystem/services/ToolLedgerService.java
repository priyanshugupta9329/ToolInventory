package com.example.toolinventorysystem.services;

import com.example.toolinventorysystem.Dto.OutputDto.ToolLedgerOutputDto;
import com.example.toolinventorysystem.models.ToolLedger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface ToolLedgerService {
    public List<ToolLedgerOutputDto> findAll();
    public List<ToolLedgerOutputDto> findByUserId(String showUserId);

    public List<ToolLedgerOutputDto> findByUsername(String username);
}
