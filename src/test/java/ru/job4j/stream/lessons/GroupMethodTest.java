package ru.job4j.stream.lessons;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class GroupMethodTest {
    @Test
    public void test() {
        GroupMethod.User u1 = new GroupMethod.User(10, "Ivan");
        GroupMethod.User u2 = new GroupMethod.User(10, "Boris");
        GroupMethod.User u3 = new GroupMethod.User(15, "Semen");
        GroupMethod.User u4 = new GroupMethod.User(20, "Petr");
        Map<Integer, List<GroupMethod.User>> expect = Map.of(
                10, List.of(u1, u2),
                15, List.of(u3),
                20, List.of(u4)
        );
        GroupMethod.groupBy(
                List.of(u1, u2, u3, u4)).forEach((a, b) -> System.out.println(a + " => " + b));
        assertEquals(expect, GroupMethod.groupBy(
                List.of(u1, u2, u3, u4)
        ));
    }
}