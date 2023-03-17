package com.example.toolinventorysystem;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import com.example.toolinventorysystem.utils.PatchMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ToolInventorySystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToolInventorySystemApplication.class, args);
//
//        public ModelMapper modelMapper(){
//            return new ModelMapper();
//        }
    }
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public PatchMapper patchMapper(){
        PatchMapper patchMapper = new PatchMapper();
        patchMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT).setPropertyCondition(Conditions.isNotNull());
        return patchMapper;
    }

}
