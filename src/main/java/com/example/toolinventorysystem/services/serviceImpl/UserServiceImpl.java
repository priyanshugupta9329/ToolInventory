package com.example.toolinventorysystem.services.serviceImpl;
import com.example.toolinventorysystem.Dto.InputDto.UserInputDto;
import com.example.toolinventorysystem.Dto.OutputDto.UserOutputDto;
import com.example.toolinventorysystem.models.User;
import com.example.toolinventorysystem.repository.UserRepository;
import com.example.toolinventorysystem.services.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.lang.reflect.Type;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private ModelMapper modelMapper;

//    private PatchMapper patchMapper;

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

}
