package com.example.toolinventorysystem.services.serviceImpl;

import com.example.toolinventorysystem.Dto.InputDto.UserInputDto;
import com.example.toolinventorysystem.Dto.OutputDto.UserOutputDto;
import com.example.toolinventorysystem.enums.ApprovalStatus;
import com.example.toolinventorysystem.models.Approval;
import com.example.toolinventorysystem.models.User;
import com.example.toolinventorysystem.repository.ApprovalRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
@AllArgsConstructor
public class ApprovalServiceImpl {
    private ModelMapper modelMapper;
    private final ApprovalRepository approvalRepository;
    public List<Approval> findAll(){
        List<Approval> approval1 = approvalRepository.findAll();
        Type listType = new TypeToken<List<Approval>>(){}.getType();
        List<Approval> approval = modelMapper.map(approval1, listType);
        return approval;
    }

    public Approval saveApproval(Approval approval) {
        Approval approval1 = modelMapper.map(approval, Approval.class);
        approval1 = approvalRepository.save(approval1);
        return modelMapper.map(approval1, Approval.class);
    }
}

