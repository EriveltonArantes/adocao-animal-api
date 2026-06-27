package com.adocaoanimalapi.controller;

import com.adocaoanimalapi.model.Animal;
import com.adocaoanimalapi.model.Adotante;
import com.adocaoanimalapi.model.ProcessoAdocao;
import com.adocaoanimalapi.model.EntrevistaAdocao;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@Tag(name = "Dashboard", description = "KPIs e totais do sistema")
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private com.adocaoanimalapi.repository.AnimalRepository animalRepository;

    @Autowired
    private com.adocaoanimalapi.repository.AdotanteRepository adotanteRepository;

    @Autowired
    private com.adocaoanimalapi.repository.ProcessoAdocaoRepository processoAdocaoRepository;

    @Autowired
    private com.adocaoanimalapi.repository.EntrevistaAdocaoRepository entrevistaAdocaoRepository;

    @Operation(summary = "Resumo com totais, somas e gráficos de status")
    @Transactional(readOnly = true)
    @GetMapping("/resumo")
    public Map<String, Object> resumo() {
        Map<String, Object> resumo = new LinkedHashMap<>();
        resumo.put("totalAnimal", animalRepository.count());
        resumo.put("somaIdadeAnimal", animalRepository.findAll().stream().filter(e -> e.getIdade() != null).mapToInt(e -> e.getIdade()).sum());
        resumo.put("graficoAnimal", animalRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        resumo.put("totalAdotante", adotanteRepository.count());
        resumo.put("somaRendaAdotante", adotanteRepository.findAll().stream().filter(e -> e.getRenda() != null).mapToDouble(e -> e.getRenda()).sum());
        resumo.put("totalProcessoAdocao", processoAdocaoRepository.count());
        resumo.put("graficoProcessoAdocao", processoAdocaoRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        resumo.put("totalEntrevistaAdocao", entrevistaAdocaoRepository.count());
        resumo.put("somaPontuacaoEntrevistaAdocao", entrevistaAdocaoRepository.findAll().stream().filter(e -> e.getPontuacao() != null).mapToInt(e -> e.getPontuacao()).sum());
        return resumo;
    }
}
