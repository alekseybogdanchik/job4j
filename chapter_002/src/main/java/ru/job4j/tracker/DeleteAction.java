package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "=== Delete item ===";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        System.out.println(name());
        String id = input.askStr("Enter ID of the item to be deleted: ");
        boolean rsl = tracker.delete(id);
        System.out.println("Item delete - " + rsl);
        return true;
    }
}
