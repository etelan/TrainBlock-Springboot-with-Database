package com.example.demo;

import java.util.List;
import java.util.Optional;

public interface ITrainService {

    // Create
    Train addTrain(String tag, String station);

    // Read
    List<Train> findAll();
    Optional<Train> findTrainById(Integer id);
    Optional<Train> findTrainByName(String string);

    Long count();

    // Update
    void updateTrainByName(String name, String station);
    String updateTrainById(Integer id, String name);

    // Delete
    Train deleteTrain(Integer id);

}
