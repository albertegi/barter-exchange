package com.alvirg.barterexchange.Features.Users.create;

import com.alvirg.barterexchange.Features.Listings.Create.CreateListingRequest;
import com.alvirg.barterexchange.Features.Listings.ListingEntity;
import com.alvirg.barterexchange.Features.Listings.ListingRepository;
import com.alvirg.barterexchange.Features.Users.UserEntity;
import com.alvirg.barterexchange.Features.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/users")
public class CreateUserHandler {

    private final UserRepository userRepository;

    public CreateUserHandler(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @PostMapping
    public String create(@RequestBody CreateUserRequest request) {
        var entity = new UserEntity(

                request.getUsername(),
                request.getEmail(),
                request.getPassword(),
                request.getFullName(),
                request.isActive()

        );

        userRepository.save(entity);
        return "Listing created.";
    }

}
