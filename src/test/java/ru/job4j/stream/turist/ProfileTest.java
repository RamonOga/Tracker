package ru.job4j.stream.turist;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class ProfileTest {

    @Test
    public void collectTest() {
        List<Profile> proList = new ArrayList<>(List.of(
                new Profile(new Address("Msk", "Lenin st", 1, 1))
                , new Profile(new Address("Spb", "Marks st", 2, 2))
                , new Profile(new Address("Kzn", "Stalin st", 3, 4))
                , new Profile(new Address("Elb", "Telman st", 2, 2))
                , new Profile(new Address("Elb", "Telman st", 2, 2))
        ));
        List<Address> expect = List.of(
                new Address("Elb", "Telman st", 2, 2)
                , new Address("Kzn", "Stalin st", 3, 4)
                , new Address("Msk", "Lenin st", 1, 1)
                , new Address("Spb", "Marks st", 2, 2)


        );
        List<Address> rsl = Profile.collect(proList);
        Assert.assertEquals(rsl, expect);

    }
}