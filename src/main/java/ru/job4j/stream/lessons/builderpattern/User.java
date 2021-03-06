package ru.job4j.stream.lessons.builderpattern;

import java.util.UUID;

public class User {

    private String name;
    private String surname;
    private String address;
    private int id;
    private int age;
    private String workPlace;
    private UUID uuid;
    private int[] array;

    public static class Build {

        private User user;

        public Build() {
            this.user = new User();
        }

        public Build nameUser(String input) {
            this.user.name = input;
            return this;
        }

        public Build arrUser(int size) {
            this.user.array = new int[size];
            return this;
        }

        public Build surNameUser(String input) {
            this.user.surname = input;
            return this;
        }

        public Build addressUser(String input) {
            this.user.address = input;
            return this;
        }

        public Build workPlaceUser(String input) {
            this.user.workPlace = input;
            return this;
        }

        public Build idUser(int input) {
            this.user.id = input;
            return this;
        }

        public Build ageUser(int input) {
            this.user.age = input;
            return this;
        }

        public Build uuidUser() {
            this.user.uuid = java.util.UUID.randomUUID();
            return this;
        }

        public User userBuild() {
            return user;
        }
    }

    @Override
    public String   toString() {
        return "User{"
                + "name='" + name + '\''
                + ", surname='" + surname + '\''
                + ", address='" + address + '\''
                + ", id=" + id
                + ", age=" + age
                + ", workPlace='" + workPlace + '\''
                + ", UUID=" + uuid
                + '}';
    }
}
