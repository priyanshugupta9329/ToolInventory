package com.example.toolinventorysystem.repository;

import com.example.toolinventorysystem.Dto.OutputDto.ToolLedgerOutputDto;
import com.example.toolinventorysystem.models.ToolLedger;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface ToolLedgerRepository extends MongoRepository<ToolLedger, String> {
    List<ToolLedgerOutputDto> findByUsername(String username);

    List<ToolLedgerOutputDto> findByUserId(String showUserId);
}
