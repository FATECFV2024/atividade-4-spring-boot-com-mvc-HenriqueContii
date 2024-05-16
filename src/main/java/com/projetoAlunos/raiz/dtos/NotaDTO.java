package com.projetoAlunos.raiz.dtos;

import com.projetoAlunos.raiz.entities.Aluno;
import com.projetoAlunos.raiz.entities.Nota;

public class NotaDTO {

    private Long id;
    private String nome_disciplina;
    private Double nota;

    private AlunoMinDTO aluno;

    public NotaDTO(){

    }

    public NotaDTO(Long id, String nome_disciplina, Double nota){
        this.id = id;
        this.nome_disciplina = nome_disciplina;
        this.nota = nota;
    }

    public NotaDTO(Long id, String nome_disciplina, Double nota, Aluno aluno) {
        this.id = id;
        this.nome_disciplina = nome_disciplina;
        this.nota = nota;
        this.aluno = new AlunoMinDTO(aluno);
    }

    public NotaDTO(Nota entity){
        id = entity.getId();
        nome_disciplina = entity.getNome_disciplina();
        nota = entity.getNota();

        this.aluno = new AlunoMinDTO(entity.getAluno());

    }

    public Long getId() {
        return id;
    }

    public String getNome_disciplina() {
        return nome_disciplina;
    }

    public Double getNota() {
        return nota;
    }

    public AlunoMinDTO getAluno() {
        return aluno;
    }
}
