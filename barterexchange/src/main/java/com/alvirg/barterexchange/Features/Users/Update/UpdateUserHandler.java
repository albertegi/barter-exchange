package com.alvirg.barterexchange.Features.Users.Update;

import com.alvirg.barterexchange.Features.Listings.ListingEntity;
import com.alvirg.barterexchange.Features.Listings.ListingRepository;
import com.alvirg.barterexchange.Features.Listings.Update.UpdateListingRequest;
import com.alvirg.barterexchange.Features.Users.UserEntity;
import com.alvirg.barterexchange.Features.Users.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/users")
public class UpdateUserHandler {

    private final UserRepository userRepository;

    public UpdateUserHandler(UserRepository userRepository) {

        this.userRepository = userRepository;
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public ResponseEntity<UserEntity> update(@RequestBody @Valid UpdateUserRequest updateUserRequest, @PathVariable Integer id) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(updateUserRequest.getUsername());
                    user.setEmail(updateUserRequest.getEmail());
                    user.setPassword(updateUserRequest.getPassword());
                    user.setFullName(updateUserRequest.getFullName());
                    user.setActive(updateUserRequest.isActive());

                    return ResponseEntity.ok(userRepository.save(user));

                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
