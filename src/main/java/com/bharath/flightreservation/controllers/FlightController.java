package com.bharath.flightreservation.controllers;

import com.bharath.flightreservation.entities.Flight;
import com.bharath.flightreservation.repos.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class FlightController {

    @Autowired
    FlightRepository vueloRepositorioObj;

    //cuando se cliquea para buscar un vuelo
    @RequestMapping("AccionEncontrarVuelo")
    public String findFlights(@RequestParam("from") String from, @RequestParam("to") String to,
                              @RequestParam("departureDate") @DateTimeFormat(pattern="MM-dd-yyyy") Date departureDate, ModelMap modelMap, ModelMap modelTitle){

        List<Flight> listadoVuelos = vueloRepositorioObj.findFlights(from,to,departureDate);
        System.out.println(listadoVuelos);
        modelMap.addAttribute("flights", listadoVuelos);
        modelTitle.addAttribute("title", "Esta es una version titulada");
        return "displayFlights";
    }

    @RequestMapping("admin/showAddFlight")
    public String showAddFlight(){
        return "addFlight";
    }
}
