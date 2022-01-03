package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainService implements ITrainService {

    @Autowired
    private TrainRepository repository;

    @Override
    public List<Train> findAll() {

        return (List<Train>) repository.findAll();
    }

    @Override
    public Long count() {
        return (Long) repository.count();
    }

    @Override
    public Train addTrain(String tag, String station) {
        Train newTrain = new Train(tag, station);
        return repository.save(newTrain);
    }

    @Override
    public Train deleteTrain(Integer id) {
        repository.deleteById(id);
        return null;
    }
}
