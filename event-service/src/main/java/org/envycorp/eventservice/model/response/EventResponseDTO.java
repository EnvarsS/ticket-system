package org.envycorp.eventservice.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventResponseDTO {
    private Long id;
    private String name;
    private Long availableCapacity;
    private String date;
    private Long venueId;
}
