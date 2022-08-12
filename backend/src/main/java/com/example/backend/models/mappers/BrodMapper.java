package com.example.backend.models.mappers;

import com.example.backend.models.Brod;
import com.example.backend.models.response.BrodDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BrodMapper {
    BrodMapper INSTANCE = Mappers.getMapper(BrodMapper.class);

    BrodDTO toDto(Brod brod);
}