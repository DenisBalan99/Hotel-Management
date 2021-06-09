package com.example.booking.Controller;

import com.example.booking.Class.User;
import com.example.booking.Service.HotelService;
import com.example.booking.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {

    UserService userService;
    HotelService hotelService;

    @Autowired
    public UserController(UserService userService, HotelService hotelService) {
        this.userService = userService;
        this.hotelService = hotelService;
    }

    @GetMapping("/")
    public String redirectToHome() {
        return "redirect:/login";
    }

    @GetMapping("/home")
    public ModelAndView getHomePage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("hotels",hotelService.getHotels());
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @GetMapping("/register")
    public ModelAndView getUserFrom() {
        User user = new User();
        ModelAndView mav = new ModelAndView("Register");
        mav.addObject("user", user);
        return mav;
    }

    @PostMapping("/register")
    public String addUser(@Valid User user) {

        System.out.println(user.toString());
        this.userService.addUser(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public ModelAndView getLoginPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Login");
        return modelAndView;
    }
}
