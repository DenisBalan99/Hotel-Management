package com.example.booking.Controller;

import com.example.booking.Service.JsonPlaceHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class JsonPlaceHolderController {

    @Autowired
    JsonPlaceHolderService jsonPlaceHolderService;

    @GetMapping("/posts")
    public ResponseEntity<?> posts() {
        return jsonPlaceHolderService.getList();
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<?> postsByID(@PathVariable Long id) {
        return jsonPlaceHolderService.getObjByID(id);
    }
}
