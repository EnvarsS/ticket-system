package org.envycorp.venueservice.controller;

import org.envycorp.venueservice.model.dto.VenueDTO;
import org.envycorp.venueservice.service.VenueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/venues")
public class VenueController {
    private final VenueService venueService;

    public VenueController(VenueService venueService) {
        this.venueService = venueService;
    }

    @GetMapping
    public ResponseEntity<List<VenueDTO>> getAllVenues() {
        return new ResponseEntity<>(venueService.getAllVenues(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VenueDTO> getAllVenues(@PathVariable Long id) {
        return new ResponseEntity<>(venueService.getVenue(id), HttpStatus.OK);
    }
}
