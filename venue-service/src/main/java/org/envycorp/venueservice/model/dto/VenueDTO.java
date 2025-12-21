package org.envycorp.venueservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VenueDTO {
    private Long id;
    private String name;
    private Integer capacity;
    private String address;
}
