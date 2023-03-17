package com.example.toolinventorysystem.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;


@Getter
@Setter
@Component
public class BaseModel {
    protected UUID id;
    protected LocalDate createdAt;
    protected LocalDate updatedAt;
}
