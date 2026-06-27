package com.adocaoanimalapi.dto;

public class EntrevistaAdocaoResponseDTO {

    private Long id;
    private Long processoAdocaoId;
    private java.time.LocalDateTime data;
    private String tipo;
    private String resultado;
    private Integer pontuacao;
    private String observacoes;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
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
