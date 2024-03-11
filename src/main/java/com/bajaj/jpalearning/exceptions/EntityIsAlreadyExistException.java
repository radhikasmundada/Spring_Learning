package com.bajaj.jpalearning.exceptions;

public class EntityIsAlreadyExistException extends RuntimeException {

    // Constructor
    public EntityIsAlreadyExistException(String message) {
        super(message);
    }
}
