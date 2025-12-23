package org.envycorp.bookingservice.service;

import org.envycorp.bookingservice.client.EventClient;
import org.envycorp.bookingservice.client.UserClient;
import org.envycorp.bookingservice.model.event.BookingEvent;
import org.envycorp.bookingservice.model.dto.BookingRequestDTO;
import org.envycorp.bookingservice.model.dto.BookingResponseDTO;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    private final UserClient userClient;
    private final EventClient eventClient;
    private final KafkaTemplate<String, BookingEvent> kafkaTemplate;

    public BookingService(UserClient userClient, EventClient eventClient, KafkaTemplate<String, BookingEvent> kafkaTemplate) {
        this.userClient = userClient;
        this.eventClient = eventClient;
        this.kafkaTemplate = kafkaTemplate;
    }

    public BookingResponseDTO createBooking(BookingRequestDTO bookingRequestDTO) {
        if(!userClient.exists(bookingRequestDTO.getUserId())) {
            throw new IllegalArgumentException("User does not exist");
        }

        final BookingEvent bookingEvent = new BookingEvent(
                bookingRequestDTO.getUserId(),
                bookingRequestDTO.getEventId(),
                bookingRequestDTO.getTicketCount(),
                bookingRequestDTO.getNames()

        );

        kafkaTemplate.send("booking", bookingEvent);

        return new BookingResponseDTO();
    }
}
