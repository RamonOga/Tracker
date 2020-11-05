package ru.job4j.stream.packofcards;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Map;

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public static void main(String[] args) {
        List<Suit> suits = Stream.of(Suit.values()).collect(Collectors.toList());
        List<Value> values = Stream.of(Value.values()).collect(Collectors.toList());
        Map<Integer, String> cards = new HashMap<>();
        Integer count = 0;
        for (Suit s : suits) {
            for (Value v : values) {
            cards.put(count, "" + s + v);
            count++;
            }
        }
        System.out.println(cards);
    }
}