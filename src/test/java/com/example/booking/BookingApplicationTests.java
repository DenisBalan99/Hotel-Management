package com.example.booking;

import com.example.booking.Entity.ObjClass;
import com.example.booking.Controller.JsonPlaceHolderController;
import com.example.booking.Service.CSVService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class BookingApplicationTests {

    @Autowired
    JsonPlaceHolderController jsonPlaceHolderController;

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

}
