package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find1(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person pers : persons) {
            if (pers.getName().contains(key) || pers.getSurname().contains(key)
                    || pers.getAddress().contains(key) || pers.getPhone().contains(key)) {
                result.add(pers);
            }
        }
        return result;
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> predName = pers -> pers.getName().equals(key);
        Predicate<Person> predSurename = pers ->pers.getSurname().equals(key);
        Predicate<Person> predAddress = pers ->pers.getAddress().equals(key);
        Predicate<Person> predPhone = pers -> pers.getPhone().equals(key);
        Predicate<Person> combine = predName.or(predAddress.or(predPhone.or(predSurename)));
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        PhoneDictionary ph = new PhoneDictionary();
        ph.add(new Person("Ramon", "Rark", "917", "st.Lenin"));
        ph.add(new Person("Mamon", "Mark", "918", "st.Marks"));
        ph.add(new Person("Gamon", "Gark", "919", "st.Stalin"));
        System.out.println(ph.find("919"));
    }
}
