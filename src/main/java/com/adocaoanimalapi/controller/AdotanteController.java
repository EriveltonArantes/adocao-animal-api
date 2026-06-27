package com.adocaoanimalapi.controller;

import com.adocaoanimalapi.dto.AdotanteRequestDTO;
import com.adocaoanimalapi.dto.AdotanteResponseDTO;
import com.adocaoanimalapi.service.AdotanteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Adotante", description = "Gerenciamento de adotantes")
@RestController
@RequestMapping("/api/adotantes")
public class AdotanteController {

    @Autowired
    private AdotanteService service;

    @Operation(summary = "Listar todos os Adotante")
    @GetMapping
    public List<AdotanteResponseDTO> listar(@RequestParam(required = false) String nome) {
        List<AdotanteResponseDTO> resultado = service.listar();
        if (nome != null && !nome.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getNome() != null &&
                item.getNome().toLowerCase().contains(nome.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Adotante por ID")
    @GetMapping("/{id}")
    public AdotanteResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Adotante")
    @PostMapping
    public ResponseEntity<AdotanteResponseDTO> criar(@Valid @RequestBody AdotanteRequestDTO adotante) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(adotante));
    }

    @Operation(summary = "Atualizar Adotante")
    @PutMapping("/{id}")
    public AdotanteResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody AdotanteRequestDTO adotante) {
        return service.atualizar(id, adotante);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Adotante")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
