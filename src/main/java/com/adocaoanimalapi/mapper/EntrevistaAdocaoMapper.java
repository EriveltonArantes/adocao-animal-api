package com.adocaoanimalapi.mapper;

import com.adocaoanimalapi.dto.EntrevistaAdocaoRequestDTO;
import com.adocaoanimalapi.dto.EntrevistaAdocaoResponseDTO;
import com.adocaoanimalapi.model.EntrevistaAdocao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EntrevistaAdocaoMapper {

    @Mapping(target = "processoAdocao", ignore = true)
    EntrevistaAdocao toEntity(EntrevistaAdocaoRequestDTO dto);

    @Mapping(target = "processoAdocaoId", source = "processoAdocao.id")
    EntrevistaAdocaoResponseDTO toResponseDTO(EntrevistaAdocao entity);
}
