/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.batchprocessing;

import java.io.Serializable;
import java.time.LocalDate;

public class Line implements Serializable {

    private String name;
    private LocalDate dob;
    private Long age;

    @Override
    public String toString() {
        return "Line{" + "name=" + name + ", dob=" + dob + ", age=" + age + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public Line(String name, LocalDate dob) {
        this.name = name;
        this.dob = dob;
    }
}
