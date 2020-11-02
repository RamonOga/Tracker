package ru.job4j.stream.turist;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PropertyPermission;
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
        return input.stream()
                        .sorted(Comparator.comparing( o -> o.getAddress().getCity()))
                        .map(Profile::getAddress)
                        .distinct()
                        .collect(Collectors.toList());

    }

    public static void main(String[] args) {
        List<Profile> proList = new ArrayList<>(List.of(
                new Profile(new Address("Msk", "Lenin st", 1, 1))
                , new Profile(new Address("Spb", "Marks st", 2, 2))
                , new Profile(new Address("Kzn", "Stalin st", 3, 4))
                , new Profile(new Address("Elb", "Telman st", 2, 2))
                , new Profile(new Address("Elb", "Telman st", 2, 2))
        ));
        List<Address> a = proList.stream()
                .map(p -> p.getAddress())
                .collect(Collectors.toList());

        System.out.println(a);

                System.out.println(Profile.collect(proList));
    }
}
