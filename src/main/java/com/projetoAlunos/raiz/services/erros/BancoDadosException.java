package com.projetoAlunos.raiz.services.erros;

public class BancoDadosException extends RuntimeException{
    public BancoDadosException(String msg) {
        super(msg);
    }
}
