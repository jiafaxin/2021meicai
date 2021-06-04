package com.example.demo.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.*;

@Data
@AllArgsConstructor
public class Car implements Cloneable, Serializable {

    private String name;

    private Integer age;

    private Person person;


    @Override
    protected Object clone() throws CloneNotSupportedException {
        Car car = (Car) super.clone();
        return car;
    }

    /**
     *
     * @return
     * @throws Exception
     */
    public Object deepClone() throws Exception{
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        bos = new ByteArrayOutputStream();
        oos = new ObjectOutputStream(bos);
        oos.writeObject(this);
        bis = new ByteArrayInputStream(bos.toByteArray());
        ois = new ObjectInputStream(bis);
        Car car = (Car) ois.readObject();
        return car;
    }
}
