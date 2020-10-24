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
        User user;
        user = findByPassport(passport);
        if (user != null) {
            if (!users.get(user).contains(account)) {
                users.get(user).add(account);
            }
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

    public Account findByRequisite(String passport, String requisite)  {
        Account rsl = null;
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (accounts != null) {
                for (Account acc : accounts) {
                    if (acc.getRequisite().equals(requisite)) {
                        rsl = acc;
                        break;
                    }
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
        if (accSrc != null && accDst != null) {
            if (accSrc.getBalance() >= amount) {
                accSrc.setBalance(accSrc.getBalance() - amount);
                accDst.setBalance(accDst.getBalance() + amount);
                rsl = true;

            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        BankService bank = new BankService();
        User user1 = new User("123", "ramon");
        User user2 = new User("321", "marmon");
        Account acc1 = new Account("123", 100);
        Account acc2 = new Account("321", 100);
        bank.addUser(user1);
        bank.addUser(user2);
        bank.addAccount("123", acc1);
        bank.addAccount("321", acc2);
        bank.findByPassport("123");
        bank.findByRequisite("123", "123");
        bank.transferMoney("123", "123", "321", "321", 100D);
        System.out.println(bank.findByRequisite("321", "321").getBalance());
    }
}

