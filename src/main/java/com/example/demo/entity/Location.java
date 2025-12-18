package com.example.demo.entity;

import javax.persistence.*;

@Entity
public class Location {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private Double latitude;
    private Double longitude;

    // getters and setters
}
