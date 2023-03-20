package com.example.toolinventorysystem.controllers;
import com.example.toolinventorysystem.Dto.InputDto.UserInputDto;
import com.example.toolinventorysystem.Dto.OutputDto.UserOutputDto;
import com.example.toolinventorysystem.models.BaseModel;
import com.example.toolinventorysystem.models.User;
import com.example.toolinventorysystem.services.serviceImpl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private UserServiceImpl userServiceImpl;

    @GetMapping
    public List<UserOutputDto> findAll(){
        return userServiceImpl.findAll();
    }

    @PostMapping
    public UserOutputDto saveUser(@RequestBody UserInputDto user){
        return userServiceImpl.saveUser(user);
    }

    @GetMapping("/{id}")
    public UserOutputDto getById(@PathVariable UUID id){
        return userServiceImpl.getUser(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserOutputDto> deleteById(@PathVariable UUID id){

        return userServiceImpl.deleteUser(id);
    }

    @PutMapping
    public UserOutputDto updateUser(@RequestBody UserInputDto user){
        return userServiceImpl.updateUser(user);
    }


}
