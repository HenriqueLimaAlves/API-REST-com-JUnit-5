package br.com.apiRest.api.usecase.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class StandardError {

    private LocalDateTime timestamp;
    private Integer Status;
    private String error;
    private String path;
}
