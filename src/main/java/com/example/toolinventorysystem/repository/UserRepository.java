package com.example.toolinventorysystem.repository;

import com.example.toolinventorysystem.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface UserRepository extends MongoRepository<User, UUID> {
//    ResponseEntity<?> deleteById(String id);  //CHECK THIS I DID SAME AS TODO BUT IT GAVE ERROR IN SERVICE IMPLEMENTATION
}
