package org.envycorp.bookingservice.service;

import org.envycorp.bookingservice.client.EventClient;
import org.envycorp.bookingservice.client.UserClient;
import org.envycorp.bookingservice.model.dto.BookingRequestDTO;
import org.envycorp.bookingservice.model.dto.BookingResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    private final UserClient userClient;
    private final EventClient eventClient;

    public BookingService(UserClient userClient, EventClient eventClient) {
        this.userClient = userClient;
        this.eventClient = eventClient;
    }

    public BookingResponseDTO createBooking(BookingRequestDTO bookingRequestDTO) {
        if(!userClient.exists(bookingRequestDTO.getUserId())) {
            System.out.println("User does not exist");
            throw new IllegalArgumentException("User does not exist");
        }
        System.out.println("User exists");

        Integer ticketsLeft = eventClient.getEventCapacity(bookingRequestDTO.getEventId());
        System.out.println("Tickets left: " + ticketsLeft);

        return new BookingResponseDTO();
    }
}
