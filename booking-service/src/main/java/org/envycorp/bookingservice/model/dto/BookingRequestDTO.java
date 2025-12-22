package org.envycorp.bookingservice.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingRequestDTO {
    @NotNull
    private Long userId;
    @NotNull
    private Long eventId;
    @NotNull
    private Long ticketCount;
    @NotNull
    private ArrayList<String> names;
}
