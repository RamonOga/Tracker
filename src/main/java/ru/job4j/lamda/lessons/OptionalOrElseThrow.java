package ru.job4j.lamda.lessons;

import java.util.List;
import java.util.Optional;

public class OptionalOrElseThrow {

    public static class User {

        private String login;

        public User(String login) {
            this.login = login;
        }

        public String getLogin() {
            return login;
        }

        @Override
        public String toString() {
            return "User{" +
                    "login='" + login + '\'' +
                    '}';
        }
    }

    public static class UserNotFoundException extends RuntimeException { }

    public static User orElseThrow(List<User> list, String login) {
       return search(list, login).orElseThrow(UserNotFoundException::new);
    }

    private static Optional<User> search(List<User> list, String login) {
        Optional<User> rsl = list.stream()
                .filter(a -> a.getLogin().equals(login))
                .findFirst();
        System.out.println(rsl);
        return rsl;
    }

    public static void main(String[] args) {
        User u1 = new User("u1");
        User u2 = new User("u2");
        User u3 = new User("u3");
        List<User> list = List.of(u1, u2, u3);
        System.out.println(list);
        System.out.println(OptionalOrElseThrow.orElseThrow(list, "u4"));
    }

}
