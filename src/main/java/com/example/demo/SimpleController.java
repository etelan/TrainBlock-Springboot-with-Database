package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

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

    @GetMapping("/updateTrain")
    public String showAllTrains(Model model, @RequestParam String passHash) {

        if (Objects.equals(passHash, updateTrainHash)) {
            model.addAttribute("trainArray", trainService.findAll());
            return "showAll";
        } else {
            return "";
        }
    }

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
            model.addAttribute("count", trainService.count());
            return "countTrains";
        } else {
            return "";
        }
    }

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


    @GetMapping("/deleteTrain")
    public String addTrain(Model model, @RequestParam Integer id) {
        trainService.deleteTrain(id);
        model.addAttribute("trainArray", trainService.findAll());
        return "showAll";
    }
}
