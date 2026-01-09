package org.homework3.dto;

import org.homework3.enums.GenderType;
import org.homework3.enums.HobbyType;

import java.util.Date;

public class FormPageData {
    String firstName;
    String lastName;
    String email;
    GenderType genderType;
    String phoneNumber;
    Date dateOfBirth;
    String subject;
    HobbyType hobby;
    String currentAddress;
    String state;
    String city;

    public FormPageData(String firstName, String lastName, String email, GenderType genderType, String phoneNumber, Date dateOfBirth, String subject, HobbyType hobby, String currentAddress, String state, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.genderType = genderType;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.subject = subject;
        this.hobby = hobby;
        this.currentAddress = currentAddress;
        this.state = state;
        this.city = city;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public GenderType getGenderType() {
        return genderType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSubject() {
        return subject;
    }

    public HobbyType getHobby() {
        return hobby;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public void setHobby(HobbyType hobby) {
        this.hobby = hobby;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setGenderType(GenderType genderType) {
        this.genderType = genderType;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
