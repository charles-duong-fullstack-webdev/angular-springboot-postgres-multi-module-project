package com.db.h2.console.DTO;

public class ExerciseDTO {

    private Long id;
    private String name;
    private Long duration;

    private Long calories;

    public ExerciseDTO() {
    }

    public ExerciseDTO(String name, Long duration, Long calories) {
        this.name = name;
        this.duration = duration;
        this.calories = calories;
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
