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
//    private final UserServiceImpl userServiceImpl;
//    private final BaseModel baseModel;
//
//    @GetMapping
//    public ResponseEntity<?> getById(){
//        List<User> user = userServiceImpl.findAll();
//        if (CollectionUtils.isEmpty(user)) {
//            return new ResponseEntity<List<User>>(user, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>("No user available", HttpStatus.NOT_FOUND);
//        }
//    }
//    //SEE GET IS PROPER CAN ALL POST PUT DELETE BE MADE SAME WAY WITH ELSE PART ?
//
//    @PostMapping
//    public ResponseEntity<?> postAllUsers(@RequestBody User user) {
////        return ResponseEntity.ok(userServiceImpl.findAll());
//        List<User> user1 = (List<User>) userServiceImpl.save(user);
//        return new ResponseEntity<List<User>>(user1, HttpStatus.OK);
//    }
//
//
////    @PostMapping
////    public ResponseEntity<?> postAllUser(@RequestBody User user){
////        return ResponseEntity.ok(userServiceImpl.save(user));
////    }
//
//
//    @PutMapping("/{id}")
////    public User updateUser(@RequestBody User user){
////        return userServiceImpl.updateUser(user);
////    }
//    public ResponseEntity<?> updateTask(@PathVariable String id, @RequestBody User user) {
//        user.setId(baseModel.getId());
//        return ResponseEntity.ok(userServiceImpl.updateUser(user));
//
//    }
//
//    @DeleteMapping("{id}")
//    public ResponseEntity<?> deleteById(@PathVariable String id){
//        return userServiceImpl.deleteUser(id);
//    }



    private UserServiceImpl userServiceImpl;

    @PostMapping("/save")
    public UserOutputDto saveUser(@RequestBody UserInputDto user){
        return userServiceImpl.saveUser(user);
    }

    @GetMapping("/get/{id}")
    public UserOutputDto getById(@PathVariable UUID id){
        return userServiceImpl.getUser(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UserOutputDto> deleteById(@PathVariable UUID id){

        return userServiceImpl.deleteUser(id);
    }

    @PutMapping("/update")
    public UserOutputDto updateUser(@RequestBody UserInputDto user){
        return userServiceImpl.updateUser(user);
    }

    @PatchMapping("/patch/{id}")
    public UserOutputDto patchUpdate(@PathVariable UUID id,@RequestBody UserInputDto user){
        return userServiceImpl.partialUpdate(id,user);
    }

    @GetMapping
    public List<UserOutputDto> findAll(){
        return userServiceImpl.findAll();
    }


}
