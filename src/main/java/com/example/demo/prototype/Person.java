package com.example.demo.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Person implements Cloneable, Serializable {

    private String userName;

    private String address;

    private Integer age;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person person = (Person) super.clone();
        return person;
    }
}
