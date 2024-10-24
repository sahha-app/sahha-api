package com.sahha.app.model;

import java.util.UUID;

public class User {

    private UUID id;

    private String firstName;
    private String lastName;

    private String email;

    private Boolean wearable;

    private enum ageGroup{
        FROM14to20,
        FROM20to30,
        FROM30to40,
        FROM40to50,
        FROM50to60,
        FROM60to70,
        FROM70to80,
    }

    private enum gender{
        MALE,
        FEMALE,
        OTHERS;
    }

    private  enum topEducation{
        HIGHSCOOL,
        BACHLORS,
        DIPLOMA,
        MASTERS,
        DOCTORATE;
    }

    private String location;
    private String mainLanguage;
    private String professionGroup;

    public User(UUID id, String firstName, String lastName, String email, Boolean wearable, String location, String mainLanguage, String professionGroup) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.wearable = wearable;
        this.location = location;
        this.mainLanguage = mainLanguage;
        this.professionGroup = professionGroup;
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
}