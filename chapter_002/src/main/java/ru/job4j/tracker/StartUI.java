package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(input.askStr("Select: "));
            if (select == 0) {
                System.out.println("=== Create a new Item ===");
                System.out.print("Enter name: ");
                String name = input.askStr("Enter name: ");
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== Show all items ===");
                Item[] allItems = tracker.findAll();
                for (Item i
                        : allItems) {
                    System.out.println("Name: " + i.getName() + ", id: " + i.getId());
                }
            } else if (select == 2) {
                System.out.println("=== Edit item ===");
                System.out.print("Enter ID of replaced item: ");
                String id = input.askStr("Enter ID of replaced item: ");
                System.out.print("Enter a new name: ");
                String name = input.askStr("Enter a new name: ");
                Item item = new Item(name);
                boolean rsl = tracker.replace(id, item);
                System.out.println("Replace complete - " + rsl);
            } else if (select == 3) {
                System.out.println("=== Delete item ===");
                System.out.print("Enter ID of the item to be deleted: ");
                String id = input.askStr("Enter ID of the item to be deleted: ");
                boolean rsl = tracker.delete(id);
                System.out.println("Item delete - " + rsl);
            } else if (select == 4) {
                System.out.println("=== Find item by Id ===");
                System.out.print("Enter ID of the item: ");
                String id = input.askStr("Enter ID of the item: ");
                Item byId = tracker.findById(id);
                if (byId != null) {
                    System.out.println("name: " + byId.getName());
                } else {
                    System.out.println("Items with ID: " + id + " not found");
                }
            } else if (select == 5) {
                System.out.println("=== Find item by name ===");
                System.out.print("Enter name of the item: ");
                String name = input.askStr("Enter name of the item: ");
                Item[] nameItems = tracker.findByName(name);
                if (nameItems.length > 0) {
                    for (Item i
                            : nameItems) {
                        System.out.println("Name: " + i.getName() + ", id: " + i.getId());
                    }
                } else {
                    System.out.println("Items with name: \"" + name + "\" not found");
                }
            } else if (select == 6) {
                System.out.println("=== Exit ===");
                run = false;
            } else {
                System.out.println("== Enter a number between 0 and 6 ==");
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit program");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
