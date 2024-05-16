package com.projetoAlunos.raiz.dtos;

import java.time.Instant;

public class CustomError {
    private Instant timestamp;
    private int status;
    private String message;
    private String path;

    public CustomError(Instant timestamp, int status, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.path = path;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }
}
