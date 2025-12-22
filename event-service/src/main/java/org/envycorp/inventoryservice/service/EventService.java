package org.envycorp.inventoryservice.service;

import org.envycorp.inventoryservice.exception.EventNotFoundException;
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

    public EventResponseDTO getEvent(Long id) {
        Event event = eventRepository.findById(id).orElseThrow(() -> new EventNotFoundException("Not found event with id " + id));

        return EventMapper.toDTO(event);
    }

    public Long getEventCapacity(Long id) {
        return eventRepository.findById(id).orElseThrow(() -> new EventNotFoundException("Not found event with id " + id)).getAvailableCapacity();
    }
}
