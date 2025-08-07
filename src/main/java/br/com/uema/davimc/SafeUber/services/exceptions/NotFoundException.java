package br.com.uema.davimc.SafeUber.services.exceptions;

import java.util.UUID;

public class NotFoundException extends RuntimeException {
    public NotFoundException(UUID id, Class clazz) {
        super("Could not find object " +  clazz.getSimpleName() + "  for id: " + id);
    }
    public NotFoundException(String message) {
        super(message);
    }
}
