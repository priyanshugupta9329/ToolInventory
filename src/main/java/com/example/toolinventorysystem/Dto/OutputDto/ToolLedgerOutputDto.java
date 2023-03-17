package com.example.toolinventorysystem.Dto.OutputDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class ToolLedgerOutputDto {
    private UUID userId;
    private String showUserId;
    private UUID machineId;
    private List<UUID> toolId;
    private UUID approvalId;
    private Boolean isInUse;
    private LocalDateTime startDateTime;
    private LocalDateTime returnDateTime;
}
