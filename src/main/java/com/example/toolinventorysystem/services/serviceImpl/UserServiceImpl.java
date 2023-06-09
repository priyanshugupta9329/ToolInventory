package com.example.toolinventorysystem.services.serviceImpl;
import com.example.toolinventorysystem.Dto.InputDto.UserInputDto;
import com.example.toolinventorysystem.Dto.OutputDto.ToolLedgerOutputDto;
import com.example.toolinventorysystem.Dto.OutputDto.UserOutputDto;
import com.example.toolinventorysystem.models.ToolLedger;
import com.example.toolinventorysystem.models.User;
import com.example.toolinventorysystem.repository.UserRepository;
import com.example.toolinventorysystem.services.UserService;
import com.example.toolinventorysystem.utils.PatchMapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.lang.reflect.Type;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
//    private final UserRepository userRepository;
//    public List<User> findAll() {
//        return userRepository.findAll();
//    }
//    public User save(User user) {return userRepository.save(user);
//    }
//    public User updateUser(User user) {
//        return userRepository.save(user);
//    }
//
//    public ResponseEntity<?> deleteUser(String id) {
//
//        return userRepository.deleteById(id);
//    }



    private ModelMapper modelMapper;


    private PatchMapper patchMapper;


    private UserRepository userRepository;

    public List<UserOutputDto> findAll(){
        List<User> user1 = userRepository.findAll();
        Type listType = new TypeToken<List<UserOutputDto>>(){}.getType();
        List<UserOutputDto> dtoUsersList = modelMapper.map(user1, listType);
        return dtoUsersList;
    }

    public UserOutputDto saveUser(UserInputDto user) {
        User user1 = modelMapper.map(user, User.class);
        user1 = userRepository.save(user1);
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

    public UserOutputDto updateUser(UserInputDto user) {
        User user1 = modelMapper.map(user, User.class);
        User user2 = userRepository.findById(user1.getId()).orElseThrow(() -> new RuntimeException());
        modelMapper.map(user1, user2);
        user2 = userRepository.save(user2);
        return modelMapper.map(user2, UserOutputDto.class);
    }

    public UserOutputDto partialUpdate(UUID id, UserInputDto user) {
        User user1 = modelMapper.map(user, User.class);
        User existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found Any Task With Given Id" + " " + id));
        patchMapper.map(user1, existingUser);
        existingUser = userRepository.save(existingUser);
        return modelMapper.map(existingUser, UserOutputDto.class);
    }
}
