package com.alvirg.barterexchange.Features.Users.Get;


import com.alvirg.barterexchange.Features.Users.UserEntity;
import com.alvirg.barterexchange.Features.Users.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class GetUserHandler {

    private final UserRepository userRepository;

    public GetUserHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("")
    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public UserEntity findById(@PathVariable Integer id) {
        return userRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found!"));

    }


}
