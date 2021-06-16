package com.example.booking.Entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name = "HOTEL")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2)
    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Size(min = 2)
    @Column(name = "LOCATION", nullable = false)
    private String location;

    @Column(name = "PRICE", nullable = false)
    private int price;

    @Column(name = "contact")
    @Email
    private String contactEmail;

    public Hotel(String name, String description, String location, int price) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.price = price;
        this.contactEmail = name;
        this.contactEmail = this.contactEmail.concat("@yahoo.com");
    }

    public Hotel(String test) {
        this.name = "Majestic";
        this.description = "Hello guys! Can't wait to see you here!";
        this.location = "Panama";
        this.price = 250;
        this.contactEmail = "test";
        this.contactEmail = this.contactEmail.concat("@yahoo.com");
    }

    public String getImageSource() {
        String path = name;
        path = path.concat(".jpg");
        System.out.println(path);
        return path;
    }

    public Hotel() {
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", price=" + price +
                '}';
    }
}
