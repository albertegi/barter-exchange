package com.alvirg.barterexchange.Features.Users.Delete;

import com.alvirg.barterexchange.Features.Listings.ListingRepository;
import com.alvirg.barterexchange.Features.Users.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users")
public class DeleteUserHandler {

    private final UserRepository userRepository;

    public DeleteUserHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        userRepository.findById(id)
                .ifPresent(user -> userRepository.deleteById(id));
    }


}
