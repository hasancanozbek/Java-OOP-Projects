package Entites.concretes;

import Entites.abstracts.Entity;

public class Customer implements Entity {

    private String firstName;
    private String lastName;
    private int birthOfDate;
    private String nationalityId;

    public Customer(){}

    public Customer(String firstName, String lastName, int birthOfDate, String nationalityId){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthOfDate = birthOfDate;
        this.nationalityId = nationalityId;
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

    public int getBirthOfDate() {
        return birthOfDate;
    }

    public void setBirthOfDate(int birthOfDate) {
        this.birthOfDate = birthOfDate;
    }

    public String getNationalityId() {
        return nationalityId;
    }

    public void setNationalityId(String nationalityId) {
        this.nationalityId = nationalityId;
    }
}
