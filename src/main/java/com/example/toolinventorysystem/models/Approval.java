package com.example.toolinventorysystem.models;

import com.example.toolinventorysystem.enums.ApprovalStatus;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Getter
@Setter
@Document
public class Approval extends BaseModel {
    private UUID userId;
    private UUID machineId;
    private List<UUID> toolId;
    private LocalDateTime requestAt;
    private LocalDateTime approvedAt;
    private ApprovalStatus status;
}
