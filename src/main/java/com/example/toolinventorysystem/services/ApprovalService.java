package com.example.toolinventorysystem.services;
import com.example.toolinventorysystem.Dto.InputDto.ApprovalDto;
import com.example.toolinventorysystem.models.Approval;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ApprovalService {
    public List<Approval> findAll();
    public ApprovalDto requestApproval(ApprovalDto approvalDto);
    public ApprovalDto approveApproval(ApprovalDto approvalDto);
    public ApprovalDto rejectApproval(ApprovalDto approvalDto);
}
