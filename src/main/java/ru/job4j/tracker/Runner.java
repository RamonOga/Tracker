package ru.job4j.tracker;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        SqlTracker sqlt = new SqlTracker();
        sqlt.init();
        List<Item> list = sqlt.findAll();
        list.forEach(System.out::println);
    }
}
