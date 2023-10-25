package com.sparta.jsonvoorhees.springapi.controller;

import com.sparta.jsonvoorhees.springapi.exceptions.TheaterNotFoundException;
import com.sparta.jsonvoorhees.springapi.exceptions.UserNotFoundException;
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
    public Optional<Theater> getTheaterById(@PathVariable String id) throws TheaterNotFoundException {
        Optional<Theater> theaterById = serviceLayer.getTheaterById(id);
        if (theaterById.isEmpty()){
            throw new TheaterNotFoundException(id);
        }
        return serviceLayer.getTheaterById(id);
    }

    @PostMapping("/api/theaters")
    public Theater createTheater(@RequestBody Theater theater) {
        return serviceLayer.addTheater(theater);
    }

    //@Todo Discuss this and its service layer implementation with team
    // uses Long id is this okay?
    //Todo 1)Why No path variable for patching 2)why long here but string everywhere else?
    @DeleteMapping("/api/theaters/{id}")
    public String deleteTheater(@PathVariable Long id) {
        return serviceLayer.deleteTheaterById(id);
    }

    @PatchMapping("/api/theaters/{id}")
    public Theater updateTheater(@RequestBody Theater theater, @PathVariable String id)  throws TheaterNotFoundException{
        Optional<Theater> theaterById = serviceLayer.getTheaterById(id);
        if (theaterById.isEmpty()){
            throw new TheaterNotFoundException(id);
        }
        return serviceLayer.updateTheater(theater);
    }

}
