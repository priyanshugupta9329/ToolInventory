package com.example.toolinventorysystem.services.serviceImpl;

import com.example.toolinventorysystem.enums.ApprovalStatus;
import com.example.toolinventorysystem.models.Approval;
import com.example.toolinventorysystem.models.User;
import com.example.toolinventorysystem.repository.ApprovalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ApprovalServiceImpl {
    private final ApprovalRepository approvalRepository;
    public List<Approval> findAll() {
        return approvalRepository.findAll();
    }
    public Approval save(Approval approval) {return approvalRepository.save(approval);
    }
}
