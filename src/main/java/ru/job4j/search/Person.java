package ru.job4j.search;

import java.util.ArrayList;

public class Person {
    private String name;
    private String surname;
    private String phone;
    private String address;

    public Person(String name, String surname, String phone, String address) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public ArrayList<String> getAllDate() {
        ArrayList<String> rsl = new ArrayList<>();
        rsl.add(name);
        rsl.add(surname);
        rsl.add(address);
        rsl.add(phone);
        return rsl;
    }
}