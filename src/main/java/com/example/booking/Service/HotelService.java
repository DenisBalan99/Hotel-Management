package com.example.booking.Service;

import com.example.booking.Class.Hotel;
import com.example.booking.Repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    @Autowired
    HotelRepository hotelRepository;

    public void addHotel(Hotel hotel) {
        this.hotelRepository.save(hotel);
        System.out.println(hotelRepository.findAll().toString());
    }

    public void deleteHotel(Long id_hotel) {
        String folder = "Uploads";

        String fileName = hotelRepository.findById(id_hotel).get().getName();
        fileName = fileName.concat(".jpg");
        Path path = Paths.get(folder + fileName);
        try {
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.hotelRepository.deleteById(id_hotel);
    }

    public List<Hotel> getHotels() {
        return hotelRepository.findAll();
    }

    public Optional<Hotel> getHotel(Long id) {
        return hotelRepository.findById(id);
    }

    public void saveImage(MultipartFile imageFile, Hotel hotel) throws IOException {
        String folder = "Uploads";
        byte[] image = imageFile.getBytes();
        String fileName = hotel.getName();
        fileName = fileName.concat(".jpg");
        Path path = Paths.get(folder + fileName);
        Files.write(path, image);
    }
}
