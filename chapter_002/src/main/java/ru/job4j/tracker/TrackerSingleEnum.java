package ru.job4j.tracker;

import java.util.Random;

public enum TrackerSingleEnum {
    INSTANCE;

    private final Item[] items = new Item[100];
    private int position = 0;

    public Item add(Item item) {
        item.setId(this.generatedId());
        this.items[this.position++] = item;
        return item;
    }

    private static String generatedId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }

    public static void main(String[] args) {
        TrackerSingleEnum first = TrackerSingleEnum.INSTANCE;
    }
}
