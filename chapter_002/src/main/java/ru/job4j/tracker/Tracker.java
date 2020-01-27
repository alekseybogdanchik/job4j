package ru.job4j.tracker;

import ru.job4j.pojo.Product;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Tracker {

    //private final Item[] items = new Item[100];
    //private int position = 0;
    private final ArrayList<Item> items = new ArrayList<Item>();

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
        for (Item i : items) {
            if (id.equals(i.getId())) {
                int index = items.indexOf(i);
                items.remove(index);
                items.add(index, item);
                items.get(index).setId(id);
                rsl = true;
            }
        }
        return rsl;
    }

    public boolean delete(String id) {
        boolean rsl = false;
        for (Item i : items) {
            if (id.equals(i.getId())) {
                items.remove(i);
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    public ArrayList<Item> findAll() {
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
        ArrayList<Item> nameItems = new ArrayList<Item>();
            for (Item i : items) {
                if (i.getName().equals(key)) {
                    nameItems.add(i);
                    }
                }
        return nameItems;
    }
}
