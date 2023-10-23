package com.sparta.jsonvoorhees.springapi.controller;

import com.sparta.jsonvoorhees.springapi.model.entities.Movie;
import com.sparta.jsonvoorhees.springapi.model.repositories.MovieRepository;
import com.sparta.jsonvoorhees.springapi.service.ApiLibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieApiController {
    private final ApiLibraryService apiLibraryService;

    @Autowired
    public MovieApiController(ApiLibraryService apiLibraryService) {
        this.apiLibraryService = apiLibraryService;
    }

    @GetMapping("/api/movies/getMovies")
    public List<Movie> getMovies() {return apiLibraryService.getMovieRepository().findAll();}
}
