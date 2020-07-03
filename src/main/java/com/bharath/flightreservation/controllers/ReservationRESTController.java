package com.bharath.flightreservation.controllers;

import com.bharath.flightreservation.dto.ReservationUpdateRequest;
import com.bharath.flightreservation.entities.Reservation;
import com.bharath.flightreservation.repos.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationRESTController {

    @Autowired
    ReservationRepository reservacionRepositorioObj;

    //retorna la reservacion por medio del id
    @RequestMapping("/reservations/{id}")
    public Reservation findReservation(@PathVariable("id") int id){
       return reservacionRepositorioObj.findById(id).get();
    }


    //actualiza la reservacion con el numofbags y checkin
    @RequestMapping("/reservations")
    public Reservation updateReservation(@RequestBody ReservationUpdateRequest request){
        Reservation reservacion = reservacionRepositorioObj.findById(request.getId()).get();
        reservacion.setNumberOfBags(request.getNumberOfBags());
        reservacion.setCheckedIn(request.getCheckedIn());
        return reservacionRepositorioObj.save(reservacion);
    }


    //aca el requestmapping y el getmapping devuelven lo mismo
    @RequestMapping("/showReservations")
    public List<Reservation> showAllReservations(){
        return reservacionRepositorioObj.findAll();
    }
}
