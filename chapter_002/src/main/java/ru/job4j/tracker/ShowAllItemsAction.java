package ru.job4j.tracker;

public class ShowAllItemsAction implements UserAction {
    @Override
    public String name() {
        return "=== Show all items ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println(name());
        Item[] allItems = tracker.findAll();
        if (allItems.length == 0) {
            System.out.println("-- Tracker have no items --");
        }
        for (Item i
                : allItems) {
            System.out.println("Name: " + i.getName() + ", id: " + i.getId());
        }
        return true;
    }
}
