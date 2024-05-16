package com.projetoAlunos.raiz.dtos;

import com.projetoAlunos.raiz.entities.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoDTO {

    private Long id;
    private String nome;
    private String curso;
    private int idade;
    private boolean matricula;

    private List<NotaMinDTO> notas = new ArrayList<>();
    private List<EnderecoMinDTO> enderecos = new ArrayList<>();

    public AlunoDTO(Long id, String nome, String curso, int idade, boolean matricula) {
        this.id = id;
        this.nome = nome;
        this.curso = curso;
        this.idade = idade;
        this.matricula = matricula;
    }

    public AlunoDTO(Aluno entity){
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.curso = entity.getCurso();
        this.idade = entity.getIdade();
        this.matricula = entity.isMatricula();

        entity.getNotas().stream().forEach((x) ->
                notas.add(new NotaMinDTO(x)
        ));

        entity.getEnderecos().stream().forEach((x)->
                enderecos.add(new EnderecoMinDTO(x))
        );
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCurso() {
        return curso;
    }

    public int getIdade() {
        return idade;
    }

    public boolean isMatricula() {
        return matricula;
    }

    public List<NotaMinDTO> getNotas() {
        return notas;
    }

    public List<EnderecoMinDTO> getEnderecos() {
        return enderecos;
    }
}
