package com.projetoAlunos.raiz.services;

import com.projetoAlunos.raiz.services.erros.NaoEncontradoException;
import com.projetoAlunos.raiz.repositories.AlunoRepository;
import com.projetoAlunos.raiz.repositories.NotaRepository;
import com.projetoAlunos.raiz.dtos.NotaDTO;
import com.projetoAlunos.raiz.entities.Aluno;
import com.projetoAlunos.raiz.entities.Nota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaService {

    @Autowired
     private NotaRepository repository;

    @Autowired
    private AlunoRepository alunoRepository;

    public List<NotaDTO> findAll(){
        List<Nota> list = (List<Nota>) repository.findAll();
        return list.stream().map(x -> new NotaDTO(x)).toList();
    }

    public NotaDTO findByID(Long id){
        Nota entity = repository.findById(id).orElseThrow(() -> new NaoEncontradoException("NOTA NÃO ENCONTRADA"));
        return new NotaDTO(entity);
    }

    public NotaDTO insert(NotaDTO dto) {
        Nota entity = new Nota();
        copyDtoToEntity(entity, dto);

        entity = repository.save(entity);
        return new NotaDTO(entity);
    }

    public NotaDTO update(Long id, NotaDTO dto) {
        Nota entity = repository.findById(id).orElseThrow(() -> new NaoEncontradoException("NOTA NÃO ENCONTRADA"));
        copyDtoToEntity(entity, dto);

        entity = repository.save(entity);
        return new NotaDTO(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    private void copyDtoToEntity(Nota entity, NotaDTO dto){
        entity.setNota(dto.getNota());
        entity.setNome_disciplina(dto.getNome_disciplina());

        Aluno aluno = alunoRepository.findById(dto.getAluno().getId()).orElseThrow(() -> new NaoEncontradoException("ALUNO NÃO ENCONRTADO"));
        entity.setAluno(aluno);
    }
}
