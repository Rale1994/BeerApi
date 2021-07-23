package com.beerapi.BeerApi.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Beer")
public class Beer {

    @Id
    @GeneratedValue
    private int id;


    @NotBlank(message = "Field name is required")
    private String name;

    @NotBlank(message = "Field description is required")
    private String description;

    @NotNull(message = "Field temperature is required")
    private double temperature;

    public Beer() {
    }

    public Beer(@NotBlank(message = "Field name is required") String name, @NotBlank(message = "Field description is required") String description, @NotNull(message = "Field temperature is required") double temperature) {
        this.name = name;
        this.description = description;
        this.temperature = temperature;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
