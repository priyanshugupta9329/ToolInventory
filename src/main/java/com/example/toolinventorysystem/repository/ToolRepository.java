package com.example.toolinventorysystem.repository;
import com.example.toolinventorysystem.Dto.InputDto.ToolDto;
import com.example.toolinventorysystem.models.Tool;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ToolRepository extends MongoRepository<ToolDto, UUID> {
}
