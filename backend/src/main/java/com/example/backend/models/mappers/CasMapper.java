package com.example.backend.models.mappers;

import com.example.backend.models.Cas;
import com.example.backend.models.response.CasDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface CasMapper {
    CasMapper INSTANCE = Mappers.getMapper(CasMapper.class);

    CasDTO toDto(Cas cas);

    static List<CasDTO> toDto(List<Cas> cass){
        return cass
                .stream()
                .map(cas -> CasMapper.INSTANCE.toDto(cas))
                .collect(Collectors.toList());
    }
}