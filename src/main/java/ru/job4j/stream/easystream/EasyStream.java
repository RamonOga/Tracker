package ru.job4j.stream.easystream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {

    private static List<Integer> list;

    private EasyStream() {
    }

    private EasyStream(List<Integer> input) {
        list = new ArrayList<>(input);
    }

    private static List<Integer> getList() {
        return list;
    }

    private EasyStream getStream() {
        return this;
    }

    public static EasyStream of(List<Integer> source) {
    //throw new UnsupportedOperationException();
        return new EasyStream(source);
    }

        public EasyStream map(Function<Integer, Integer> fun) {
        List<Integer> rslList = new ArrayList<>();
            for (Integer i : list) {
               rslList.add(fun.apply(i));
            }
            list = rslList;
            //throw new UnsupportedOperationException();
            return getStream();
        }

        public EasyStream filter(Predicate<Integer> fun) {
        List<Integer> rslList = new ArrayList<>();
            for (Integer i : list) {
                if (fun.test(i)) {
                    rslList.add(i);
                }
            }
            list = rslList;
           // throw new UnsupportedOperationException();
            return getStream();
        }

        public List<Integer> collect() {
            //throw new UnsupportedOperationException();
            return list;
        }

    public static void main(String[] args) {
        EasyStream.of(List.of(1, 2, 3))
                .map(e -> e * 2)
                .filter(e -> e == 2)
                .collect().forEach(System.out::println);
    }

}