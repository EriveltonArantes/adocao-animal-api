package com.adocaoanimalapi.service;

import com.adocaoanimalapi.dto.AdotanteRequestDTO;
import com.adocaoanimalapi.dto.AdotanteResponseDTO;
import com.adocaoanimalapi.exception.ResourceNotFoundException;
import com.adocaoanimalapi.mapper.AdotanteMapper;
import com.adocaoanimalapi.model.Adotante;
import com.adocaoanimalapi.repository.AdotanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AdotanteService {

    @Autowired
    private AdotanteRepository repository;

    @Autowired
    private AdotanteMapper mapper;

    @Transactional(readOnly = true)
    public List<AdotanteResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public AdotanteResponseDTO buscar(Long id) {
        Adotante entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Adotante não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public AdotanteResponseDTO criar(AdotanteRequestDTO dto) {
        Adotante entity = mapper.toEntity(dto);
        Adotante salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public AdotanteResponseDTO atualizar(Long id, AdotanteRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Adotante não encontrado com id: " + id);
        }
        Adotante entity = mapper.toEntity(dto);
        entity.setId(id);
        Adotante salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Adotante não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
