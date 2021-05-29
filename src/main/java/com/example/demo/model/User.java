package com.example.demo.model;

public class User {

    /*@Field(name = "email")*/
    private String email;

    /*@Field(name = "password")*/
    private String password;

    /*@Field(name = "firstName")*/
    private String firstName;

    /*@Field(name = "lastName")*/
    private String lastName;

    /*@Field(name = "dateOfBirth")*/
    private String dateOfBirth;

    public User(){
    }

    public User(String email, String password, String firstName, String lastName, String dateOfBirth) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
