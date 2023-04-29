package com.db.h2.console.DTO;

import com.db.h2.console.domain.Exercise;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class PersonExerciseDTO {

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

    private List<ExerciseDTO> exerciseDTOList = new ArrayList<>();


    @SuppressWarnings("unused")
    public PersonExerciseDTO() {
    }

    public PersonExerciseDTO(String firstName, String lastName, String email, Date dob, String address, String country, String gender, List<ExerciseDTO> exerciseDTOList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dob = dob;
        this.address = address;
        this.country = country;
        this.gender = gender;
        this.exerciseDTOList = exerciseDTOList;
    }

    public PersonExerciseDTO(String firstName, String lastName, String email, Date dob, String address, String country, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dob = dob;
        this.address = address;
        this.country = country;
        this.gender = gender;
    }

    public List<ExerciseDTO> getExerciseDTOList() {
        return exerciseDTOList;
    }

    public void setExerciseDTOList(List<ExerciseDTO> exerciseDTOList) {
        this.exerciseDTOList = exerciseDTOList;
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

    @Override
    public String toString() {
        return "PersonExercise{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", address='" + address + '\'' +
                ", country='" + country + '\'' +
                ", gender='" + gender + '\'' +
                ", exerciseDTOList=" + exerciseDTOList +
                '}';
    }
}
