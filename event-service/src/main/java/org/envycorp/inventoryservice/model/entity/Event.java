package org.envycorp.inventoryservice.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "events")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotNull
    @Column(name = "total_capacity", nullable = false)
    private Long totalCapacity;

    @NotNull
    @Column(name = "available_capacity", nullable = false)
    private Long availableCapacity;

    @NotNull
    @Column(name = "date", nullable = false)
    private LocalDate date;

    @NotNull
    @Column(name = "venue_id", nullable = false)
    private Long venueId;

    @NotNull
    @Column(nullable = false)
    private BigDecimal price;
}
