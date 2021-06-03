package com.example.booking.Controller;

import com.example.booking.Class.Hotel;
import com.example.booking.Service.HotelService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.text.Position;
import javax.validation.Valid;
import java.io.IOException;

@Controller
public class HotelController {

    private HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/addhotel")
    public ModelAndView getHotelMoV() {

        Hotel hotel = new Hotel();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(hotel);
        modelAndView.setViewName("addHotel");

        return modelAndView;
    }

//    @PostMapping("/addhotel")
//    public String addHotel(@Valid Hotel hotel) {
//
//        System.out.println(hotel.toString());
//        this.hotelService.addHotel(hotel);
//        return "redirect:/home";
//    }

    @GetMapping("/home/more/{hotelID}")
    public ModelAndView hotelDetais(@PathVariable Long hotelID) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("HotelDetails");
        modelAndView.addObject("hotel" ,(Hotel)hotelService.getHotel(hotelID).get());

        return modelAndView;
    }

    @GetMapping("/home/deleteHotel/{id_hotel}")
    public String deleteHotel(@PathVariable Long id_hotel) {
        hotelService.deleteHotel(id_hotel);
        return "redirect:/home";
    }

//    @GetMapping("/uploadImage")
//    public ModelAndView uploadImageMoV() {
//        ModelAndView modelAndView = new ModelAndView("/uploadImage");
//        return modelAndView;
//    }
//
//    @PostMapping("/uploadImage")
//    public void uploadImage(@RequestParam("imageFile") MultipartFile imageFile) {
//        System.out.println("intra controller");
//
//        try {
//            hotelService.saveImage(imageFile);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }

    @PostMapping("/addhotel")
    public String addHotel(@Valid Hotel hotel, @RequestParam("imageFile") MultipartFile imageFile) {

        try {
            hotelService.saveImage(imageFile, hotel);

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(hotel.toString());
        this.hotelService.addHotel(hotel);
        return "redirect:/home";
    }

}
