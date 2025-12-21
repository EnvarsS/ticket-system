package org.envycorp.venueservice.mapper;

import org.envycorp.venueservice.model.dto.VenueDTO;
import org.envycorp.venueservice.model.entity.Venue;

public class VenueMapper {
    public static VenueDTO toDTO(Venue venue) {
        return new VenueDTO(
                venue.getId(),
                venue.getName(),
                venue.getCapacity(),
                venue.getAddress()
        );
    }
}
