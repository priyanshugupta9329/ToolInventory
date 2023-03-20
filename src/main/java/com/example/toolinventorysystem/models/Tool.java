package com.example.toolinventorysystem.models;

import com.example.toolinventorysystem.enums.ToolType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Getter
@Setter
@Document
public class Tool extends BaseModel{

    private UUID machineId;

    private ToolType toolType;

    //TOOL TYPE ID IS NEEDED

    //QUANTITY OF EACH TOOL TYPE

    private float lifecycle;


}
