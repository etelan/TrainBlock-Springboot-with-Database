package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainService implements ITrainService {

    @Autowired
    private TrainRepository repository;

    // Create
    @Override
    public Train addTrain(String tag, String station) {
        Train newTrain = new Train(tag, station);
        return repository.save(newTrain);
    }

    // Read
    @Override
    public List<Train> findAll() {
        return (List<Train>) repository.findAll();
    }

    @Override
    public Long count() {
        return (Long) repository.count();
    }

    @Override
    public Optional<Train> findTrainById(Integer id) {
        return repository.findById(id);
    }

    // Update
    @Override
    public void updateTrainByName(String name) {
    }

    @Override
    public String updateTrainById(Integer id, String station) {
        Optional<Train> trainOptional = findTrainById(id);
        if (trainOptional.isEmpty()) {
            return "No Train Found :(";
        } else {
            Train train = trainOptional.get();
            train.setStation(station);
            repository.save(train);
            return "Update request sent";
        }
    }

    // Delete
    @Override
    public Train deleteTrain(Integer id) {
        repository.deleteById(id);
        return null;
    }

}
