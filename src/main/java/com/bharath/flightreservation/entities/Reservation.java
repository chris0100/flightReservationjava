package com.bharath.flightreservation.entities;

import javax.persistence.*;

@Entity
@Table(name = "reservation")
public class Reservation{


    @Id
    @SequenceGenerator(name = "reservation_idreservation_seq",
            sequenceName = "reservation_idreservation_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "reservation_idreservation_seq")
    @Column(name = "id", updatable = false)
    private int id;

    private Boolean checkedIn;
    private int numberOfBags;

    @OneToOne //se utiliza por ser llaves foraneas
    private Passenger passenger;
    @OneToOne
    private Flight flight;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(Boolean checkedIn) {
        this.checkedIn = checkedIn;
    }

    public int getNumberOfBags() {
        return numberOfBags;
    }

    public void setNumberOfBags(int numberOfBags) {
        this.numberOfBags = numberOfBags;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
}
