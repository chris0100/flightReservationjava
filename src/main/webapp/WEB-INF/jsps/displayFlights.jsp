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
    <title>Show flights</title>
</head>
<body>
    <h2>Vuelos</h2>
    <table>
            <tr>
                <th>Airlines</th>
                <th>Departure city</th>
                <th>Arrival city</th>
                <th>Departure Time</th>
            </tr>
        <c:forEach items="${flights}" var="objFlight">
            <tr>
                <td>${objFlight.operatingAirlines}</td>
                <td>${objFlight.departureCity}</td>
                <td>${objFlight.arrivalCity}</td>
                <td>${objFlight.estimatedDepartureTime}</td>
                <td><a href="showCompleteReservation?flightId=${objFlight.id}">Select </a></td>
            </tr>
            
        </c:forEach>
    </table>


</body>
</html>