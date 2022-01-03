package com.example.demo;

import javax.persistence.*;

@Entity
@Table(name = "train_tracker")
public class Train {

    public Train() {}

    public Train(String train_tag, String train_station) {
        this.train_tag = train_tag;
        this.train_station = train_station;
    }

    // Initializers
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer train_id;
    public String train_tag;
    private String train_station;


    // Getters
    public Integer getId() {
        return train_id;
    }

    public String getTag() {
        return train_tag;
    }

    public String getStation() {
        return train_station;
    }

    // Setters
    public void setTag(String newTag) {
        this.train_tag = newTag;
    }

    public void setStation(String newStation) {
        this.train_station = newStation;
    }
}
