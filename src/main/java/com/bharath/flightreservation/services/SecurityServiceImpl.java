package com.bharath.flightreservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements SecurityService {

    @Qualifier("userDetailsServiceImpl")
    @Autowired
    UserDetailsService userDetailsServiceObj;

    @Autowired
    AuthenticationManager authenticationManager;

    @Override
    public boolean login(String username, String password) {
        UserDetails userDetails = userDetailsServiceObj.loadUserByUsername(username);
        System.out.println("retorna el usuario a metodo login");

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails,password, userDetails.getAuthorities());


        authenticationManager.authenticate(token);

        boolean result = token.isAuthenticated();

        if (result){
            System.out.println("solo pasa por aqui cuano se autentica correctamente");
            SecurityContextHolder.getContext().setAuthentication(token);
        }
        return result;
    }
}
