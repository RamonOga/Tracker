package ru.job4j.stream.turist;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PropertyPermission;
import java.util.stream.Collectors;

public class Profile {
    private Address address;

    public Profile(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }
}
