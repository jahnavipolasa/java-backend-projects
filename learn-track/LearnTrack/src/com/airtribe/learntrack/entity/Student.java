package com.airtribe.learntrack.entity;

public class Student extends Person{
    private String batch;
    private Boolean active;

    public Student(int id){
        this(id,null,null,null,null,null);
    }

    public Student(int id, String firstName, String lastName, String email,String batch, Boolean active) {
        super(id, firstName, lastName, email);
        this.batch = batch;
        this.active = active;
    }

    public Student(int id, String firstName, String lastName,String batch, Boolean active) {
        super(id, firstName, lastName);
        this.batch = batch;
        this.active = active;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    @Override
    public void displayName() {
        System.out.println(this.getFirstName()+" "+this.getLastName());
    }

    @Override
    public String toString() {
        return "*** Student Details ***\n" +
                "Id=" + super.getId() + "\n" +
                "First Name=" + super.getFirstName() + "\n" +
                "Last Name=" + super.getLastName() +  "\n" +
                "Email=" + super.getEmail() + "\n" +
                "Active=" + active + "\n" +
                "Batch='" + batch + "\n" +
                "*** ***" + "\n"  ;
    }
}
