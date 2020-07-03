package com.bharath.flightreservation.controllers;

import com.bharath.flightreservation.entities.Usuario;
import com.bharath.flightreservation.repos.UserRepository;
import com.bharath.flightreservation.services.SecurityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    UserRepository usuarioRepositorioObj;

    //PARA MANEJO DEL LOG DE EJECUCION.
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired //para encriptar el password
    private BCryptPasswordEncoder encoder;

    @Autowired
    private SecurityService securityServiceObj;



    @RequestMapping("/showReg")  //muestra la ventana inicial para que el usuario se registre
    public String showRegistrationPage(){
        return "login/registerUser";
    }


    //se activa cuando se da clic en el boton register,para posteriormente enviarlo a loguears
    @RequestMapping(value="registerUser", method = RequestMethod.POST)
    public String register(@ModelAttribute("user") Usuario user){
        user.setPassword(encoder.encode(user.getPassword()));
        usuarioRepositorioObj.save(user);
        return "login/login";
    }

    @RequestMapping("/showLogin")
    public String showLoginWindow(){
        return "login/login";
    }

    @RequestMapping("admin/onlyadmin")
    public String showAddFlight(){
        return "onlyadmin";
    }


    //se activa cuando el usuario ingresa el username y el password en los respectivos campos
    //si todo sale bien retorna la ventana de vuelos, sino saldra un mensje que dira login incorrecto
    @RequestMapping(value = "loginUser", method = RequestMethod.POST)
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, ModelMap modelMap){
        boolean loginResponse = securityServiceObj.login(email,password);
        System.out.println("login response es: " + loginResponse);

        if(loginResponse){
            modelMap.addAttribute("msg",usuarioRepositorioObj.findByEmail(email).getFirstName());
            return "findFlights";
        }
        else{
            //el modelmap, se lleva a msg para mostrarlo en una ventana
            modelMap.addAttribute("msg","Password o nombre de usuario invalidos");
        }
        return "login/login";
    }


}
