package org.envycorp.bookingservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

@FeignClient(
        name = "event-service",
        url = "${event-service.url}"
)
public interface EventClient {
    @GetMapping("/events/{id}/capacity")
    public Integer getEventCapacity(@PathVariable Long id);

    @GetMapping("events/{id}/price")
    public ResponseEntity<BigDecimal> getEventPrice(@PathVariable Long id);
}
