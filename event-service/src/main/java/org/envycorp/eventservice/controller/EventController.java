package org.envycorp.eventservice.controller;

import org.envycorp.eventservice.model.response.EventResponseDTO;
import org.envycorp.eventservice.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController("/events")
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
    @GetMapping("/{id}/price")
    public ResponseEntity<BigDecimal> getEventPrice(@PathVariable Long id) {
        return new ResponseEntity<>(eventService.getEventPrice(id), HttpStatus.OK);
    }
    @PutMapping("/events/{id}/capacity/{capacity}")
    public ResponseEntity reduceEventCapacity(@PathVariable Long id, @PathVariable Long capacity){
        eventService.reduceEventCapacity(id, capacity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
