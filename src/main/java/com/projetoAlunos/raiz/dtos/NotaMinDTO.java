package com.projetoAlunos.raiz.dtos;

import com.projetoAlunos.raiz.entities.Nota;

public class NotaMinDTO {

    private final Long id;
    private final String nome_disciplina;
    private final Double nota;

    public NotaMinDTO(Long id, String nome_disciplina, Double nota) {
        this.id = id;
        this.nome_disciplina = nome_disciplina;
        this.nota = nota;
    }

    public NotaMinDTO(Nota entity){
        id = entity.getId();
        nome_disciplina = entity.getNome_disciplina();
        nota = entity.getNota();
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
}
