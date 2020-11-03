package ru.job4j.stream.turist;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {

    static List<Address> collect(List<Profile> input) {
        return input.stream()
                .map(Profile::getAddress)
                .sorted(Comparator.comparing(Address::getCity))
                .distinct()
                .collect(Collectors.toList());
    }
}
