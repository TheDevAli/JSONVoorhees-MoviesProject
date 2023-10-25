package com.sparta.jsonvoorhees.springapi.controller;

import com.sparta.jsonvoorhees.springapi.model.entities.Movie;
import com.sparta.jsonvoorhees.springapi.model.entities.Theater;
import com.sparta.jsonvoorhees.springapi.model.entities.User;
import com.sparta.jsonvoorhees.springapi.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TheatreApiController {
    private final ServiceLayer serviceLayer;

    @Autowired
    public TheatreApiController(ServiceLayer serviceLayer) {
        this.serviceLayer = serviceLayer;
    }

    @GetMapping("/api/theatres/getTheatres")
    public List<Theater> getAllTheatres() {
        return serviceLayer.getAllTheaters();
    }

    @GetMapping("/api/theatres/getTheatre/{id}")
    public Optional<Theater> getTheaterById(@PathVariable String id) {
        return serviceLayer.getTheaterById(id);
    }

    @PostMapping("/api/theaters")
    public Theater createTheater(@RequestBody Theater theater) {
        return serviceLayer.addTheater(theater);
    }

    //@Todo Discuss this and its service layer implementation with team
    // uses Long id is this okay?
    @DeleteMapping("/api/theaters/{id}")
    public String deleteTheater(@PathVariable String id) {
        return serviceLayer.deleteTheaterById(id);
    }

    @PatchMapping("/api/theaters")
    public Theater updateTheater(@RequestBody Theater theater) {
        return serviceLayer.updateTheater(theater);
    }

}
