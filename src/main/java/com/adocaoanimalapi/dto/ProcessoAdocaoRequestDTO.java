package com.adocaoanimalapi.dto;

import jakarta.validation.constraints.*;

public class ProcessoAdocaoRequestDTO {

    @NotNull(message = "AnimalId é obrigatório")
    @Positive(message = "AnimalId deve ser um ID válido (positivo)")
    private Long animalId;
    @NotNull(message = "AdotanteId é obrigatório")
    @Positive(message = "AdotanteId deve ser um ID válido (positivo)")
    private Long adotanteId;
    @FutureOrPresent(message = "data inicio não pode ser retroativo")
    @NotNull(message = "data inicio não pode ser nulo")
    private java.time.LocalDateTime dataInicio;
    @NotBlank(message = "status não pode estar em branco")
    private String status;
    @NotBlank(message = "responsavel não pode estar em branco")
    private String responsavel;

    private String observacoes;

    public Long getAnimalId() { return animalId; }
    public void setAnimalId(Long animalId) { this.animalId = animalId; }
    public Long getAdotanteId() { return adotanteId; }
    public void setAdotanteId(Long adotanteId) { this.adotanteId = adotanteId; }
    public java.time.LocalDateTime getDataInicio() { return dataInicio; }
    public void setDataInicio(java.time.LocalDateTime dataInicio) { this.dataInicio = dataInicio; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getResponsavel() { return responsavel; }
    public void setResponsavel(String responsavel) { this.responsavel = responsavel; }
    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
}
