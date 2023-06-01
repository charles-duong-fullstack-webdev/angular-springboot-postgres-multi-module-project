package com.db.h2.console.DTO;

import java.time.LocalDate;

public class ExerciseDTO {

    private Long id;
    private String name;
    private Long duration;

    private Long calories;

    private LocalDate trainingdate;

    private String state;

    public ExerciseDTO() {
    }


    public ExerciseDTO(Long id, String name, Long duration, Long calories, LocalDate trainingdate, String state) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.calories = calories;
        this.trainingdate = trainingdate;
        this.state = state;
    }
//    public ExerciseDTO(String name, Long duration, Long calories) {
//        this.name = name;
//        this.duration = duration;
//        this.calories = calories;
//    }


    public LocalDate getTrainingdate() {
        return trainingdate;
    }

    public void setTrainingdate(LocalDate trainingdate) {
        this.trainingdate = trainingdate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Long getCalories() {
        return calories;
    }

    public void setCalories(Long calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                ", calories=" + calories +
                '}';
    }
}
