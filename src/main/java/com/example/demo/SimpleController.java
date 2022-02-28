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
            return "noperms";
        }

    }

    // Read
    @GetMapping("/showAll")
    public String showAllTrains(Model model, @RequestParam String passHash) {

        if (Objects.equals(passHash, readTrainHash)) {
            model.addAttribute("trainArray", trainService.findAll());
            return "showAll";
        } else {
            return "noperms";
        }
    }

    @GetMapping("/countTrains")
    public String countTrains(Model model, @RequestParam String passHash) {
        if (Objects.equals(passHash, readTrainHash)) {
            return trainService.count().toString();
        } else {
            return "noperms";
        }
    }

    @GetMapping("/noperms")
    public String noperms() {
        return "noperms";
    }

    @GetMapping("/findTrainById")
    public String findTrainById(Model model, @RequestParam String passHash, @RequestParam Integer id) {
        if (Objects.equals(passHash, readTrainHash)) {
            Optional<Train> train = trainService.findTrainById(id);
            if (train.isEmpty()) { return "Train not found :("; }
            else {
                model.addAttribute("train", train);
                return "oneTrain.html";
            }
        } else {
            return "noperms";
        }
    }

    @GetMapping("/findTrainByName")
    public String findTrainByName(Model model, @RequestParam String passHash, @RequestParam String name) {
        if (Objects.equals(passHash, readTrainHash)) {
            Optional<Train> train = trainService.findTrainByName(name);
            if (train.isEmpty()) { return "Train not found :("; }
            else {
                model.addAttribute("train", train.get());
                return "oneTrain.html";
            }
        } else {
            return "noperms";
        }
    }

    // Update
    @GetMapping("/updateTrainById")
    public String updateTrainByNameId(Model model, @RequestParam String passHash, @RequestParam Integer id, @RequestParam String station) {
        if (Objects.equals(passHash, updateTrainHash)) {
            try {
                trainService.updateTrainById(id, station);
                return "showAll";
            } catch (Exception e) {
                return e.toString();
            }
        } else {
            return "noperms";
        }
    }

    // Update
    @GetMapping("/updateTrainByName")
    public String updateTrainByName(Model model, @RequestParam String passHash, @RequestParam String tag, @RequestParam String station) {
        if (Objects.equals(passHash, updateTrainHash)) {
            try {
                trainService.updateTrainByName(tag, station);
                model.addAttribute("train", trainService.findTrainByName(tag).get());
                return "oneTrain";
            } catch (Exception e) {
                return e.toString();
            }
        } else {
            return "noperms";
        }
    }

    // Delete
    @GetMapping("/deleteTrain")
    public String addTrain(Model model, @RequestParam String passHash, @RequestParam Integer id) {
        if (Objects.equals(passHash, deleteTrainHash)) {
            trainService.deleteTrain(id);
            model.addAttribute("trainArray", trainService.deleteTrain(id));
            return "showAll";
        } else {
            return "noperms";
        }
    }
}
