package com.db.h2.console.domain;

import javax.persistence.*;

@Entity
@Table(name = "exercise")
public class Exercise {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Long duration;


    private Long calories;
    @ManyToOne
    @JoinColumn(name = "personExercise_id")
    private PersonExercise personExercise;

    public Exercise() {
    }

    public Exercise(String name, Long duration, Long calories, PersonExercise personExercise) {
        this.name = name;
        this.duration = duration;
        this.calories = calories;
        this.personExercise = personExercise;
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

    public PersonExercise getPersonExercise() {
        return personExercise;
    }

    public void setPersonExercise(PersonExercise personExercise) {
        this.personExercise = personExercise;
    }


    @Override
    public String toString() {
        return "Exercise{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                ", calories=" + calories +
                ", personExercise=" + personExercise +
                '}';
    }
}
