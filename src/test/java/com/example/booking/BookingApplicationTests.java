package com.example.booking;

import com.example.booking.Controller.CSVController;
import com.example.booking.Entity.ObjClass;
import com.example.booking.Controller.JsonPlaceHolderController;
import com.example.booking.Entity.csvObj;
import com.example.booking.Service.CSVService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

@SpringBootTest
class BookingApplicationTests {

    @Autowired
    JsonPlaceHolderController jsonPlaceHolderController;

    @Autowired
    CSVController csvController;

    @Autowired
    CSVService csvService;

    @Test
    void testingPostsAndID() {

        RestTemplate restTemplate = new RestTemplate();
        String URL = "https://jsonplaceholder.typicode.com/posts/1";

        // expected object
        ResponseEntity<?> expectedObj;
        expectedObj = restTemplate.exchange(
                URL,
                HttpMethod.GET,
                null,
                ObjClass.class);

        // actual object
        ResponseEntity<?> actualObj = jsonPlaceHolderController.postsByID(1L);

        ObjClass expected = (ObjClass) expectedObj.getBody();
        ObjClass actual = (ObjClass) actualObj.getBody();

//        System.out.println(expected);
//        System.out.println(actual);

        Assertions.assertEquals(expected.getUserId(), actual.getUserId());
        Assertions.assertEquals(expected.getId(), actual.getId());
        Assertions.assertEquals(expected.getTitle(), actual.getTitle());
        Assertions.assertEquals(expected.getBody(), actual.getBody());
    }

    @Test
    void testingPostsNotNull() {

        ResponseEntity<?> list = jsonPlaceHolderController.posts();
        Assertions.assertNotNull(list);
    }

    @Test
    void testingCsvDataBaseInit() {
        List<csvObj> csvObjs = csvService.getEmp();
        Assertions.assertFalse(csvObjs.isEmpty());
    }

    @Test
    void testAddCsvToDataBase() throws Exception {

        // 4 emp in csv file
        File file = new File("src/test/java/com/example/booking/csvTest/emp_test.csv");
        FileInputStream inputStream = new FileInputStream(file);
        MultipartFile multipartFile = new MockMultipartFile(file.getName(), file.getName(),
                                    "text/plain", inputStream);
        csvController.uploadCSV(multipartFile);

        List<csvObj> emps = csvService.getEmp();

        // 5 pentru ca am adaugat unul in baza de date deja
        Assertions.assertTrue((emps.size() == 5));

    }
}
