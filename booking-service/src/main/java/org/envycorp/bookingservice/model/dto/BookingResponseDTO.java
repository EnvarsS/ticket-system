package org.envycorp.bookingservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponseDTO {
    private Long bookingId;
    private Long userId;
    private Long eventId;
    private Long ticketCount;
    private BigDecimal price;
}
