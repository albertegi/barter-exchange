package com.alvirg.barterexchange.Features.Listings.Create;
import com.alvirg.barterexchange.Features.Listings.ListingEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListingRepository extends JpaRepository<ListingEntity, Integer> {
}
