package com.projetoAlunos.raiz.services;

import com.projetoAlunos.raiz.dtos.EnderecoMinDTO;
import com.projetoAlunos.raiz.entities.Endereco;
import com.projetoAlunos.raiz.repositories.EnderecoRepository;
import com.projetoAlunos.raiz.services.erros.NaoEncontradoException;
import com.projetoAlunos.raiz.dtos.NotaMinDTO;
import com.projetoAlunos.raiz.entities.Nota;
import com.projetoAlunos.raiz.repositories.AlunoRepository;
import com.projetoAlunos.raiz.dtos.AlunoDTO;
import com.projetoAlunos.raiz.entities.Aluno;
import com.projetoAlunos.raiz.repositories.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService{

    @Autowired
    private AlunoRepository repository;

    @Autowired
    private NotaRepository notaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<AlunoDTO> findAll(){
        List<Aluno> list = (List<Aluno>) repository.findAll();
        return list.stream().map(AlunoDTO::new).toList();
    }

    public AlunoDTO findByID(Long id){
        Aluno entity = repository.findById(id).orElseThrow(() -> new NaoEncontradoException("ALUNO NÃO ENCOTNRADO"));
        return new AlunoDTO(entity);
    }

    public AlunoDTO insert(AlunoDTO dto) {
        Aluno entity = new Aluno();
        copyDtoToEntity(entity, dto);
        return new AlunoDTO(entity);
    }

    public AlunoDTO update(Long id, AlunoDTO dto) {
        Aluno entity = repository.findById(id).orElseThrow(() -> new NaoEncontradoException("ALUNO NÃO ENCOTNRADO"));
        copyDtoToEntity(entity, dto);
        return new AlunoDTO(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    private void copyDtoToEntity(Aluno entity, AlunoDTO dto){
        entity.setNome(dto.getNome());
        entity.setCurso(dto.getCurso());
        entity.setIdade(dto.getIdade());
        entity.setIdade(dto.getIdade());
        entity.setMatricula(dto.isMatricula());

        for (NotaMinDTO notaDTO : dto.getNotas()) {
            Nota nota = new Nota();
            nota.setNota(notaDTO.getNota());
            nota.setNome_disciplina(notaDTO.getNome_disciplina());
            nota = notaRepository.save(nota);

            nota.setAluno(entity);
            entity.getNotas().add(nota);
        }

        entity = repository.save(entity);

        for (EnderecoMinDTO notaDTO : dto.getEnderecos()) {
            Endereco endereco = new Endereco();
            endereco.setRua(notaDTO.getRua());
            endereco.setNumero(notaDTO.getNumero());
            endereco.setCidade(notaDTO.getCidade());
            endereco.setEstado(notaDTO.getEstado());
            endereco.setCep(notaDTO.getCep());
            endereco.getAlunos().add(entity);

            endereco = enderecoRepository.save(endereco);
            entity.getEnderecos().add(endereco);
        }
        entity = repository.save(entity);
    }
}
