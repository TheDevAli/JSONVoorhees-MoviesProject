package com.sparta.jsonvoorhees.springapi.model.repositories;


import com.sparta.jsonvoorhees.springapi.model.entities.Theater;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TheaterRepository extends MongoRepository<Theater, String> {

    Optional<Theater> findTheaterById(String id);
    Optional<Theater> findTheaterByLocation(String location);
    Optional<Theater> findTheaterByTheaterId(Long id);

    /*List<Theater> findTheatersByLocation_Address_City(String city);
    List<Theater> findTheatersByLocation_Address_State(String state);*/

}