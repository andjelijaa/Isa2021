package com.example.backend.models.mappers;

import com.example.backend.models.Vikendica;
import com.example.backend.models.response.VikendicaPageDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface VikendicaMapper {
    VikendicaMapper INSTANCE = Mappers.getMapper(VikendicaMapper.class);

    VikendicaPageDTO toDto(Vikendica vikendica);

    static List<VikendicaPageDTO> toDto(List<Vikendica> vikendicas){
        return vikendicas
                .stream()
                .map(vikendica -> VikendicaMapper.INSTANCE.toDto(vikendica))
                .collect(Collectors.toList());
    }
}