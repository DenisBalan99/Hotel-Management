package com.example.booking.Controller;

import com.example.booking.Service.CSVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class CSVController {

    @Autowired
    CSVService csvService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadCSV(@RequestParam("file") MultipartFile file) {

        if (file.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Empty file");
        }
        else {
            csvService.uploadCsv(file);
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Uploaded");
    }

    @GetMapping("/get_emp")
    public ResponseEntity<?> getEmp() {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(csvService.getEmp());
    }
}
