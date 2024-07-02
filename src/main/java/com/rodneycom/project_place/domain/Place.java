package com.rodneycom.project_place.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table
public record Place(
        @Id Long id
        , String name
        , String slug
        , String state
        , @CreatedDate LocalDateTime createdAt
        , @LastModifiedDate LocalDateTime updateAt){

}

