package com.db.h2.console.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "exercise")
public class Exercise {

    @Id
    @GeneratedValue
    private Long id;
    private String name;


    private Long duration;

    private Long calories;
    @Column(name = "trainingdate")
    @NotNull
    private LocalDate trainingdate;
    private String state;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "personExercise_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private PersonExercise personExercise;

    public Exercise() {
    }

//    public Exercise(String name, Long duration, Long calories) {
//        this.name = name;
//        this.duration = duration;
//        this.calories = calories;
//    }

    public Exercise(String name, Long duration, Long calories, LocalDate trainingdate, String state) {
        this.name = name;
        this.duration = duration;
        this.calories = calories;
        this.trainingdate = trainingdate;
        this.state = state;
    }


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public LocalDate getTrainingDate() {
        return trainingdate;
    }

    public void setTrainingDate(LocalDate trainingDate) {
        this.trainingdate = trainingDate;
    }

    public PersonExercise getPersonExercise() {
        return personExercise;
    }

    public void setPersonExercise(PersonExercise personExercise) {
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

//    @Override
//    public String toString() {
//        return "Exercise{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", duration=" + duration +
//                ", calories=" + calories +
//                '}';
//    }

    @Override
    public String toString() {
        return "Exercise{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                ", calories=" + calories +
                ", trainingDate=" + trainingdate +
                ", state='" + state + '\'' +
                ", personExercise=" + personExercise +
                '}';
    }
}
