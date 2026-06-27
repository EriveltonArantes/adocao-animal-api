package com.adocaoanimalapi.dto;

import jakarta.validation.constraints.*;

public class AnimalRequestDTO {


    private String especie;

    private String raca;
    @NotBlank(message = "nome não pode estar em branco")
    private String nome;
    @Min(value = 0, message = "idade não pode ser negativo")
    @NotNull(message = "idade não pode ser nulo")
    private Integer idade;

    private String porte;
    @NotBlank(message = "sexo não pode estar em branco")
    private String sexo;
    @NotNull(message = "vacinado não pode ser nulo")
    private Boolean vacinado;
    @NotNull(message = "castrado não pode ser nulo")
    private Boolean castrado;
    @NotBlank(message = "descricao não pode estar em branco")
    private String descricao;
    @NotBlank(message = "status não pode estar em branco")
    private String status;

    public String getEspecie() { return especie; }
    public void setEspecie(String especie) { this.especie = especie; }
    public String getRaca() { return raca; }
    public void setRaca(String raca) { this.raca = raca; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Integer getIdade() { return idade; }
    public void setIdade(Integer idade) { this.idade = idade; }
    public String getPorte() { return porte; }
    public void setPorte(String porte) { this.porte = porte; }
    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }
    public Boolean getVacinado() { return vacinado; }
    public void setVacinado(Boolean vacinado) { this.vacinado = vacinado; }
    public Boolean getCastrado() { return castrado; }
    public void setCastrado(Boolean castrado) { this.castrado = castrado; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
