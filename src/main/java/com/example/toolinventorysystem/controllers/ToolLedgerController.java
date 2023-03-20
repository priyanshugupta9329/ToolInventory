package com.example.toolinventorysystem.controllers;
import com.example.toolinventorysystem.Dto.OutputDto.ToolLedgerOutputDto;
import com.example.toolinventorysystem.models.ToolLedger;
import com.example.toolinventorysystem.services.serviceImpl.ToolLedgerServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/toolLedger")
@AllArgsConstructor
public class ToolLedgerController {
    private final ToolLedgerServiceImpl toolLedgerService;


    @GetMapping
    public ResponseEntity<?> findAll(){
        List<ToolLedgerOutputDto> toolLedger = toolLedgerService.findAll();
        if (CollectionUtils.isEmpty(toolLedger)) {
            return new ResponseEntity<List<ToolLedgerOutputDto>>(toolLedger, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No logs in tool ledger", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/username")
    public ResponseEntity<?> findByUsername(String username){
        List<ToolLedgerOutputDto> toolLedger = toolLedgerService.findByUsername(username);
        if (CollectionUtils.isEmpty(toolLedger)) {
            return new ResponseEntity<List<ToolLedgerOutputDto>>(toolLedger, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No logs in tool ledger", HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/userid")
    public ResponseEntity<?> findByUserId(String showUserId){
        List<ToolLedgerOutputDto> toolLedger = toolLedgerService.findByUserId(showUserId);
        if (CollectionUtils.isEmpty(toolLedger)) {
            return new ResponseEntity<List<ToolLedgerOutputDto>>(toolLedger, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No logs in tool ledger", HttpStatus.NOT_FOUND);
        }
    }
}
