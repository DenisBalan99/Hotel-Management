package com.example.booking.Entity;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "USER_TABLE")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Size(min = 2)
    @Column(name = "FIRSTNAME", nullable = false)
    private String firstName;

    @Size(min = 2)
    @Column(name = "LASTNAME", nullable = false)
    private String lastName;

    @Size(min = 13, max = 13)
    @Column(name = "CNP", nullable = false)
    private String cnp;

    @Size(min = 2)
    @Column(name = "EMAIL")
    private String email;

    @Size(min = 5)
    @Column(name = "TELEPHONE")
    private String telephone;

    private String userName;
    private String password;
    private String roles;

    public User(String user, String role) {
        this.firstName = user;
        this.lastName = user;
        this.cnp = user;
        this.email = "a";
        this.telephone = user;
        this.userName = "a";
        this.password = "a";
        this.roles = "ROLE_USER";
    }

    public User(String admin) {
        this.firstName = admin;
        this.lastName = admin;
        this.cnp = admin;
        this.email = admin;
        this.telephone = admin;
        this.userName = admin;
        this.password = admin;
        this.roles = "ROLE_ADMIN";
    }

    public User(){
        this.roles = "ROLE_USER";
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public void setEmail(String email) {
        this.email = email;
        this.userName = email;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCnp() {
        return cnp;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cnp='" + cnp + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", roles='" + roles + '\'' +
                '}';
    }
}

