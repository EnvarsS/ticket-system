package org.envycorp.ticketservice.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketDTO {
    private UUID id;

    private Long orderId;

    private Long eventId;

    private Long userId;

    private String name;
}
