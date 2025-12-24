package org.envycorp.inventoryservice.exception;

public class NoMoreAvailableTicketsFound extends RuntimeException {
    public NoMoreAvailableTicketsFound(String message) {
        super(message);
    }
}
