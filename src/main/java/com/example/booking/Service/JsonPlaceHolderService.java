package com.example.booking.Service;

import com.example.booking.Entity.ObjClass;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
public class JsonPlaceHolderService {

    RestTemplate restTemplate = new RestTemplate();

    public ResponseEntity<?> getList() {

        String URL = "https://jsonplaceholder.typicode.com/posts";
        ResponseEntity<ArrayList<ObjClass>> responseEntity;

        try{
            responseEntity =
            restTemplate.exchange(
                    URL,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<ArrayList<ObjClass>>(){}
            );
        }
        catch (HttpStatusCodeException e) {
            return ResponseEntity
                    .status(e.getStatusCode())
                    .body("Error " + e.getStatusCode());
        }
        catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }

        return responseEntity;
    }

    public ResponseEntity<?> getObjByID(Long id) {

        String URL = "https://jsonplaceholder.typicode.com/posts/" + id;
        ResponseEntity<ObjClass> obj;

        try {
            obj = restTemplate.exchange(
                    URL,
                    HttpMethod.GET,
                    null,
                    ObjClass.class
            );
        }
        catch (HttpStatusCodeException e) {
            System.out.println(e.getStatusCode());
            return ResponseEntity
                    .status(e.getStatusCode())
                    .body("Error " + e.getStatusCode());
        }
        catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }

        return ResponseEntity
                .status(obj.getStatusCode())
                .body(obj.getBody());
    }
}
