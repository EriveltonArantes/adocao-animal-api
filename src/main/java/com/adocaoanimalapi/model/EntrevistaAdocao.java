package com.adocaoanimalapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "entrevistaadocoes")
public class EntrevistaAdocao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "processoAdocao_id")
    private ProcessoAdocao processoAdocao;
    private java.time.LocalDateTime data;
    @Column(nullable = false)
    private String tipo;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String resultado;
    private Integer pontuacao;
    @Column(columnDefinition = "TEXT")
    private String observacoes;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public ProcessoAdocao getProcessoAdocao() { return processoAdocao; }
    public void setProcessoAdocao(ProcessoAdocao processoAdocao) { this.processoAdocao = processoAdocao; }
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
