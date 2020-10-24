package ru.job4j.bank;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BankServiceTest {

    @Test
    public void addUser() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        try {
            assertThat(bank.findByPassport("3434"), is(user));
        } catch (UserDontFoundException e) {
            System.out.println("Account not found");
        }
    }

    @Test
    public void whenEnterInvalidPassport() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        try {
            assertNull(bank.findByRequisite("34", "5546"));
        } catch (AccountDontFoundException e) {
            System.out.println("Account not found");
        }
    }

    @Test
    public void addAccount() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        try {
            assertThat(bank.findByRequisite("3434", "5546").getBalance(), is(150D));
        } catch (AccountDontFoundException e) {
            System.out.println("Account not found");
        }
    }

    @Test
    public void transferMoney() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.addAccount(user.getPassport(), new Account("113", 50D));
        bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "113", 150D);
        try {
            assertThat(bank.findByRequisite(user.getPassport(), "113").getBalance(), is(200D));
        } catch (AccountDontFoundException e) {
            System.out.println("Account not found");
        }
    }
}