package com.adocaoanimalapi.controller;

import com.adocaoanimalapi.dto.ProcessoAdocaoRequestDTO;
import com.adocaoanimalapi.dto.ProcessoAdocaoResponseDTO;
import com.adocaoanimalapi.service.ProcessoAdocaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "ProcessoAdocao", description = "Gerenciamento de processoadocaos")
@RestController
@RequestMapping("/api/processoadocaos")
public class ProcessoAdocaoController {

    @Autowired
    private ProcessoAdocaoService service;

    @Operation(summary = "Listar todos os ProcessoAdocao")
    @GetMapping
    public List<ProcessoAdocaoResponseDTO> listar(@RequestParam(required = false) String responsavel, @RequestParam(required = false) Long animalId, @RequestParam(required = false) Long adotanteId) {
        List<ProcessoAdocaoResponseDTO> resultado = service.listar();
        if (responsavel != null && !responsavel.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getResponsavel() != null &&
                item.getResponsavel().toLowerCase().contains(responsavel.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        if (animalId != null) {
            resultado = resultado.stream().filter(item -> animalId.equals(item.getAnimalId())).collect(java.util.stream.Collectors.toList());
        }
        if (adotanteId != null) {
            resultado = resultado.stream().filter(item -> adotanteId.equals(item.getAdotanteId())).collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar ProcessoAdocao por ID")
    @GetMapping("/{id}")
    public ProcessoAdocaoResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar ProcessoAdocao")
    @PostMapping
    public ResponseEntity<ProcessoAdocaoResponseDTO> criar(@Valid @RequestBody ProcessoAdocaoRequestDTO processoAdocao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(processoAdocao));
    }

    @Operation(summary = "Atualizar ProcessoAdocao")
    @PutMapping("/{id}")
    public ProcessoAdocaoResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody ProcessoAdocaoRequestDTO processoAdocao) {
        return service.atualizar(id, processoAdocao);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir ProcessoAdocao")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
