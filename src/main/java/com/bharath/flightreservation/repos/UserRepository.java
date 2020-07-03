package com.bharath.flightreservation.repos;

import com.bharath.flightreservation.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Usuario, Long> {

//    hace la consulta para devolver el registro de la tabla usuario
    Usuario findByEmail(String email);
}
