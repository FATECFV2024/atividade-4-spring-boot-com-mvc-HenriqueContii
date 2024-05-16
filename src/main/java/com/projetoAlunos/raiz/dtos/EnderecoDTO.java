package com.projetoAlunos.raiz.dtos;

import com.projetoAlunos.raiz.entities.Endereco;

import java.util.HashSet;
import java.util.Set;

public class EnderecoDTO {
    private Long id;
    private String rua;
    private String cidade;
    private String estado;
    private String cep;
    private Integer numero;

    private Set<AlunoMinDTO> alunos = new HashSet<>();

    public EnderecoDTO(Long id, String rua, String cidade, String estado, String cep, Integer numero) {
        this.id = id;
        this.rua = rua;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.numero = numero;
    }

    public EnderecoDTO(Endereco entity){
        id = entity.getId();
        rua = entity.getRua();
        cidade = entity.getCidade();
        estado = entity.getEstado();
        cep = entity.getCep();
        numero = entity.getNumero();

        entity.getAlunos().stream().forEach((x) ->
                alunos.add(new AlunoMinDTO(x))
        );
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

    public Set<AlunoMinDTO> getAlunos() {
        return alunos;
    }
}
