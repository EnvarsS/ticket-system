package org.envycorp.ticketservice.repository;

import org.envycorp.ticketservice.model.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, UUID> {

    List<Ticket> getTicketsByUserId(Long userId);
}
