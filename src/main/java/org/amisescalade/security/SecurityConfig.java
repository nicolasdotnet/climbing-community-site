/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.amisescalade.security;

import org.amisescalade.services.CustomUserServiceDetail;
import org.amisescalade.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author nicolasdotnet
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    CustomUserServiceDetail userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        // Setting Service to find User in the database.
        // And Setting PassswordEncoder
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("root").password("{noop}123").roles("ADMIN", "USER");
//        auth.inMemoryAuthentication().withUser("user").password("{noop}123").roles("USER");

        auth.userDetailsService(userDetailsService);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable(); 
//pour REST

        // The pages does not require login
        http.authorizeRequests().antMatchers("/","/signup","/login", "/style.css", "/bootstrap/**", "/webjars/**", "/spot/**", "/spots").permitAll();

        // /userinfo page requires login as ROLE_USER or ROLE_ADMIN.
        // If no login, it will redirect to /login page.
// http.authorizeRequests().antMatchers("/userinfo").hasRole("grimpeur");
        
        http.authorizeRequests().antMatchers("/user/**").hasAuthority("grimpeur");
        http.authorizeRequests().antMatchers("/admin/**").hasAuthority("admin");

        // When the user has logged in as XX.
        // But access a page that requires role YY,
        // AccessDeniedException will be thrown.
//        http.exceptionHandling().accessDeniedPage("/403");

        http.formLogin();
        //http.formLogin().loginPage("/login");
        
        http.authorizeRequests().anyRequest().authenticated();

    }

}
