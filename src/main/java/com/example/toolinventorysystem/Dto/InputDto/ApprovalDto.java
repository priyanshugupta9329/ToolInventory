package com.example.toolinventorysystem.Dto.InputDto;

import com.example.toolinventorysystem.enums.ApprovalStatus;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class ApprovalDto {
    private UUID userId;
    private UUID machineId;
    private List<UUID> toolId;
    private LocalDateTime requestAt;
    private LocalDateTime approvedAt;
    private ApprovalStatus status;
}
