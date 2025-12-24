package org.envycorp.orderservice.service;

import org.envycorp.orderservice.client.EventClient;
import org.envycorp.orderservice.model.entity.Order;
import org.envycorp.orderservice.model.event.BookingEvent;
import org.envycorp.orderservice.model.event.OrderCreatedEvent;
import org.envycorp.orderservice.repository.OrderRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final EventClient eventClient;
    private final KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;

    public OrderService(OrderRepository orderRepository, EventClient eventClient, KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate) {
        this.orderRepository = orderRepository;
        this.eventClient = eventClient;
        this.kafkaTemplate = kafkaTemplate;
    }

    @KafkaListener(topics = "booking", groupId = "order-service")
    public void orderEvent(BookingEvent bookingEvent) {

        Order order = new Order();
        order.setUserId(bookingEvent.getUserId());
        order.setQuantity(bookingEvent.getTicketCount());
        order.setTotalPrice(bookingEvent.getTotalPrice());

        try{
            eventClient.reduceEventCapacity(bookingEvent.getEventId(), bookingEvent.getTicketCount());
            orderRepository.saveAndFlush(order);
        }
        catch (Exception e){
            throw e;
        }

        OrderCreatedEvent orderCreatedEvent = new OrderCreatedEvent(
                order.getId(),
                bookingEvent.getUserId(),
                bookingEvent.getEventId(),
                bookingEvent.getNames()
        );

        kafkaTemplate.send("order-created", orderCreatedEvent);

    }
}
