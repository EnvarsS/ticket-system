package org.envycorp.ticketservice.service;

import lombok.RequiredArgsConstructor;
import org.envycorp.ticketservice.model.DTO.TicketDTO;
import org.envycorp.ticketservice.model.entity.Ticket;
import org.envycorp.ticketservice.model.event.OrderCreatedEvent;
import org.envycorp.ticketservice.repository.TicketRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;
    private final ModelMapper modelMapper;

    @KafkaListener(topics = "order-created", groupId = "ticket-service")
    public void handleOrderCreatedEvent(OrderCreatedEvent orderCreatedEvent) {
        orderCreatedEvent.getName().forEach(name -> {
            Ticket ticket = new Ticket();
            ticket.setEventId(orderCreatedEvent.getEventId());
            ticket.setOrderId(orderCreatedEvent.getOrderId());
            ticket.setUserId(orderCreatedEvent.getUserId());
            ticket.setName(name);

            ticketRepository.save(ticket);
        });
    }

    public ResponseEntity<List<TicketDTO>> getAllTicketsByUserId(Long userId) {
        List<Ticket> tickets = ticketRepository.getTicketsByUserId(userId);

        return new ResponseEntity(
                tickets.stream()
                        .map(ticket -> modelMapper.map(ticket, TicketDTO.class))
                        .toList(),
                HttpStatus.OK
        );

    }
}
