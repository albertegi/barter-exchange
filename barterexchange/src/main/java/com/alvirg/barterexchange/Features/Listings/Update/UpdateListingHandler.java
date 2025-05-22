package com.alvirg.barterexchange.Features.Listings.Update;

import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alvirg.barterexchange.Features.Listings.ListingEntity;
import com.alvirg.barterexchange.Features.Listings.ListingRepository;

@RestController
@RequestMapping("/api/listings")
public class UpdateListingHandler {
    private final ListingRepository repository;

    public UpdateListingHandler(ListingRepository repository) {
        this.repository = repository;
    }
    
    @PutMapping("/{id}")
    public ListingEntity update(int id, UpdateListingRequest request) {
        return repository.findById(id)
            .map(listing -> {
                listing.setName(request.getName());
                listing.setDescription(request.getDescription());
                listing.setCondition(request.getCondition());
                listing.setQuantity(request.getQuantity());
                listing.setImageUrl(request.getImageUrl());
                listing.setVisible(request.isVisible());
                listing.setUserId(request.getUserId());
                listing.setCategoryId(request.getCategoryId());
                return repository.save(listing);
            })
            .orElse(new ListingEntity());
    }
}
