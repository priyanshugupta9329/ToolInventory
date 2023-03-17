package com.example.toolinventorysystem.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;



@Getter
@Setter
@Document
public class ToolLedger extends BaseModel{
    private UUID userId;

    private String username;
    private String showUserId;
    private UUID machineId;
    private List<UUID> toolId;
    private UUID approvalId;
    private Boolean isInUse;
    private LocalDateTime startDateTime;
    private LocalDateTime returnDateTime;

}
