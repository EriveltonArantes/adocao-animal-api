package com.adocaoanimalapi.mapper;

import com.adocaoanimalapi.dto.AdotanteRequestDTO;
import com.adocaoanimalapi.dto.AdotanteResponseDTO;
import com.adocaoanimalapi.model.Adotante;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AdotanteMapper {

    Adotante toEntity(AdotanteRequestDTO dto);

    AdotanteResponseDTO toResponseDTO(Adotante entity);
}
