package org.envycorp.bookingservice.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingRequestDTO {

    @NotNull(message = "User ID cannot be null")
    private Long userId;
    @NotNull(message = "Event ID cannot be null")
    private Long eventId;
    @NotNull(message = "Ticket count cannot be null")
    @Positive(message = "Ticket count must be at least 1")
    private Long ticketCount;
    @NotNull(message = "Names list cannot be null")
    @NotEmpty(message = "Names list must contain at least one name")
    private ArrayList<String> names;
}
