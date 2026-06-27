package com.adocaoanimalapi.dto;

import jakarta.validation.constraints.*;

public class EntrevistaAdocaoRequestDTO {

    @NotNull(message = "ProcessoAdocaoId é obrigatório")
    @Positive(message = "ProcessoAdocaoId deve ser um ID válido (positivo)")
    private Long processoAdocaoId;
    @NotNull(message = "data não pode ser nulo")
    private java.time.LocalDateTime data;
    @NotBlank(message = "tipo não pode estar em branco")
    private String tipo;
    @NotBlank(message = "resultado não pode estar em branco")
    private String resultado;
    @Min(value = 0, message = "pontuacao não pode ser negativo")
    @NotNull(message = "pontuacao não pode ser nulo")
    private Integer pontuacao;

    private String observacoes;

    public Long getProcessoAdocaoId() { return processoAdocaoId; }
    public void setProcessoAdocaoId(Long processoAdocaoId) { this.processoAdocaoId = processoAdocaoId; }
    public java.time.LocalDateTime getData() { return data; }
    public void setData(java.time.LocalDateTime data) { this.data = data; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getResultado() { return resultado; }
    public void setResultado(String resultado) { this.resultado = resultado; }
    public Integer getPontuacao() { return pontuacao; }
    public void setPontuacao(Integer pontuacao) { this.pontuacao = pontuacao; }
    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
}
