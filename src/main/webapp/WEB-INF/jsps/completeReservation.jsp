<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Complete Reservation</title>
</head>
<body>
    <h2>Reservaciones Completas</h2>
    Airline: ${vuelo.operatingAirlines} <br/>
    Ciudad de salida: ${vuelo.departureCity} <br/>
    Ciudad de llegada: ${vuelo.arrivalCity} <br/>

    <form action="finishReservation" method="post">
        <pre>
        <h2>Passenger Details:</h2>
        First Name: <input type="text" name="passengerFirstName"/>
        Middle Name: <input type="text" name="passengerMiddleName"/>
        Last Name: <input type="text" name="passengerLastName"/>
        Email: <input type="text" name="passengerEmail"/>
        Phone: <input type="text" name="passengerPhone"/>

        <h2>Card details:</h2>
        Name on the card: <input type="text" name="nameOnTheCard"/>
        Card Number: <input type="text" name="cardNumber"/>
        Expiry Date: <input type="text" name="expirationDate"/>
        Three Digit Sec Code: <input type="text" name="securityCode"/>


        <input type="hidden" name="flightId" value="${vuelo.id}">
        <input type="submit" value="Confirm"/>
        </pre>
    </form>


</body>
</html>