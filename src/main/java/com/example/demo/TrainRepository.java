package com.example.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface TrainRepository extends  CrudRepository<Train, Integer> {

    @Query("SELECT t FROM Train t WHERE t.train_tag = ?1")
    Optional<Train> findByName(String trainName);
}
