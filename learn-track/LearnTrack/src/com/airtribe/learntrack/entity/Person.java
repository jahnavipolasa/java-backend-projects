package com.airtribe.learntrack.entity;

public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private String email;

    public Person(int id, String firstName, String lastName, String email) {
        this.email = email;
        this.firstName = firstName;
        this.id = id;
        this.lastName = lastName;
    }

    public Person(int id, String firstName, String lastName) {
        this(id, firstName, lastName,null);
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void displayName(){
        System.out.println(this.firstName);
    }
}
