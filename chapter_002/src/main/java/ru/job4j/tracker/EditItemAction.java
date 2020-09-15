package ru.job4j.tracker;

public class EditItemAction implements UserAction {
    @Override
    public String name() {
        return "=== Edit item ===";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        System.out.println(name());
        String id = input.askStr("Enter ID of replaced item: ");
        String name = input.askStr("Enter a new name: ");
        Item item = new Item(name);
        boolean rsl = tracker.replace(id, item);
        System.out.println("-- Replace complete - " + rsl + " --");
        return true;
    }
}
