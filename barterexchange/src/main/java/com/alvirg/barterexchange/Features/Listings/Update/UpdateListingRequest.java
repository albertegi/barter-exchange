
package com.alvirg.barterexchange.Features.Listings.Update;

import lombok.Data;

@Data
public class UpdateListingRequest {

    private String name;
    private String description;
    private String condition;
    private int quantity;
    private String imageUrl;
    private boolean visible;
    private int userId;
    private int categoryId;

}
