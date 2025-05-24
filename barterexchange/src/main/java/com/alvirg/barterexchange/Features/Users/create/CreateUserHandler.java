package com.alvirg.barterexchange.Features.Users.create;

import com.alvirg.barterexchange.Features.Users.UserEntity;
import com.alvirg.barterexchange.Features.Users.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class CreateUserHandler {

    private final UserRepository userRepository;

    public CreateUserHandler(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void create(@Valid @RequestBody CreateUserRequest request) {
        var userEntity = new UserEntity(

                request.getUsername(),
                request.getEmail(),
                request.getPassword(),
                request.getFullName(),
                request.isActive()
        );

        userRepository.save(userEntity);
    }

}
