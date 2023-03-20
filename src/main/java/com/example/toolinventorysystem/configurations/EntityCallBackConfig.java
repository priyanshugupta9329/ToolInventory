package com.example.toolinventorysystem.configurations;

import com.example.toolinventorysystem.models.IdInformation;
import com.example.toolinventorysystem.repository.IdInformationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertCallback;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.UUID;


@Log4j2
@Configuration
public class EntityCallBackConfig implements BeforeConvertCallback<Object> {
    @Override
    public Object onBeforeConvert(Object entity, String collection) {

        Field[] fields = entity.getClass().getSuperclass().getDeclaredFields();
        boolean isCreationTime = false;
        for (Field field : fields) {
            field.setAccessible(true);
            try{
                if(field.getName().equals("id") && field.get(entity) == null){
                    field.set(entity, UUID.randomUUID());
                    isCreationTime = true;
                } else if (field.getName().equals("createdAt") && isCreationTime) {
                    field.set(entity, LocalDateTime.now());
                } else if (field.getName().equals("createdBy") && isCreationTime) {
                    field.set(entity, "Anonymous");
                } else if (field.getName().equals("updatedAt")) {
                    field.set(entity, LocalDateTime.now());
                } else if (field.getName().equals("updatedBy")) {
                    field.set(entity, "Anonymous");
                }
            } catch (IllegalAccessException e) {
                log.error("Something went wrong");
            }
        }

        return entity;
    }
}
