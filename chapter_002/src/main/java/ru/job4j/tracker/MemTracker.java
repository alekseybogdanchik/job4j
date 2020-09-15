package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MemTracker implements Store {

    //private final Item[] items = new Item[100];
    //private int position = 0;
    private final List<Item> items = new ArrayList<>();

    @Override
    public void init() {
        System.out.println("for implements only");
    }

    public Item add(Item item) {
        item.setId(this.generatedId());
        this.items.add(item);
        return item;
    }

    private static String generatedId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }

    public boolean replace(String id, Item item) {
        boolean rsl = false;
        for (int i = 0; i < items.size(); i++) {
            if (id.equals(items.get(i).getId())) {
                items.set(i, item);
                items.get(i).setId(id);
                rsl = true;
            }
        }
        return rsl;
    }

    public boolean delete(String id) {
        boolean rsl = false;
        for (int i = 0; i < items.size(); i++) {
            if (id.equals(items.get(i).getId())) {
                items.remove(i);
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    public List<Item> findAll() {
        return this.items;
    }

    public Item findById(String id) {
        Item rsl = null;
        for (Item i : items) {
            if (id.equals(i.getId())) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }

    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> nameItems = new ArrayList<>();
            for (Item i : items) {
                if (i.getName().equals(key)) {
                    nameItems.add(i);
                    }
                }
        return nameItems;
    }

    @Override
    public void close() throws Exception {
        System.out.println("for implements only");
    }
}
