package ru.job4j.tracker;

public class FindByIDAction implements UserAction {
    @Override
    public String name() {
        return "=== Find item by Id ===";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        System.out.println(name());
        String id = input.askStr("Enter ID of the item: ");
        Item byId = tracker.findById(id);
        if (byId != null) {
            System.out.println("name: " + byId.getName());
        } else {
            System.out.println("Items with ID: " + id + " not found");
        }
        return true;
    }
}
