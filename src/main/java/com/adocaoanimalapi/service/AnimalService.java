package com.adocaoanimalapi.service;

import com.adocaoanimalapi.dto.AnimalRequestDTO;
import com.adocaoanimalapi.dto.AnimalResponseDTO;
import com.adocaoanimalapi.exception.ResourceNotFoundException;
import com.adocaoanimalapi.mapper.AnimalMapper;
import com.adocaoanimalapi.model.Animal;
import com.adocaoanimalapi.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AnimalService {

    @Autowired
    private AnimalRepository repository;

    @Autowired
    private AnimalMapper mapper;

    @Transactional(readOnly = true)
    public List<AnimalResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public AnimalResponseDTO buscar(Long id) {
        Animal entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Animal não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public AnimalResponseDTO criar(AnimalRequestDTO dto) {
        Animal entity = mapper.toEntity(dto);
        Animal salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public AnimalResponseDTO atualizar(Long id, AnimalRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Animal não encontrado com id: " + id);
        }
        Animal entity = mapper.toEntity(dto);
        entity.setId(id);
        Animal salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Animal não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
