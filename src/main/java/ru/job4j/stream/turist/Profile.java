package ru.job4j.stream.turist;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profile {
    private Address address;

    public Address getAddress() {
        return address;
    }

    public Profile(Address address) {
        this.address = address;
    }

    static List<Address> collect(List<Profile> input) {
        return input.stream().
                sorted(Comparator.comparing(o -> o.getAddress().getCity()))
                .distinct()
                .map( s -> s.getAddress())
                .collect(Collectors.toList());
    }
}
