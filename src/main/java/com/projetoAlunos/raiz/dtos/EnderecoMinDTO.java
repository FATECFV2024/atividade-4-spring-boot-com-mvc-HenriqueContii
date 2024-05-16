package com.projetoAlunos.raiz.dtos;

import com.projetoAlunos.raiz.entities.Endereco;

public class EnderecoMinDTO {

    private Long id;
    private String rua;
    private String cidade;
    private String estado;
    private String cep;
    private Integer numero;

    public EnderecoMinDTO(Long id, String rua, String cidade, String estado, String cep, Integer numero) {
        this.id = id;
        this.rua = rua;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.numero = numero;
    }

    public EnderecoMinDTO(Endereco entity){
        id = entity.getId();
        rua = entity.getRua();
        cidade = entity.getCidade();
        estado = entity.getEstado();
        cep = entity.getCep();
        numero = entity.getNumero();
    }

    public Long getId() {
        return id;
    }

    public String getRua() {
        return rua;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getCep() {
        return cep;
    }

    public Integer getNumero() {
        return numero;
    }
}
