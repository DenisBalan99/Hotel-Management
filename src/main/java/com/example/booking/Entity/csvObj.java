package com.example.booking.Entity;

import javax.persistence.*;

@Entity
public class csvObj {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "function", nullable = false)
    private String function;

    @Column(name = "salary", nullable = false)
    private Long salary;

    @Override
    public String toString() {
        return "csvObj{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", function='" + function + '\'' +
                ", salary=" + salary +
                '}';
    }

    public csvObj() {
    }

    public csvObj(Long id, String firstName, String lastName, String function, Long salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.function = function;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }
}
