package com.alvirg.barterexchange.Features.Listings.Delete;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alvirg.barterexchange.Features.Listings.ListingRepository;

@RestController
@RequestMapping("/api/listings")    
public class DeleteListingHandler {

    private final ListingRepository repository;

    public DeleteListingHandler(ListingRepository repository) {
        this.repository = repository;
    }

    public String delete(int id) {
        return repository.findById(id)
            .map(listing -> {
                repository.deleteById(id);
                return "Listing deleted.";
            })
            .orElse("Listing not found.");
    }
}
