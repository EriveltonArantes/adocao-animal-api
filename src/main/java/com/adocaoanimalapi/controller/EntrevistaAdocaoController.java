package com.adocaoanimalapi.controller;

import com.adocaoanimalapi.dto.EntrevistaAdocaoRequestDTO;
import com.adocaoanimalapi.dto.EntrevistaAdocaoResponseDTO;
import com.adocaoanimalapi.service.EntrevistaAdocaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "EntrevistaAdocao", description = "Gerenciamento de entrevistaadocaos")
@RestController
@RequestMapping("/api/entrevistaadocaos")
public class EntrevistaAdocaoController {

    @Autowired
    private EntrevistaAdocaoService service;

    @Operation(summary = "Listar todos os EntrevistaAdocao")
    @GetMapping
    public List<EntrevistaAdocaoResponseDTO> listar(@RequestParam(required = false) String tipo, @RequestParam(required = false) Long processoAdocaoId) {
        List<EntrevistaAdocaoResponseDTO> resultado = service.listar();
        if (tipo != null && !tipo.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getTipo() != null &&
                item.getTipo().toLowerCase().contains(tipo.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        if (processoAdocaoId != null) {
            resultado = resultado.stream().filter(item -> processoAdocaoId.equals(item.getProcessoAdocaoId())).collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar EntrevistaAdocao por ID")
    @GetMapping("/{id}")
    public EntrevistaAdocaoResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar EntrevistaAdocao")
    @PostMapping
    public ResponseEntity<EntrevistaAdocaoResponseDTO> criar(@Valid @RequestBody EntrevistaAdocaoRequestDTO entrevistaAdocao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(entrevistaAdocao));
    }

    @Operation(summary = "Atualizar EntrevistaAdocao")
    @PutMapping("/{id}")
    public EntrevistaAdocaoResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody EntrevistaAdocaoRequestDTO entrevistaAdocao) {
        return service.atualizar(id, entrevistaAdocao);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir EntrevistaAdocao")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
