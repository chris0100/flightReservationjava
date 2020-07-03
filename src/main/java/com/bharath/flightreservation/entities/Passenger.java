package com.bharath.flightreservation.entities;

import javax.persistence.*;

@Entity
@Table(name = "passenger")
public class Passenger {


    @Id
    @SequenceGenerator(name = "passenger_idpassenger_seq",
            sequenceName = "passenger_idpassenger_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "passenger_idpassenger_seq")
    @Column(name = "id", updatable = false)
    private int id;

    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String phone;




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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
