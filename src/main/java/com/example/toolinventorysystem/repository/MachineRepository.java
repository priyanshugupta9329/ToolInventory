package com.example.toolinventorysystem.repository;

import com.example.toolinventorysystem.models.Machine;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface MachineRepository extends MongoRepository<Machine, UUID> {

}
