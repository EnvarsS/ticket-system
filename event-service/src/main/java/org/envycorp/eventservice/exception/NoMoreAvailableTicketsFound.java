package org.envycorp.eventservice.exception;

public class NoMoreAvailableTicketsFound extends RuntimeException {
    public NoMoreAvailableTicketsFound(String message) {
        super(message);
    }
}
