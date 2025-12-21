package org.envycorp.venueservice.service;

import org.envycorp.venueservice.exception.VenueNotFoundException;
import org.envycorp.venueservice.mapper.VenueMapper;
import org.envycorp.venueservice.model.dto.VenueDTO;
import org.envycorp.venueservice.model.entity.Venue;
import org.envycorp.venueservice.repository.VenueRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenueService {
    private final VenueRepository venueRepository;

    public VenueService(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }

    public List<VenueDTO> getAllVenues() {
        List<Venue> allVenues = venueRepository.findAll();
        if(allVenues.isEmpty()) {
            throw new VenueNotFoundException("No venues found");
        }
        return allVenues.stream().map(VenueMapper::toDTO).toList();
    }

    public VenueDTO getVenue(Long id) {
        Venue venue = venueRepository.findById(id).
                orElseThrow(() -> new VenueNotFoundException("Venue not found"));
        return VenueMapper.toDTO(venue);
    }
}
