package ru.job4j.lamda;
import java.util.Comparator;

public class LambdaDebug {
    Comparator<String> cmpText = (left, right) -> {
        System.out.println("Compare = " + left + " : " + right);
        return left.compareTo(right);
    };

    Comparator<String> cmpDescSize = (left, right) -> {
        System.out.println("Compare = " + right + " : " + left);
        return Integer.compare(right.length(), left.length()) ;
    };
}
