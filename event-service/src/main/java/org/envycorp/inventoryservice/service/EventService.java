package org.envycorp.inventoryservice.service;

import org.envycorp.inventoryservice.mapper.EventMapper;
import org.envycorp.inventoryservice.model.entity.Event;
import org.envycorp.inventoryservice.model.response.EventResponseDTO;
import org.envycorp.inventoryservice.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<EventResponseDTO> getAllEvents() {
         List<Event> events = eventRepository.findAll();
         return events.stream().map(EventMapper::toDTO).toList();
    }
}
