package com.bharath.flightreservation.controllers;

import com.bharath.flightreservation.dto.ReservationRequest;
import com.bharath.flightreservation.entities.Flight;
import com.bharath.flightreservation.entities.Reservation;
import com.bharath.flightreservation.repos.FlightRepository;
import com.bharath.flightreservation.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReservationController {

    @Autowired
    FlightRepository vueloRepositorioObj;

    @Autowired
    ReservationService reservationServiceObj;

    @RequestMapping("/showCompleteReservation")
    public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap){
        Flight vuelo = vueloRepositorioObj.findById(flightId).get();
        System.out.println("encuentra el siguiente vuelo " + vuelo.getId() + vuelo.getDepartureCity());
        modelMap.addAttribute("vuelo", vuelo); // este dato se va para completeReservation.jsp
        return "completeReservation";
    }

    @RequestMapping(value = "finishReservation", method = RequestMethod.POST)
    public String finishReservation(ReservationRequest request, ModelMap modelMap){
        Reservation reservation = reservationServiceObj.bookFlight(request);
        modelMap.addAttribute("msg", "Reservacion creada satisfactoriamente, id: " + reservation.getId());
        return "reservationConfirmation";

    }


}
