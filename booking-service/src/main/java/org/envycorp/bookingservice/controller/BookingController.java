package org.envycorp.bookingservice.controller;

import org.envycorp.bookingservice.model.dto.BookingRequestDTO;
import org.envycorp.bookingservice.model.dto.BookingResponseDTO;
import org.envycorp.bookingservice.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController("/bookings")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<BookingResponseDTO> createBooking(@RequestBody BookingRequestDTO bookingRequestDTO) {
        return new ResponseEntity<>(bookingService.createBooking(bookingRequestDTO), HttpStatus.CREATED);
    }
}
