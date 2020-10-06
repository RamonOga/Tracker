package ru.job4j.tracker;

//import java.util.Scanner;

public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        int inputI;
        String inputS;
        Item rsl;
        Item[] arrayItems;
        String msg;
        while (run) {
            this.showMenu();
            msg = "Select: ";
            int select = Integer.parseInt(input.askStr(msg));
            switch (select) {
                case 0 -> {
                    System.out.println("=== Create a new Item ====");
                    msg = "Enter name: ";
                    String name = input.askStr(msg);
                    Item item = new Item(name);
                    tracker.add(item);
                }
                case 1 -> {
                    System.out.println("=== Show all items ====");
                    arrayItems = tracker.findAll();
                    for (Item value : arrayItems) {
                        System.out.println(value);
                    }
                }
                case 2 -> {
                    msg = "Enter ID: ";
                    inputI = Integer.parseInt(input.askStr(msg));
                    msg = "Enter ID: ";
                    inputS = input.askStr(msg);
                    Item deleteId = new Item(inputS);
                    if (tracker.replace(deleteId, inputI)) {
                        System.out.println("Request with name: " + inputS + " and ID: " + inputI + " replaced");
                    } else {
                        System.out.println("Something went wrong..");
                    }
                }
                case 3 -> {
                    msg = "Enter ID for delete: ";
                    inputI = Integer.parseInt(input.askStr(msg));
                    if (tracker.delete(inputI)) {
                        System.out.println("Item with ID " + inputI + " deleted ");
                    } else {
                        System.out.println("Something went wrong..");
                    }
                }
                case 4 -> {
                    msg = "Enter ID for search: ";
                    inputI = Integer.parseInt(input.askStr(msg));
                    rsl = tracker.findById(inputI);
                    if (rsl != null) {
                        System.out.println(rsl);
                    } else {
                        System.out.println("Request with " + inputI + " number not found.");
                    }
                }
                case 5 -> {
                    msg = "Enter name for search: ";
                    inputS = (input.askStr(msg));
                    arrayItems = tracker.findByName(inputS);
                    if (arrayItems.length > 0) {
                        for (Item arrayItem : arrayItems) {
                            System.out.println(arrayItem);
                        }
                    } else {
                        System.out.println("Request with " + inputS + " not found");
                    }
                }
                case 6 -> run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
