package com.example.toolinventorysystem.services;
import com.example.toolinventorysystem.models.Approval;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ApprovalService {
    public List<Approval> findAll();
    public Approval save(Approval approval);
}
