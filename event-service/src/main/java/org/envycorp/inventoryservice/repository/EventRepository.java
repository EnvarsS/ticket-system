package org.envycorp.inventoryservice.repository;

import org.envycorp.inventoryservice.model.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Long> {

    Event getEventById(Integer id);
}
