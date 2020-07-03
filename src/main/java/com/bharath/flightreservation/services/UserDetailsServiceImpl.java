package com.bharath.flightreservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bharath.flightreservation.entities.Usuario;
import com.bharath.flightreservation.repos.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepositoryObj;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = userRepositoryObj.findByEmail(username);
        if(usuario == null){
            System.out.println("usuario no encontrado");
            throw new UsernameNotFoundException("Usuario no encontrado: " + username);
        }
        //System.out.println("este es el rol de usuario: " + usuario.getEmail() + ":" + usuario.getRoles().iterator().next().getName());
        return new org.springframework.security.core.userdetails.User(usuario.getEmail(), usuario.getPassword(),usuario.getRoles());
    }
}
