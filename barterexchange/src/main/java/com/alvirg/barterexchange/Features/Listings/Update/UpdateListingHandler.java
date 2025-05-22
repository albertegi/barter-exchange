package com.alvirg.barterexchange.Features.Listings.Update;

import com.alvirg.barterexchange.Features.Listings.ListingEntity;
import com.alvirg.barterexchange.Features.Listings.ListingRepository;

public class UpdateListingHandler {
    private final ListingRepository repository;

    public UpdateListingHandler(ListingRepository repository) {
        this.repository = repository;
    }

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
