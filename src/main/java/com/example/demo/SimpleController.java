package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;
import java.util.Optional;

@Controller
public class SimpleController {

    @Autowired
    private ITrainService trainService;

    @Value("${hashpass.trainCreate}")
    private String addTrainHash;

    @Value("${hashpass.trainRead}")
    private String readTrainHash;

    @Value("${hashpass.trainUpdate}")
    private String updateTrainHash;

    @Value("${hashpass.trainDelete}")
    private String deleteTrainHash;

    // Create
    @GetMapping("/addTrain")
    public String addTrain(Model model, @RequestParam String tag, @RequestParam String station, @RequestParam String passHash) {

        if (Objects.equals(passHash, addTrainHash)) {
            trainService.addTrain(tag, station);
            model.addAttribute("trainArray", trainService.findAll());
            return "showAll";
        } else {
            return "";
        }

    }

    // Read
    @GetMapping("/showAll")
    public String showAllTrains(Model model, @RequestParam String passHash) {

        if (Objects.equals(passHash, readTrainHash)) {
            model.addAttribute("trainArray", trainService.findAll());
            return "showAll";
        } else {
            return "";
        }
    }

    @GetMapping("/countTrains")
    public String countTrains(Model model, @RequestParam String passHash) {
        if (Objects.equals(passHash, readTrainHash)) {
            return trainService.count().toString();
        } else {
            return "Read Permission Denied";
        }
    }

    @GetMapping("/findTrainById")
    public String findTrainById(Model model, @RequestParam String passHash, @RequestParam Integer id) {
        if (Objects.equals(passHash, readTrainHash)) {
            Optional<Train> train = trainService.findTrainById(id);
            if (train.isEmpty()) { return "Train not found :("; }
            return  train.toString() ;
        } else {
            return "Read Permission Denied";
        }
    }

    // Update
    @GetMapping("/updateTrainById")
    public String updateTrain(Model model, @RequestParam String passHash, @RequestParam Integer id, @RequestParam String stationName) {

        if (Objects.equals(passHash, updateTrainHash)) {
            try {
                trainService.updateTrainById(id, stationName);
                return "showAll";
            } catch (Exception e) {
                return e.toString();
            }
        } else {
            return "Update Permission Denied";
        }
    }

    // Delete
    @GetMapping("/deleteTrain")
    public String addTrain(Model model, @RequestParam Integer id) {
        trainService.deleteTrain(id);
        model.addAttribute("trainArray", trainService.deleteTrain(id));
        return "showAll";
    }
}
