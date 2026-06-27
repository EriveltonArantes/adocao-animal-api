package com.adocaoanimalapi.dto;

public class ProcessoAdocaoResponseDTO {

    private Long id;
    private Long animalId;
    private Long adotanteId;
    private java.time.LocalDateTime dataInicio;
    private String status;
    private String responsavel;
    private String observacoes;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
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
