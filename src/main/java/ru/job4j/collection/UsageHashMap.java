package ru.job4j.collection;

import java.util.HashMap;
import java.util.HashSet;

public class UsageHashMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("delluiza@yandex.ru", "Luiza Deliandi");
        map.put("Konfetka13-94@mail.ru", "Anna Marusina");
        map.put("vladkazh@mail.ru", "Valda Juravleva");
        map.put("uglova93@mail.ru", "Olga Pavlova");

        for (String key : map.keySet()) {
            System.out.println(map.get(key));
        }
    }
}
