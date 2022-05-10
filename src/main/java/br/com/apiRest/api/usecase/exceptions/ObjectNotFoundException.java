package br.com.apiRest.api.usecase.exceptions;

public class ObjectNotFoundException  extends RuntimeException{

    public ObjectNotFoundException(String message) {
        super(message);
    }
}
