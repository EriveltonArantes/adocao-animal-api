package com.adocaoanimalapi.dto;

import jakarta.validation.constraints.*;

public class AdotanteRequestDTO {

    @NotBlank(message = "nome não pode estar em branco")
    private String nome;
    @NotBlank(message = "cpf não pode estar em branco")
    @Size(min = 11, max = 14, message = "cpf deve ter entre 11 e 14 dígitos")
    private String cpf;
    @NotBlank(message = "email não pode estar em branco")
    @Email(message = "email precisa ser um e-mail válido")
    private String email;
    @NotBlank(message = "telefone não pode estar em branco")
    private String telefone;
    @NotBlank(message = "endereco não pode estar em branco")
    private String endereco;
    @NotBlank(message = "cidade não pode estar em branco")
    private String cidade;
    @NotNull(message = "renda não pode ser nulo")
    private Double renda;
    @NotBlank(message = "moradia não pode estar em branco")
    private String moradia;

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }
    public Double getRenda() { return renda; }
    public void setRenda(Double renda) { this.renda = renda; }
    public String getMoradia() { return moradia; }
    public void setMoradia(String moradia) { this.moradia = moradia; }
}
