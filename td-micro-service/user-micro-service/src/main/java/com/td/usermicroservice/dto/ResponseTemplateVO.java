package com.td.usermicroservice.dto;


import com.td.usermicroservice.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {

    private UserEntity user;
    private Department department;
}
