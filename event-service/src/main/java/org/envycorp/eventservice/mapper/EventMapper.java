package org.envycorp.eventservice.mapper;

import org.envycorp.eventservice.model.entity.Event;
import org.envycorp.eventservice.model.response.EventResponseDTO;

public class EventMapper {
    public static EventResponseDTO toDTO(Event event) {
        return new EventResponseDTO(
                event.getId(),
                event.getName(),
                event.getAvailableCapacity(),
                event.getDate().toString(),
                event.getVenueId()
        );
    }
}
