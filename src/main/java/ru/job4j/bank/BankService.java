package ru.job4j.bank;

import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
       Optional<User> user;
        user = findByPassport(passport);
        if (user.isPresent()) {
            if (!users.get(user.get()).contains(account)) {
                users.get(user.get()).add(account);
            }
        }
    }

    public Optional<User> findByPassport(String passport) {
        return users.keySet()
               .stream()
               .filter(a -> a.getPassport().equals(passport))
               .findFirst();

    }

    public Optional<Account> findByRequisite(String passport, String requisite)  {
       Optional<Account> rsl = Optional.empty();
       Optional <User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accounts = users.get(user.get());
            if (accounts != null) {
               rsl = accounts.stream()
                       .filter(a -> a.getRequisite()
                               .equals(requisite))
                       .findFirst();
            }
        }
        return rsl;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> accSrc = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> accDst = findByRequisite(destPassport, destRequisite);
        if (contains(accSrc, accDst)) {
            if (accSrc.get().getBalance() >= amount) {
                accSrc.get().setBalance(accSrc.get().getBalance() - amount);
                accDst.get().setBalance(accDst.get().getBalance() + amount);
                rsl = true;

            }
        }
        return rsl;
    }

    private boolean contains(Object obj1, Object obj2) {
        boolean rsl = true;
        if (obj1 == null && obj2 == null) {
            rsl = false;
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
        System.out.println(bank.findByRequisite("321", "321").get().getBalance());
        System.out.println(bank.findByPassport("312"));
        System.out.println(bank.findByRequisite("312", "321"));
    }
}