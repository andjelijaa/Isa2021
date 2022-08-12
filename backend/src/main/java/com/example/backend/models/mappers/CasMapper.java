package com.example.backend.models.mappers;

import com.example.backend.models.Cas;
import com.example.backend.models.response.CasDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CasMapper {
    CasMapper INSTANCE = Mappers.getMapper(CasMapper.class);

    CasDTO toDto(Cas cas);
}