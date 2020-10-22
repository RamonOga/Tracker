package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
            users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
       if (!users.get(findByPassport(passport)).contains(account)) {
           users.get(findByPassport(passport)).add(account);
       }
    }

    public User findByPassport(String passport) {
        User rsl = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                rsl = user;
                break;
            }
        }
        return rsl;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        List<Account> accounts = users.get(findByPassport(passport));
        if (accounts != null) {
            for (Account acc : accounts) {
                if (acc.getRequisite().equals(requisite)) {
                    rsl = acc;
                    break;
                }
            }
        }
        return rsl;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account accSrc = findByRequisite(srcPassport, srcRequisite);
        Account accDst = findByRequisite(destPassport, destRequisite);
        if (accSrc.getBalance() >= amount && accSrc != null && accDst != null) {
            accSrc.setBalance(accSrc.getBalance() - amount);
            accDst.setBalance(accDst.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
    }

