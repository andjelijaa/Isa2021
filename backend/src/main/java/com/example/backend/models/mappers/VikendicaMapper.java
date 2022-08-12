package com.example.backend.models.mappers;

import com.example.backend.models.Vikendica;
import com.example.backend.models.response.VikendicaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface VikendicaMapper {
    VikendicaMapper INSTANCE = Mappers.getMapper(VikendicaMapper.class);

    VikendicaDTO toDto(Vikendica vikendica);
}