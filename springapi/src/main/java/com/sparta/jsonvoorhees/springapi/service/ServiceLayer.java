package com.sparta.jsonvoorhees.springapi.service;

import com.sparta.jsonvoorhees.springapi.model.entities.*;
import com.sparta.jsonvoorhees.springapi.model.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceLayer {
    private final CommentRepository commentRepository;
    private final MovieRepository movieRepository;
    private final TheaterRepository theaterRepository;
    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    @Autowired
    public ServiceLayer(CommentRepository commentRepository,
                             MovieRepository movieRepository,
                             ScheduleRepository scheduleRepository,
                             TheaterRepository theaterRepository,
                             UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.movieRepository = movieRepository;
        this.scheduleRepository = scheduleRepository;
        this.theaterRepository = theaterRepository;
        this.userRepository = userRepository;
    }

    public List<Movie> getAllMoviesWithTitle(String title) {
        List<Movie> fullMovieList = movieRepository.findAll();
        if (title == null) {
            return movieRepository.findAll();
        }
        else {
            List<Movie> filteredMovies = new ArrayList<>();
            for (Movie movie : fullMovieList) {
                if (movie.getTitle().toLowerCase().contains(title.toLowerCase())) {
                    filteredMovies.add(movie);
                }
            }
            return filteredMovies;
        }
    }
}
