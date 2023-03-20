package com.example.toolinventorysystem.controllers;
import com.example.toolinventorysystem.Dto.InputDto.UserInputDto;
import com.example.toolinventorysystem.Dto.OutputDto.UserOutputDto;
import com.example.toolinventorysystem.models.Approval;
import com.example.toolinventorysystem.services.serviceImpl.ApprovalServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/approval")
@AllArgsConstructor
public class ApprovalController {
    private final ApprovalServiceImpl approvalServiceImpl;

//    @GetMapping
//    public ResponseEntity<?> getById(){
//        List<Approval> approval = approvalServiceImpl.findAll();
//        if (CollectionUtils.isEmpty(approval)) {
//            return new ResponseEntity<List<Approval>>(approval, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>("No approval details", HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @PostMapping
//    public ResponseEntity<?> postAllUsers(@RequestBody Approval approval) {
////        return ResponseEntity.ok(userServiceImpl.findAll());
//        Approval approval1 = approvalServiceImpl.save(approval);
//        return new ResponseEntity<List<Approval>>((List<Approval>) approval1, HttpStatus.OK);
//    }
//    //SEE THIS POST ?

    @GetMapping
    public List<UserOutputDto> findAll(){
        return approvalServiceImpl.findAll();
    }

    @PostMapping
    public UserOutputDto saveUser(@RequestBody UserInputDto user){
        return approvalServiceImpl.saveUser(user);
    }


}
