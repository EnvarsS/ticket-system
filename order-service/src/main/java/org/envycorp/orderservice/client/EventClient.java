package org.envycorp.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(
        name = "event-service",
        url = "${event-service.url}"
)
public interface EventClient {

    @PutMapping("/events/{id}/capacity/{capacity}")
    void reduceEventCapacity(@PathVariable Long id, @PathVariable Long capacity);
}
