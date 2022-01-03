package com.example.demo;

import java.util.List;

public interface ITrainService {

    List<Train> findAll();

    Long count();

    Train addTrain(String tag, String station);

    Train deleteTrain(Integer id);
}
