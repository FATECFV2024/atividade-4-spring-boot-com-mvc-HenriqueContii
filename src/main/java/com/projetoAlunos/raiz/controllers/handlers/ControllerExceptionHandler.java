package com.projetoAlunos.raiz.controllers.handlers;

import com.projetoAlunos.raiz.services.erros.BancoDadosException;
import com.projetoAlunos.raiz.dtos.CustomError;
import com.projetoAlunos.raiz.services.erros.NaoEncontradoException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(NaoEncontradoException.class)
    public ResponseEntity<CustomError> notFound(NaoEncontradoException err, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomError error = new CustomError(Instant.now(), status.value(), err.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(BancoDadosException.class)
    public ResponseEntity<CustomError> database(BancoDadosException err, HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        CustomError error = new CustomError(Instant.now(), status.value(), err.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }
}
