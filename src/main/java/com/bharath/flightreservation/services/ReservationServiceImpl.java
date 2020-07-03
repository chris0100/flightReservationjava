package com.bharath.flightreservation.services;

import com.bharath.flightreservation.dto.ReservationRequest;
import com.bharath.flightreservation.entities.Flight;
import com.bharath.flightreservation.entities.Passenger;
import com.bharath.flightreservation.entities.Reservation;
import com.bharath.flightreservation.repos.FlightRepository;
import com.bharath.flightreservation.repos.PassengerRepository;
import com.bharath.flightreservation.repos.ReservationRepository;
import com.bharath.flightreservation.util.EmailUtil;
import com.bharath.flightreservation.util.PDFGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    FlightRepository vueloRepositorioObj;

    @Autowired
    PassengerRepository pasajeroRepositorioObj;

    @Autowired
    ReservationRepository reservacionRepositorioObj;

    @Autowired
    PDFGenerator pdfGenerator;

    @Autowired
    EmailUtil emailUtil;

    @Value("${com.bharath.flightreservation.itinerary.dirpath}")
    private String RUTA_PDF;


    @Override
    @Transactional
    public Reservation bookFlight(ReservationRequest request) {

        //hacer el pago
        Long flightId = request.getFlightId();
        Flight vuelo = vueloRepositorioObj.findById(flightId).get();

        //se crea objeto pasajero para guardar datos obtenidos
        Passenger pasajero = new Passenger();
        pasajero.setFirstName(request.getPassengerFirstName());
        pasajero.setMiddleName(request.getPassengerMiddleName());
        pasajero.setLastName(request.getPassengerLastName());
        pasajero.setPhone(request.getPassengerPhone());
        pasajero.setEmail(request.getPassengerEmail());
        Passenger pasajeroSaved = pasajeroRepositorioObj.save(pasajero);

        //se crea objeto reservacion para guardar objetos de vuelo, pasajero y checkin
        Reservation reservation = new Reservation();
        reservation.setFlight(vuelo);
        reservation.setPassenger(pasajeroSaved);
        reservation.setCheckedIn(false);


        Reservation reservacionSaved = reservacionRepositorioObj.save(reservation);

        //PDF PARA GENERAR Y GUARDAR
        String filePath = RUTA_PDF +reservacionSaved.getId()+".pdf";

        pdfGenerator.generateItinerary(reservacionSaved,filePath);

        //SE ENVIA EL ARCHIVO ADJUNTO A TRAVES DEL CORREO
        emailUtil.SendItinerary(pasajero.getEmail(),filePath);

        return reservacionSaved;
    }
}
