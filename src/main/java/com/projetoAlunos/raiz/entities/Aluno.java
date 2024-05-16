package com.projetoAlunos.raiz.entities;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "tb_aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String curso;
    private int idade;
    private boolean matricula;

    @OneToMany(mappedBy = "aluno")
    private List<Nota> notas = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "tb_aluno_endereco",
            joinColumns = @JoinColumn (name = "id_aluno"),
            inverseJoinColumns = @JoinColumn(name = "id_endereco")

    )
    private Set<Endereco> enderecos = new HashSet<>();

    public Aluno(){

    }

    public Aluno(Long id, String nome, String curso, int idade, boolean matricula) {
        this.id = id;
        this.nome = nome;
        this.curso = curso;
        this.idade = idade;
        this.matricula = matricula;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public boolean isMatricula() {
        return matricula;
    }

    public void setMatricula(boolean matricula) {
        this.matricula = matricula;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public Set<Endereco> getEnderecos() {
        return enderecos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Aluno aluno = (Aluno) o;

        return Objects.equals(id, aluno.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
