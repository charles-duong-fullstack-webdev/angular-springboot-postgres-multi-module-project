package com.db.h2.console.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * bidirectional relationship.
 */
@Entity
@Table(name = "biOneToManyExample")
public class BiOneToManyExample {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Date dob;
    private String address;
    private String country;
    private String gender;
    @OneToMany(
            mappedBy = "biOneToManyExample",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<BiManyToOneExample> biManyToOneExampleList = new ArrayList<>();

    @SuppressWarnings("unused")
    public BiOneToManyExample() {
    }

    public BiOneToManyExample(String firstName, String lastName, String email, Date dob, String address, String country, String gender, List<BiManyToOneExample> biManyToOneExampleList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dob = dob;
        this.address = address;
        this.country = country;
        this.gender = gender;
        this.biManyToOneExampleList = biManyToOneExampleList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<BiManyToOneExample> getBiManyToOneExampleList() {
        return biManyToOneExampleList;
    }

    public void setBiManyToOneExampleList(List<BiManyToOneExample> biManyToOneExampleList) {
        this.biManyToOneExampleList = biManyToOneExampleList;
    }


    public BiOneToManyExample(String firstName, String lastName, String email, Date dob, String address, String country, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dob = dob;
        this.address = address;
        this.country = country;
        this.gender = gender;
    }

}
