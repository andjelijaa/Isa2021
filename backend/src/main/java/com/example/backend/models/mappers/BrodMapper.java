package com.example.backend.models.mappers;

import com.example.backend.models.Brod;
import com.example.backend.models.response.BrodDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface BrodMapper {
    BrodMapper INSTANCE = Mappers.getMapper(BrodMapper.class);

    BrodDTO toDto(Brod brod);

    static List<BrodDTO> toDto(List<Brod> brods){
        return brods
                .stream()
                .map(brod -> BrodMapper.INSTANCE.toDto(brod))
                .collect(Collectors.toList());
    }
}