package com.sahha.app.model;

import com.sahha.app.enums.AgeGroup;
import com.sahha.app.enums.Gender;
import com.sahha.app.enums.TopEducation;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.UUID;

@Entity
@Document("users")
public class User {


    @Id
    private UUID id;

    private String firstName;
    private String lastName;

    private String email;
    private String password;

    private Boolean wearable;

    private AgeGroup ageGroup;

    private Gender gender;

    private TopEducation topEducation;

    private String location;
    private String mainLanguage;
    private String professionGroup;

    public User() {
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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

    public Boolean getWearable() {
        return wearable;
    }

    public void setWearable(Boolean wearable) {
        this.wearable = wearable;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMainLanguage() {
        return mainLanguage;
    }

    public void setMainLanguage(String mainLanguage) {
        this.mainLanguage = mainLanguage;
    }

    public String getProfessionGroup() {
        return professionGroup;
    }

    public void setProfessionGroup(String professionGroup) {
        this.professionGroup = professionGroup;
    }

    public AgeGroup getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(AgeGroup ageGroup) {
        this.ageGroup = ageGroup;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public TopEducation getTopEducation() {
        return topEducation;
    }

    public void setTopEducation(TopEducation topEducation) {
        this.topEducation = topEducation;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}