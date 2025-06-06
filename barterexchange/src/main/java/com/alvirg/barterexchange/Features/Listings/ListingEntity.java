package com.alvirg.barterexchange.Features.Listings;

import com.alvirg.barterexchange.Shared.Domain.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "listings")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListingEntity extends BaseEntity {

    @Column(nullable = false)
    private String name;

    private String description;
    private String condition;
    private int quantity;
    private String imageUrl;
    private boolean visible;
    private int userId;
    private int categoryId;

    @Builder
    public ListingEntity(int id,
                         String name,
                         String description,
                         String condition,
                         int quantity,
                         String imageUrl,
                         boolean visible,
                         int userId,
                         int categoryId) {
        super(id);
        this.name = name;
        this.description = description;
        this.condition = condition;
        this.quantity = quantity;
        this.imageUrl = imageUrl;
        this.visible = visible;
        this.userId = userId;
        this.categoryId = categoryId;
    }
}
