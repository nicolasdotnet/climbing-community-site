/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.amisescalade.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;
import org.amisescalade.dao.UserRepository;
import org.amisescalade.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author nicolasdotnet
 */
@Service
public class CustomUserServiceDetail implements UserDetailsService {

    private static final Logger log = LogManager.getLogger(CustomUserServiceDetail.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Objects.requireNonNull(username);

        Optional<User> userFind = userRepository.findByUsername(username);

        if (!userFind.isPresent()) {

            log.error("L'identifiant n'existe pas !");
            throw new UsernameNotFoundException("L'identifiant n'existe pas !");
        }

        Collection<GrantedAuthority> role = new ArrayList<>();
        role.add(new SimpleGrantedAuthority(userFind.get().getRole().getRoleName()));

        System.out.println("role : " + userFind.get().getRole().getRoleName());

        return new org.springframework.security.core.userdetails.User(username, userFind.get().getPassword(), role);
    }

}
