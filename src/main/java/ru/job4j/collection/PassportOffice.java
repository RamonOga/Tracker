package ru.job4j.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PassportOffice {
    private Map<String, Citizen> citizens = new HashMap<>();

    public boolean add(Citizen citizen) {
        boolean rsl = true;
            if (!citizens.containsValue(citizen)) {
                citizens.put(citizen.getPassport(), citizen);
                rsl = false;
        }
        return rsl;
    }

    public Citizen get(String passport) {
        Citizen rsl = null;
        for (String key : citizens.keySet()) {
            if (citizens.get(key).getPassport() == passport) {
                rsl = citizens.get(key);
            }
        }
        return rsl;
    }
}