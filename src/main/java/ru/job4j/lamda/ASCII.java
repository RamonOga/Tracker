package ru.job4j.lamda;

public class ASCII {

    public static void getAZ() {
        for (int i = 65; i < 65 + 26; i++) {
            System.out.println((char) i + ": " + i);
        }
    }
    public static void getAz() {
        for (int i = 97; i < 97 + 26; i++) {
            System.out.println((char) i + ": " + i);
        }
    }

    public static void getAll() {
        for (int i = 0; i < 127; i++) {
            System.out.println((char) i + ": " + i);
        }
    }
}
