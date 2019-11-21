package ru.job4j.tracker;

public class CreateAction implements UserAction {
    @Override
    public String name() {
        return "=== Create a new Item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println(name());
        String itemName = input.askStr("Enter name of the new item: ");
        Item item = new Item(itemName);
        tracker.add(item);
        return true;
    }
}
