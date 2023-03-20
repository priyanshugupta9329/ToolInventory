package com.example.toolinventorysystem.services.serviceImpl;
import com.example.toolinventorysystem.Dto.InputDto.UserInputDto;
import com.example.toolinventorysystem.Dto.OutputDto.UserOutputDto;
import com.example.toolinventorysystem.enums.Role;
import com.example.toolinventorysystem.models.IdInformation;
import com.example.toolinventorysystem.models.User;
import com.example.toolinventorysystem.repository.IdInformationRepository;
import com.example.toolinventorysystem.repository.UserRepository;
import com.example.toolinventorysystem.services.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.lang.reflect.Type;
import java.util.List;
import java.util.UUID;

import static com.example.toolinventorysystem.enums.Role.MANAGER;
import static com.example.toolinventorysystem.enums.Role.OPERATOR;

@Service
@Data
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;

//    private PatchMapper patchMapper;

    private final UserRepository userRepository;
    private final IdInformationRepository idInformationRepository;

    public List<UserOutputDto> findAll(){
        List<User> user1 = userRepository.findAll();
        Type listType = new TypeToken<List<UserOutputDto>>(){}.getType();
        List<UserOutputDto> dtoUsersList = modelMapper.map(user1, listType);
        return dtoUsersList;
    }

    public UserOutputDto saveUser(UserInputDto user) {

        boolean isAdmin = true;

    // Set user's role based on who's creating them
        if (isAdmin) {
            user.setRole(MANAGER);
        } else {
            user.setRole(OPERATOR);
        }

        User user1 = modelMapper.map(user, User.class);
        IdInformation idInformation = idInformationRepository.findAll().get(0);
        Long latestId = idInformation.getLatestUserId() + 1;
        user1.setShowUserId(latestId);
        user1 = userRepository.save(user1);
        idInformation.setLatestUserId(latestId);
        idInformationRepository.save(idInformation);
        return modelMapper.map(user1, UserOutputDto.class);
    }

    public UserOutputDto getUser(UUID id) {
        User user1 = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User Not Found"));
        return modelMapper.map(user1, UserOutputDto.class);
    }

    public ResponseEntity<UserOutputDto> deleteUser(UUID id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException());
        userRepository.delete(user);
        return ResponseEntity.ok(modelMapper.map(user, UserOutputDto.class));
    }

    public UserOutputDto updateUser(UUID id,UserInputDto input) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException());
        modelMapper.map(input, user);
        user = userRepository.save(user);
        return modelMapper.map(user, UserOutputDto.class);
    }

}
