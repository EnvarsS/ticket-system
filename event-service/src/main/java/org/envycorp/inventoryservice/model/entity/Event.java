package org.envycorp.inventoryservice.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String name;

    @NotNull
    @Column(name = "total_capacity", nullable = false)
    private Long totalCapacity;

    @Column(name = "available_capacity")
    private Long availableCapacity;

    @NotNull
    @Column(name = "venue_id", nullable = false)
    private Long venueId;
}
