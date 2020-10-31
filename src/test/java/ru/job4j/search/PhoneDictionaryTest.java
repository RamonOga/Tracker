package ru.job4j.search;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryTest {

    @Test
    public void whenFindByName0() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname(), is("Arsentev"));
    }

    @Test
    public void whenFindByName1() {
        PhoneDictionary ph = new PhoneDictionary();
        ph.add(new Person("Ramon", "Rark1", "917", "st.Lenin"));
        ph.add(new Person("Mamon", "Mark", "918", "st.Marks"));
        ph.add(new Person("Ramon", "Rark2", "919", "st.Stalin"));
        ArrayList<Person> person = ph.find("Ramon");
        Assert.assertEquals(person.get(1).getSurname(), "Rark2");
    }

    @Test
    public void whenFindByNameNot() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("123");
        assertThat(persons.size(), is(0));
    }
}