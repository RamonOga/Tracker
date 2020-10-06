package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            switch (select) {
                case 0 -> {
                    StartUI.createItem(input, tracker);
                }
                case 1 -> {
                    StartUI.showAllItems(tracker);
                }
                case 2 -> {
                   StartUI.editItem(input, tracker);
                }
                case 3 -> {
                    StartUI.deleteItem(input, tracker);
                }
                case 4 -> {
                    StartUI.FindById(input, tracker);
                }
                case 5 -> {
                    StartUI.FindByName(input, tracker);
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

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void showAllItems(Tracker tracker) {
        Item[] arrayItems;
        System.out.println("=== Show all items ====");
        arrayItems = tracker.findAll();
        for (Item value : arrayItems) {
            System.out.println(value);
        }
    }

    public static void editItem(Input input, Tracker tracker) {
        int inputI = input.askInt("Enter ID: ");
        String inputS = input.askStr("Enter Name: ");
        Item deleteId = new Item(inputS);
        if (tracker.replace(deleteId, inputI)) {
            System.out.println("Request with name: " + inputS + " and ID: " + inputI + " replaced");
        } else {
            System.out.println("Something went wrong..");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        int inputI = input.askInt("Enter ID for delete: ");
        if (tracker.delete(inputI)) {
            System.out.println("Item with ID " + inputI + " deleted ");
        } else {
            System.out.println("Something went wrong..");
        }

    }

    public static void FindById(Input input, Tracker tracker) {
        int inputI = input.askInt( "Enter ID for search: ");
        Item rsl = tracker.findById(inputI);
        if (rsl != null) {
            System.out.println(rsl);
        } else {
            System.out.println("Request with " + inputI + " number not found.");
        }

    }

    public static void FindByName(Input input, Tracker tracker) {
        String inputS = (input.askStr("Enter name for search: "));
        Item[] arrayItems = tracker.findByName(inputS);
        if (arrayItems.length > 0) {
            for (Item arrayItem : arrayItems) {
                System.out.println(arrayItem);
            }
        } else {
            System.out.println("Request with " + inputS + " not found");
        }
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
