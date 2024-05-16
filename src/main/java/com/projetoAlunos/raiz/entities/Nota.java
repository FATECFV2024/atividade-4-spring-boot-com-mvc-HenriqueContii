package com.projetoAlunos.raiz.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_nota")
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome_disciplina;
    private Double nota;

    @ManyToOne
    @JoinColumn(name = "id_aluno")
    private Aluno aluno;

    public Nota(){

    }

    public Nota(Long id, String nome_disciplina, Double nota) {
        this.id = id;
        this.nome_disciplina = nome_disciplina;
        this.nota = nota;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome_disciplina() {
        return nome_disciplina;
    }

    public void setNome_disciplina(String nome_disciplina) {
        this.nome_disciplina = nome_disciplina;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Nota nota = (Nota) o;

        return Objects.equals(id, nota.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
