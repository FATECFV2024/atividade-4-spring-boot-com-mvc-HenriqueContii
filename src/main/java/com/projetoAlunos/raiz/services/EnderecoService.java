package com.projetoAlunos.raiz.services;

import com.projetoAlunos.raiz.dtos.EnderecoDTO;
import com.projetoAlunos.raiz.services.erros.BancoDadosException;
import com.projetoAlunos.raiz.dtos.AlunoMinDTO;
import com.projetoAlunos.raiz.entities.Aluno;
import com.projetoAlunos.raiz.entities.Endereco;
import com.projetoAlunos.raiz.repositories.AlunoRepository;
import com.projetoAlunos.raiz.repositories.EnderecoRepository;
import com.projetoAlunos.raiz.services.erros.NaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    @Autowired
    private AlunoRepository alunoRepository;

    public List<EnderecoDTO> findAll(){
        List<Endereco> list = (List<Endereco>) repository.findAll();
        return list.stream().map(EnderecoDTO::new).toList();
    }

    public EnderecoDTO findByID(Long id){
        Endereco entity = repository.findById(id).orElseThrow(() -> new NaoEncontradoException("ALUNO NÃO ENCOTNRADO"));
        return new EnderecoDTO(entity);
    }

    public EnderecoDTO insert(EnderecoDTO dto) {
        Endereco entity = new Endereco();
        copyDtoToEntity(entity, dto);

        entity = repository.save(entity);
        return new EnderecoDTO(entity);
    }

    public EnderecoDTO update(Long id, EnderecoDTO dto) {
        Endereco entity = repository.findById(id).orElseThrow(() -> new NaoEncontradoException("ALUNO NÃO ENCOTNRADO"));
        copyDtoToEntity(entity, dto);

        entity = repository.save(entity);
        return new EnderecoDTO(entity);
    }

    public void deleteById(Long id) {
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new BancoDadosException("FALHA");
        }
    }

    private void copyDtoToEntity(Endereco entity, EnderecoDTO dto){
        entity.setCep(dto.getCep());
        entity.setCidade(dto.getCidade());
        entity.setEstado(dto.getEstado());
        entity.setNumero(dto.getNumero());
        entity.setRua(dto.getRua());

        for (AlunoMinDTO alunoDTO : dto.getAlunos()) {
            Aluno aluno = alunoRepository.findById(alunoDTO.getId()).orElseThrow(() -> new NaoEncontradoException("ALUNO NÃO ENCOTNRADO"));;
            aluno.getEnderecos().add(entity);
            entity.getAlunos().add(aluno);
        }
    }
}
