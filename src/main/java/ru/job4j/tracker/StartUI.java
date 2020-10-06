package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        int input;
        String inputS;
        Item rsl;
        Item[] arrayItems;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.parseInt(scanner.nextLine());
            switch (select) {
                case 0:
                    System.out.println("=== Create a new Item ====");
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    Item item = new Item(name);
                    tracker.add(item);
                    break;
                case 1:
                    System.out.println("=== Show all items ====");
                    arrayItems = tracker.findAll();
                    for (Item value : arrayItems) {
                        System.out.println(value);
                    }
                    break;
                case 2:
                    System.out.print("Enter ID: ");
                    input = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter ID: ");
                    inputS = scanner.nextLine();
                    Item deleteId = new Item(inputS);
                    if (tracker.replace(deleteId, input)) {
                        System.out.println("Request with name: " + inputS + " and ID: " + input + " replaced");
                    } else {
                        System.out.println("Something went wrong..");
                    }

                    break;

                case 3:
                    System.out.println("Enter ID for delete: ");
                    input = Integer.parseInt(scanner.nextLine());
                    if (tracker.delete(input)) {
                        System.out.println("Item with ID " + input + " deleted ");
                    } else {
                        System.out.println("Something went wrong..");
                    }
                    break;

                case 4:
                    System.out.println("Enter ID for search: ");
                    input = Integer.parseInt(scanner.nextLine());
                    rsl = tracker.findById(input);
                    if (rsl != null) {
                        System.out.println(rsl);
                    } else {
                        System.out.println("Request with " + input + " number not found.");
                    }

                    break;

                case 5:
                    System.out.println("Enter name for search: ");
                    inputS = (scanner.nextLine());
                    arrayItems = tracker.findByName(inputS);
                    if (arrayItems.length > 0) {
                        for (Item arrayItem : arrayItems) {
                            System.out.println(arrayItem);
                        }
                    } else {
                        System.out.println("Request with " + inputS + " not found");
                    }
                    break;

                case 6:
                    run = false;
                    break;
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
