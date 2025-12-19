package org.envycorp.inventoryservice.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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
