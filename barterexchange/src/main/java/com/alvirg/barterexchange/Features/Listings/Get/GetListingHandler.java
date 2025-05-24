package com.alvirg.barterexchange.Features.Listings.Get;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.alvirg.barterexchange.Features.Listings.ListingEntity;
import com.alvirg.barterexchange.Features.Listings.ListingRepository;

// Custom exception for resource not found
@ResponseStatus(code = org.springframework.http.HttpStatus.NOT_FOUND)
class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}

@RestController
@RequestMapping("/api/listings")
public class GetListingHandler {

    private final ListingRepository listingRepository;

    public GetListingHandler(ListingRepository listingRepository) {
        this.listingRepository = listingRepository;
    }

    @GetMapping("")
    public ResponseEntity<List<ListingEntity>> getAllListings() {
        List<ListingEntity> listings = listingRepository.findAll();
        return ResponseEntity.ok(listings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListingEntity> getListingById(@PathVariable int id) {
        return listingRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Listing not found with id " + id));
    }
}
