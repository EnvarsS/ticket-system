package org.envycorp.inventoryservice.controller;

import org.envycorp.inventoryservice.model.response.EventResponseDTO;
import org.envycorp.inventoryservice.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/events")
public class EventController {
    private final EventService inventoryService;

    public EventController(EventService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping
    public ResponseEntity<List<EventResponseDTO>> getAllEvents() {
        inventoryService.getAllEvents();
    }
}
