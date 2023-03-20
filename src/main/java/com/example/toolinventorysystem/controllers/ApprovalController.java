package com.example.toolinventorysystem.controllers;
import com.example.toolinventorysystem.Dto.InputDto.ApprovalDto;
import com.example.toolinventorysystem.Dto.InputDto.ToolDto;
import com.example.toolinventorysystem.Dto.InputDto.UserInputDto;
import com.example.toolinventorysystem.Dto.OutputDto.UserOutputDto;
import com.example.toolinventorysystem.models.Approval;
import com.example.toolinventorysystem.models.ToolLedger;
import com.example.toolinventorysystem.services.serviceImpl.ApprovalServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

import static com.example.toolinventorysystem.enums.ApprovalStatus.*;

@RestController
@RequestMapping("/approval")
@AllArgsConstructor
public class ApprovalController {
    private final ApprovalServiceImpl approvalServiceImpl;

//    @GetMapping
//    public List<UserOutputDto> findAll(){
////        return approvalServiceImpl.findAll();
//        return null;
//    }

    @PostMapping("/pending")
    public ApprovalDto requestApproval(@RequestBody ApprovalDto approvalDto){

//        Approval approval = new Approval();
        approvalDto.setStatus(PENDING);
//        approval.setUserId();
//        approval.getMachineId();
//        approval.setToolId();
//        approval.setRequestAt();
        return approvalServiceImpl.approveApproval(approvalDto);
    }
    @PostMapping("/approved")
    public ApprovalDto approveApproval(@RequestBody ApprovalDto approvalDto){
//        Approval approval = new Approval();
        approvalDto.setStatus(APPROVED);
        ToolLedger toolLedger = new ToolLedger();
//        toolLedger.setShowUserId();
//        toolLedger.setUsername();
//        toolLedger.setMachineName();
//        toolLedger.setToolTypeName();
//        toolLedger.setToolId();
//        toolLedger.setStartDateTime();


        return approvalServiceImpl.approveApproval(approvalDto);
    }

    @PostMapping("/rejected")
    public ApprovalDto rejectApproval(@RequestBody ApprovalDto approvalDto){
//        Approval approval = new Approval();
        approvalDto.setStatus(REJECTED);
        return approvalServiceImpl.rejectApproval(approvalDto);
    }


}
