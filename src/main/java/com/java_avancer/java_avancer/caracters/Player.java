package com.java_avancer.java_avancer.caracters;

import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.annotation.processing.Generated;

// if i want to hide more properties i use @JsonIgnoreProperties(all properties i w nt to hide)

public class Player {
//    @Id
//    @Generated()
    private int id;
    private String name;
    private String type;
    // do not show
    @JsonIgnore
    private String works;

    public Player(){};

    public Player(int id, String name, String type, String works) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.works = works;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWorks() {
        return works;
    }

    public void setWorks(String works) {
        this.works = works;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", works='" + works + '\'' +
                '}';
    }
}
