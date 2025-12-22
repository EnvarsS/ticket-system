package org.envycorp.inventoryservice.controller;

import org.envycorp.inventoryservice.model.response.EventResponseDTO;
import org.envycorp.inventoryservice.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("events")
public class EventController {
    private final EventService eventService;

    public EventController(EventService inventoryService) {
        this.eventService = inventoryService;
    }

    @GetMapping
    public ResponseEntity<List<EventResponseDTO>> getAllEvents() {
        return new ResponseEntity<>(eventService.getAllEvents(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<EventResponseDTO> getEvent(@PathVariable Long id) {
        return new ResponseEntity<>(eventService.getEvent(id), HttpStatus.OK);
    }
    @GetMapping("/{id}/capacity")
    public ResponseEntity<Long> getEventCapacity(@PathVariable Long id) {
        return new ResponseEntity<>(eventService.getEventCapacity(id), HttpStatus.OK);
    }
}
