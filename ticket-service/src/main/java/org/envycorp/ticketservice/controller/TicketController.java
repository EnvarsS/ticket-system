package org.envycorp.ticketservice.controller;

import lombok.RequiredArgsConstructor;
import org.envycorp.ticketservice.model.DTO.TicketDTO;
import org.envycorp.ticketservice.service.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tickets")
@RequiredArgsConstructor
public class TicketController {
    private final TicketService ticketService;

    @GetMapping
    public ResponseEntity<List<TicketDTO>> getAllTicketsByUser(@RequestParam Long userId) {
        return ticketService.getAllTicketsByUserId(userId);
    }
}
