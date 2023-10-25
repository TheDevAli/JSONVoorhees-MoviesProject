package com.sparta.jsonvoorhees.springapi.service;


import com.sparta.jsonvoorhees.springapi.model.entities.Movie;
import com.sparta.jsonvoorhees.springapi.model.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VoorheesWebService {

    private final MovieRepository movieRepository;
    private final CommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository;
    private final TheaterRepository theaterRepository;
    private final UserRepository userRepository;

    @Autowired
    public VoorheesWebService(MovieRepository movieRepository, CommentRepository commentRepository, ScheduleRepository scheduleRepository, TheaterRepository theaterRepository, UserRepository userRepository) {
        this.movieRepository = movieRepository;
        this.commentRepository = commentRepository;
        this.scheduleRepository = scheduleRepository;
        this.theaterRepository = theaterRepository;
        this.userRepository = userRepository;
    }

    public List<Movie> getAllMoviesWithTitle(String title, PageRequest pageRequest) {
        List<Movie> fullMovieList = movieRepository.findAll(pageRequest).toList();
        if (title == null) {
            return fullMovieList;
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
