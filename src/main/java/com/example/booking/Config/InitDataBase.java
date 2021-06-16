package com.example.booking.Config;

import com.example.booking.Entity.Hotel;
import com.example.booking.Entity.User;
import com.example.booking.Repository.HotelRepository;
import com.example.booking.Repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitDataBase {
    private static final Logger log = LoggerFactory.getLogger(InitDataBase.class);

    @Bean
    CommandLineRunner initHotels(HotelRepository hotelRepository) {
        return args -> {
            log.info("Create hotel" + hotelRepository.save(new Hotel("test")));
            log.info("Second hotel" + hotelRepository.save(new Hotel("Test", "Test DESC", "Romania", 200)));
        };
    }
    @Bean
    CommandLineRunner initUsers(UserRepository userRepository) {

        return args -> {
            log.info("Create admin" + userRepository.save(new User("admin")));
            log.info("Create user" + userRepository.save(new User("user", "ROLE_USER")));
        };
    }
}


