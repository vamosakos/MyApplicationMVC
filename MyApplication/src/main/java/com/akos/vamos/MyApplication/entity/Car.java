package com.akos.vamos.MyApplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Car {
    @Id
    @GeneratedValue
    private int id;
    private String number;
    private String type;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Car() {
    }
    public Car(int id, String number, String type) {
        this.id = id;
        this.number = number;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
