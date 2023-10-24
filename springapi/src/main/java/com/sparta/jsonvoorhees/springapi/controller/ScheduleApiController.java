package com.sparta.jsonvoorhees.springapi.controller;

import com.sparta.jsonvoorhees.springapi.model.entities.Movie;
import com.sparta.jsonvoorhees.springapi.model.entities.User;
import com.sparta.jsonvoorhees.springapi.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ScheduleApiController {
    private final ServiceLayer serviceLayer;

    @Autowired
    public ScheduleApiController(ServiceLayer serviceLayer) {
        this.serviceLayer = serviceLayer;
    }

//    @GetMapping("/api/users/getUsers")
//    public List<User> getUsers(@RequestParam(name = "query", required = false) String query) {
//        return serviceLayer.getAllUsersByName(query);
//    }
//
//    @GetMapping("/api/users/getUser/{id}")
//    public Optional<User> getUserById(@PathVariable String id) {
//        return serviceLayer.getUserById(id);
//    }
//
//    @PostMapping("/api/users")
//    public String createUser(@RequestBody User user) {
//        return serviceLayer.createUser(user);
//    }
//
//    @DeleteMapping("/api/users/{id}")
//    public String deleteUser(@PathVariable String id) {
//        return serviceLayer.deleteUser(id);
//    }
//
//    @PatchMapping("/api/users/{id}")
//    public Movie updateUser(@RequestBody User user, @PathVariable Integer id) {
//        return serviceLayer.updateUser(id, user);
//    }
}