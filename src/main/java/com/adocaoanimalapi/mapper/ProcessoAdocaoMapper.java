package com.adocaoanimalapi.mapper;

import com.adocaoanimalapi.dto.ProcessoAdocaoRequestDTO;
import com.adocaoanimalapi.dto.ProcessoAdocaoResponseDTO;
import com.adocaoanimalapi.model.ProcessoAdocao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProcessoAdocaoMapper {

    @Mapping(target = "animal", ignore = true)
    @Mapping(target = "adotante", ignore = true)
    ProcessoAdocao toEntity(ProcessoAdocaoRequestDTO dto);

    @Mapping(target = "animalId", source = "animal.id")
    @Mapping(target = "adotanteId", source = "adotante.id")
    ProcessoAdocaoResponseDTO toResponseDTO(ProcessoAdocao entity);
}
