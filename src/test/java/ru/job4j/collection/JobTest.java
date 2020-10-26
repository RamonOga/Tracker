package ru.job4j.collection;

import org.junit.Test;
import ru.job4j.collection.job.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenComparatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByName() {
        Comparator<Job> comparator = new JobByName();
        int rsl = comparator.compare(
                new Job("Alpha", 12),
                new Job("Beta", 22)
        );
        assertEquals(rsl, -1);
    }

    @Test
    public void whenComparatorByNameDesc() {
        Comparator<Job> comparator = new JobDescByName();
        int rsl = comparator.compare(
                new Job("Alpha", 12),
                new Job("Beta", 22)
        );
        assertEquals(rsl, 1);
    }

    @Test
    public void whenComparatorByPriorityDesc() {
        Comparator<Job> comparator = new JobDescByPriority();
        int rsl = comparator.compare(
                new Job("Alpha", 12),
                new Job("Beta", 22)
        );
        assertEquals(rsl, 1);
    }

    @Test
    public void whenComparatorByPriority() {
        Comparator<Job> comparator = new JobByPriority();
        int rsl = comparator.compare(
                new Job("Alpha", 12),
                new Job("Beta", 22)
        );
        assertEquals(rsl, -1);
    }

    @Test
    public void whenComparatorByNameLn() {
        Comparator<Job> comparator = new JobByNameLn();
        int rsl = comparator.compare(
                new Job("Alpha", 12),
                new Job("Beta", 22)
        );
        assertEquals(rsl, 1);
    }

    @Test
    public void whenComparatorByNameLnDesc() {
        Comparator<Job> comparator = new JobDescByNameLn();
        int rsl = comparator.compare(
                new Job("Alpha", 12),
                new Job("Beta", 22)
        );
        assertEquals(rsl, -1);
    }

    @Test
    public void whenComparatorByPriorityAndName() {
        Comparator<Job> namePriorityComp = new JobByPriority().thenComparing(new JobByName());
        List<Job> list = new ArrayList<>();
        list.add(new Job("Beta", 11));
        list.add(new Job("Alpha", 11));
        list.sort(namePriorityComp);
        Job rsl = list.get(0);
        assertEquals(rsl.getName(), "Alpha");
    }
    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> namePriorityComp = new JobByName().thenComparing(new JobByPriority());
        List<Job> list = new ArrayList<>();
        list.add(new Job("Alpha", 22));
        list.add(new Job("Alpha", 11));
        list.sort(namePriorityComp);
        Job rsl = list.get(0);
        assertEquals(rsl.getPriority(), 11);
    }
}
