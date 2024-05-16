package com.projetoAlunos.raiz.services.erros;

public class NaoEncontradoException extends RuntimeException{

    public NaoEncontradoException(String msg) {
        super(msg);
    }
}
