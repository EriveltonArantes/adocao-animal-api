package com.adocaoanimalapi.service;

import com.adocaoanimalapi.dto.EntrevistaAdocaoRequestDTO;
import com.adocaoanimalapi.dto.EntrevistaAdocaoResponseDTO;
import com.adocaoanimalapi.exception.ResourceNotFoundException;
import com.adocaoanimalapi.mapper.EntrevistaAdocaoMapper;
import com.adocaoanimalapi.model.EntrevistaAdocao;
import com.adocaoanimalapi.repository.EntrevistaAdocaoRepository;
import com.adocaoanimalapi.repository.ProcessoAdocaoRepository;
import com.adocaoanimalapi.model.ProcessoAdocao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class EntrevistaAdocaoService {

    @Autowired
    private EntrevistaAdocaoRepository repository;

    @Autowired
    private EntrevistaAdocaoMapper mapper;

    @Autowired
    private ProcessoAdocaoRepository processoAdocaoRepository;

    @Transactional(readOnly = true)
    public List<EntrevistaAdocaoResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public EntrevistaAdocaoResponseDTO buscar(Long id) {
        EntrevistaAdocao entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("EntrevistaAdocao não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public EntrevistaAdocaoResponseDTO criar(EntrevistaAdocaoRequestDTO dto) {
        EntrevistaAdocao entity = mapper.toEntity(dto);
        ProcessoAdocao processoAdocao = processoAdocaoRepository.findById(dto.getProcessoAdocaoId())
            .orElseThrow(() -> new ResourceNotFoundException("ProcessoAdocao não encontrado com id: " + dto.getProcessoAdocaoId()));
        entity.setProcessoAdocao(processoAdocao);
        EntrevistaAdocao salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public EntrevistaAdocaoResponseDTO atualizar(Long id, EntrevistaAdocaoRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("EntrevistaAdocao não encontrado com id: " + id);
        }
        EntrevistaAdocao entity = mapper.toEntity(dto);
        entity.setId(id);
        ProcessoAdocao processoAdocao = processoAdocaoRepository.findById(dto.getProcessoAdocaoId())
            .orElseThrow(() -> new ResourceNotFoundException("ProcessoAdocao não encontrado com id: " + dto.getProcessoAdocaoId()));
        entity.setProcessoAdocao(processoAdocao);
        EntrevistaAdocao salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("EntrevistaAdocao não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
