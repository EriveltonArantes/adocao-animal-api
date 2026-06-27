package com.adocaoanimalapi.service;

import com.adocaoanimalapi.dto.ProcessoAdocaoRequestDTO;
import com.adocaoanimalapi.dto.ProcessoAdocaoResponseDTO;
import com.adocaoanimalapi.exception.ResourceNotFoundException;
import com.adocaoanimalapi.mapper.ProcessoAdocaoMapper;
import com.adocaoanimalapi.model.ProcessoAdocao;
import com.adocaoanimalapi.repository.ProcessoAdocaoRepository;
import com.adocaoanimalapi.repository.AnimalRepository;
import com.adocaoanimalapi.model.Animal;
import com.adocaoanimalapi.repository.AdotanteRepository;
import com.adocaoanimalapi.model.Adotante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProcessoAdocaoService {

    @Autowired
    private ProcessoAdocaoRepository repository;

    @Autowired
    private ProcessoAdocaoMapper mapper;

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private AdotanteRepository adotanteRepository;

    @Transactional(readOnly = true)
    public List<ProcessoAdocaoResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ProcessoAdocaoResponseDTO buscar(Long id) {
        ProcessoAdocao entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("ProcessoAdocao não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public ProcessoAdocaoResponseDTO criar(ProcessoAdocaoRequestDTO dto) {
        ProcessoAdocao entity = mapper.toEntity(dto);
        Animal animal = animalRepository.findById(dto.getAnimalId())
            .orElseThrow(() -> new ResourceNotFoundException("Animal não encontrado com id: " + dto.getAnimalId()));
        entity.setAnimal(animal);
        Adotante adotante = adotanteRepository.findById(dto.getAdotanteId())
            .orElseThrow(() -> new ResourceNotFoundException("Adotante não encontrado com id: " + dto.getAdotanteId()));
        entity.setAdotante(adotante);
        ProcessoAdocao salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public ProcessoAdocaoResponseDTO atualizar(Long id, ProcessoAdocaoRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("ProcessoAdocao não encontrado com id: " + id);
        }
        ProcessoAdocao entity = mapper.toEntity(dto);
        entity.setId(id);
        Animal animal = animalRepository.findById(dto.getAnimalId())
            .orElseThrow(() -> new ResourceNotFoundException("Animal não encontrado com id: " + dto.getAnimalId()));
        entity.setAnimal(animal);
        Adotante adotante = adotanteRepository.findById(dto.getAdotanteId())
            .orElseThrow(() -> new ResourceNotFoundException("Adotante não encontrado com id: " + dto.getAdotanteId()));
        entity.setAdotante(adotante);
        ProcessoAdocao salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("ProcessoAdocao não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
