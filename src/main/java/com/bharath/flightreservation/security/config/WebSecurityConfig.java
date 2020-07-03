package com.bharath.flightreservation.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/showReg", "/", "/index", "/registerUser", "/showLogin", "/loginUser", "/login", "/login/*", "/reservations/*").permitAll()
                .antMatchers("/admin/showAddFlight", "admin/onlyadmin").hasAuthority("ADMIN").anyRequest().authenticated().and().csrf().disable();
//                .formLogin()
//                .loginPage("/showLogin")
//                .permitAll()
//                .and()
//                .logout()
//                .logoutSuccessUrl("/showLogin")
//                .permitAll();;
    }


    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {

        return super.authenticationManagerBean();
    }
}
