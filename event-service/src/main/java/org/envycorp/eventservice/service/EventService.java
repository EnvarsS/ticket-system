package org.envycorp.eventservice.service;

import org.envycorp.eventservice.exception.EventNotFoundException;
import org.envycorp.eventservice.mapper.EventMapper;
import org.envycorp.eventservice.model.entity.Event;
import org.envycorp.eventservice.model.response.EventResponseDTO;
import org.envycorp.eventservice.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

    public BigDecimal getEventPrice(Long id) {
        return eventRepository.findById(id).orElseThrow(() -> new EventNotFoundException("Not found event with id " + id)).getPrice();
    }
}
