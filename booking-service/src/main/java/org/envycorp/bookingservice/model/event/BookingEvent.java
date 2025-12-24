package org.envycorp.bookingservice.model.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingEvent {
    private Long userId;
    private Long eventId;
    private Long ticketCount;
    private List<String> names;
    private BigDecimal totalPrice;
}
