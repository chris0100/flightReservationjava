package com.bharath.flightreservation.repos;

import com.bharath.flightreservation.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long > {

}
