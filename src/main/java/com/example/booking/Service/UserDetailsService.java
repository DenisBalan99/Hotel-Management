package com.example.booking.Service;

import com.example.booking.Entity.MyUserDetails;
import com.example.booking.Entity.User;
import com.example.booking.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {


    UserRepository userRepository;

    @Autowired
    public UserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        Optional<User> user =  userRepository.findByUserName(userName);

        user.orElseThrow(() -> new UsernameNotFoundException("Username not found"));

        System.out.println(user.map(MyUserDetails::new).get());

        return user.map(MyUserDetails::new).get();
    }
}
