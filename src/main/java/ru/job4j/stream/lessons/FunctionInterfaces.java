package ru.job4j.stream.lessons;

import ru.job4j.tracker.User;

import java.util.*;
import java.util.function.*;

public class FunctionInterfaces {

    public static void main(String[] args) {

//public interface BinaryOperator<T> {
//    T apply(T t1, T t2);
//}
    BinaryOperator<String> biString = (a, b) -> a + b;
    BinaryOperator<Integer> biInt = Integer::sum;
    BinaryOperator<User> changeUser = (first, second) -> {
        String tmp;
        tmp = first.getUsername();
        first.setUsername(second.getUsername());
        second.setUsername(tmp);
        return null;
    };

//public interface UnaryOperator<T> {
//    T apply(T t);
//}
    UnaryOperator<Integer> unaryInt = x -> 0;
    UnaryOperator<String> unaryStr = x -> x + " Eblan";
    UnaryOperator<User> unaryUser = x -> {
        UUID uuid = UUID.randomUUID();
        x.setPassword(uuid.toString());
        return x;
    };

//public interface Function<T, R> {
//    R apply(T t);
//}

        Function<String, Integer> func2 = Integer::parseInt;
        Function<Integer, String> func3 = Object::toString;
        Function<String, User> func1 = (x) -> {
            return new User(1, "Ramon", x);
        };
        Function<User, List<String>> func4 = x -> {
            List<String> rsl = new LinkedList<>();
            rsl.add(String.valueOf(x.getId()));
            rsl.add(x.getUsername());
            rsl.add(x.getPassword());
            return rsl;
        };

        func4.apply(new User(1, "123", "312"));

        //public interface Predicate<T> {
//    boolean test(T t);
//}
        Predicate<Integer> predInt = a -> a > 0;
        Predicate<String> predString = a -> a.equals("!");
        Predicate<User> predUser = a -> a.getPassword() == null;

        predUser.test(new User(1, "ramon", "321"));

//public interface Consumer<T> {
//    void accept(T t);
//}
        List<String> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();
        Consumer<String> cons1 = list1::add;
        Consumer<Integer> cons2 = x -> list2.add(x);
        Consumer<User> cons3 = x -> x.setPassword(UUID.randomUUID().toString());

        cons1.accept("123");
        cons2.accept(123);
        cons3.accept(new User(1, "123", "312"));

//public interface Supplier<T> {
//    T get();
//}

        Supplier<Integer> sup1 = () -> 1000;
        Supplier<String> sup2 = () -> "eblan";
        Supplier<User> sup3 = () -> new User(1, "Ramon", "321");
        Supplier<List<User>> sup4 = ArrayList::new;
        sup3.get();

    }
}


