package ru.job4j.stream.packofcards;

import javax.swing.text.BadLocationException;
import java.util.ArrayList;
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

    @Override
    public String toString() {
        return "Card{" +
                "suit=" + suit +
                ", value=" + value +
                '}';
    }

    public static void main(String[] args) {

        List<Suit> suits = Stream.of(Suit.values())
                .collect(Collectors.toList());
        List<Value> values = Stream.of(Value.values())
                .collect(Collectors.toList());

        List<Card> cards = suits.stream()
                .flatMap(a -> values.stream()
                        .map(b -> new Card(a, b)))
                .collect(Collectors.toList());
        cards.forEach(System.out::println);
    }
}