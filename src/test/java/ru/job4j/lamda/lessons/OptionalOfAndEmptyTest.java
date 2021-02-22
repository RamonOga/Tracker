package ru.job4j.lamda.lessons;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

public class OptionalOfAndEmptyTest {

    @Test
    public void whenExists1() {
        Assert.assertEquals(
                Optional.of("c"),
                OptionalOfAndEmpty.findValue1(
                        List.of("a", "b", "c"),
                        "c"
                )
        );
    }

    @Test
    public void whenNotExists1() {
        Assert.assertEquals(
                Optional.empty(),
                OptionalOfAndEmpty.findValue1(
                        List.of("a", "b", "c"),
                        "d"
                )
        );
    }

    @Test
    public void whenExists2() {
        Assert.assertEquals(
                Optional.of("c"),
                OptionalOfAndEmpty.findValue2(
                        List.of("a", "b", "c"),
                        "c"
                )
        );
    }

    @Test
    public void whenNotExists2() {
        Assert.assertEquals(
                Optional.empty(),
                OptionalOfAndEmpty.findValue2(
                        List.of("a", "b", "c"),
                        "d"
                )
        );
    }

}