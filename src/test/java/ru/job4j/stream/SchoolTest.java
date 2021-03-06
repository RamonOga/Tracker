package ru.job4j.stream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SchoolTest {
    private List<Student> students = new ArrayList<>();
    private List<Student> duplicateStudents = new ArrayList<>();
    private Predicate<Student> prHigh =  s -> s.getScore() >= 70;
    private Predicate<Student> prLow =  s -> s.getScore() <= 40;
    private Predicate<Student> prMid =  prHigh.negate().and(prLow.negate());

    @Before
    public void setUp() {
        students.add(new Student(10, "Surname1"));
        students.add(new Student(20, "Surname2"));
        students.add(new Student(30, "Surname3"));
        students.add(new Student(40, "Surname4"));
        students.add(new Student(50, "Surname5"));
        students.add(new Student(60, "Surname6"));
        students.add(new Student(70, "Surname7"));
        students.add(new Student(80, "Surname8"));
        students.add(new Student(90, "Surname9"));

        duplicateStudents.add(new Student(10, "Surname1"));
        duplicateStudents.add(new Student(10, "Surname1"));
        duplicateStudents.add(new Student(10, "Surname1"));
        duplicateStudents.add(new Student(20, "Surname1"));
        duplicateStudents.add(new Student(10, "Surname2"));
    }

    @Test
    public void whenCollectClassA() {
        School sc = new School();
        List<Student> rsl = sc.collect(students, prHigh);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student(70, "Surname7"));
        expected.add(new Student(80, "Surname8"));
        expected.add(new Student(90, "Surname9"));
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenCollectClassB() {
        School sc = new School();
        List<Student> rsl = sc.collect(students, prMid);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student(50, "Surname5"));
        expected.add(new Student(60, "Surname6"));
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenCollectClassC() {
        School sc = new School();
        List<Student> rsl = sc.collect(students, prLow);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student(10, "Surname1"));
        expected.add(new Student(20, "Surname2"));
        expected.add(new Student(30, "Surname3"));
        expected.add(new Student(40, "Surname4"));
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenTranferToMapTest() {
        School sc = new School();
        Map<String, Student> rsl = sc.transformToMap(students);
        Map<String, Student> expected = new LinkedHashMap<>();
        expected.put("Surname1", new Student(10, "Surname1"));
        expected.put("Surname2", new Student(20, "Surname2"));
        expected.put("Surname3", new Student(30, "Surname3"));
        expected.put("Surname4", new Student(40, "Surname4"));
        expected.put("Surname5", new Student(50, "Surname5"));
        expected.put("Surname6", new Student(60, "Surname6"));
        expected.put("Surname7", new Student(70, "Surname7"));
        expected.put("Surname8", new Student(80, "Surname8"));
        expected.put("Surname9", new Student(90, "Surname9"));

        Assert.assertEquals(expected, rsl);
    }

    @Test
    public void whenTranferToDuplicate() {
        School sc = new School();
        Map<String, Student> rsl = sc.transformToMap(duplicateStudents);
        Map<String, Student> expected = new LinkedHashMap<>();
        expected.put("Surname1", new Student(10, "Surname1"));
        expected.put("Surname2", new Student(10, "Surname2"));
        Assert.assertEquals(expected, rsl);
    }
}