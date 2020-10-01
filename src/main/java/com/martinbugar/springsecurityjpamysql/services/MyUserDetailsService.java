package com.martinbugar.springsecurityjpamysql.services;

import com.martinbugar.springsecurityjpamysql.models.User;
import com.martinbugar.springsecurityjpamysql.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class MyUserDetailsService implements UserDetailsService {


    @Autowired
    UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional <User> user = userRepository.findByUserName(username);// optional je ze to nemusi mat hodnotu

        user.orElseThrow(() -> new UsernameNotFoundException("Not found : " + username));

        // namapuje to parametre usera do myuserdetais a ulozim si to do userDetails
        UserDetails userDetails = user.map(user1 -> new MyUserDetails(user1)).get();

        System.out.println(userDetails.getPassword());
        System.out.println(userDetails.getAuthorities());
        System.out.println(userDetails.getUsername());

        return userDetails;

    }
}
