package org.envycorp.eventservice.repository;

import org.envycorp.eventservice.model.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Long> {

    Event getEventById(Integer id);
}
