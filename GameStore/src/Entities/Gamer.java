package Entities;

import Abstracts.Entity;

public class Gamer implements Entity{

    private String firstName;
    private String lastName;
    private String nationalityId;
    private int birthOfYear;


    public Gamer(){}

    public Gamer(String firstName, String lastName, String nationalityId, int birthOfYear){
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalityId = nationalityId;
        this.birthOfYear = birthOfYear;
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

    public String getNationalityId() {
        return nationalityId;
    }

    public int getBirthOfYear() {
        return birthOfYear;
    }

}
