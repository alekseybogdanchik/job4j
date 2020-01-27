package ru.job4j.tracker;

import java.util.ArrayList;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find item by name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println(name());
        String name = input.askStr("Enter name of the item: ");
        ArrayList<Item> nameItems = new ArrayList<Item>(tracker.findByName(name));
        if (nameItems.size() > 0) {
            for (Item i
                    : nameItems) {
                System.out.println("Name: " + i.getName() + ", id: " + i.getId());
            }
        } else {
            System.out.println("-- Items with name: \"" + name + "\" not found --");
        }
        return true;
    }
}
