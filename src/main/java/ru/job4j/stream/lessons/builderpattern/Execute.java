package ru.job4j.stream.lessons.builderpattern;

public class Execute {

    public static void main(String[] args) {
       User user1 = new User.Build()
               .nameUser("Ramon")
               .uuidUser()
               .ageUser(34)
               .workPlaceUser("ShitCompany")
               .userBuild();


        System.out.println(user1);

    }

}
