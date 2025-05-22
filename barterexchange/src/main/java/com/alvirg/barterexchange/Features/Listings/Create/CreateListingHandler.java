package com.alvirg.barterexchange.Features.Listings.Create;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.alvirg.barterexchange.Features.Listings.ListingEntity;
import com.alvirg.barterexchange.Features.Listings.ListingRepository;

@RestController
@RequestMapping("/api/listings")
public class CreateListingHandler {

    @Autowired
    private ListingRepository repository;

    @PostMapping
    public String create(@RequestBody CreateListingRequest request) {
        ListingEntity entity = new ListingEntity(
            request.name,
            request.description,
            request.condition,
            request.quantity,
            request.imageUrl,
            request.visible,
            request.userId,
            request.categoryId
        );

        repository.save(entity);
        return "Listing created.";
    }
}
