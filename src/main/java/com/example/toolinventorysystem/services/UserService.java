package com.example.toolinventorysystem.services;

import com.example.toolinventorysystem.Dto.InputDto.UserInputDto;
import com.example.toolinventorysystem.Dto.OutputDto.UserOutputDto;
import com.example.toolinventorysystem.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface UserService {
//    public List<User> findAll();
//    public User save(User user);
//    public User updateUser(User user);
//    public ResponseEntity<?> deleteUser(String id);

    public List<UserOutputDto> findAll();
    public UserOutputDto saveUser(UserInputDto user);
    public UserOutputDto getUser(UUID id);
    public ResponseEntity<UserOutputDto> deleteUser(UUID id);

    public UserOutputDto updateUser(UserInputDto user);
    public UserOutputDto partialUpdate(UUID id,UserInputDto user);

}
