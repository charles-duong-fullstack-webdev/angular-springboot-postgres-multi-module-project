package com.db.h2.console.domain;

import javax.persistence.*;

/**
 * bidirectional relationship.
 */

@Entity
@Table(name = "biManyToOneExample")
public class BiManyToOneExample {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Long duration;

    public BiManyToOneExample(String name, Long duration, Long calories, BiOneToManyExample biOneToManyExample) {
        this.name = name;
        this.duration = duration;
        this.calories = calories;
        this.biOneToManyExample = biOneToManyExample;
    }

    private Long calories;

    @ManyToOne
    @JoinColumn(name = "biOneToManyExample_id")
    private BiOneToManyExample biOneToManyExample;

    public BiManyToOneExample() {
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

    public BiOneToManyExample getBiOneToManyExample() {
        return biOneToManyExample;
    }

    public void setBiOneToManyExample(BiOneToManyExample biOneToManyExample) {
        this.biOneToManyExample = biOneToManyExample;
    }


}
