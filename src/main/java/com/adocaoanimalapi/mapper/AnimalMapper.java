package com.adocaoanimalapi.mapper;

import com.adocaoanimalapi.dto.AnimalRequestDTO;
import com.adocaoanimalapi.dto.AnimalResponseDTO;
import com.adocaoanimalapi.model.Animal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AnimalMapper {

    Animal toEntity(AnimalRequestDTO dto);

    AnimalResponseDTO toResponseDTO(Animal entity);
}
