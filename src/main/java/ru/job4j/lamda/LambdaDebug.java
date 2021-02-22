package ru.job4j.lamda;
import java.util.Comparator;

public class LambdaDebug {
    private Comparator<String> cmpText = (left, right) -> {
        System.out.println("Compare = " + left + " : " + right);
        return left.compareTo(right);
    };

    private Comparator<String> cmpDescSize = (left, right) -> {
        System.out.println("Compare = " + left + " : " + right);
        return Integer.compare(right.length(), left.length());
    };
}
