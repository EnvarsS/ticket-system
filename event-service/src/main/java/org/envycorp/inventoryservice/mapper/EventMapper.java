package org.envycorp.inventoryservice.mapper;

import org.envycorp.inventoryservice.model.entity.Event;
import org.envycorp.inventoryservice.model.response.EventResponseDTO;

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
