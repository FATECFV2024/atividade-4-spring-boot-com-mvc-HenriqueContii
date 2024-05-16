package com.projetoAlunos.raiz.dtos;

import com.projetoAlunos.raiz.entities.Aluno;

public class AlunoMinDTO {

    private Long id;
    private String nome;
    private String curso;
    private int idade;
    private boolean matricula;

    public AlunoMinDTO(Long id, String nome, String curso, int idade, boolean matricula) {
        this.id = id;
        this.nome = nome;
        this.curso = curso;
        this.idade = idade;
        this.matricula = matricula;
    }

    public AlunoMinDTO(Aluno entity){
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.curso = entity.getCurso();
        this.idade = entity.getIdade();
        this.matricula = entity.isMatricula();
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
}
