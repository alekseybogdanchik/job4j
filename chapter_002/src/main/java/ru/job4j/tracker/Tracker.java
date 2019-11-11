package ru.job4j.tracker;

import ru.job4j.pojo.Product;
import java.util.Objects;
import java.util.Random;

public class Tracker {

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

	public boolean replace(String id, Item item) {
		boolean rsl = false;
		for (int i = 0; i < items.length; i++) {
			if (items[i] != null) {
				if (id.equals(item.getId())) {
					items[i] = item;
					items[i].setId(id);
					rsl = true;
				}
			}
		}
		return rsl;
	}

	public boolean delete(String id) {
		int index;
		boolean rsl = false;
		for (index = 0; index < items.length; index++) {
			if (id.equals(items[index].getId())) {
				System.arraycopy(items, index + 1, items, index, items.length - 1 - index);
				position--;
				rsl = true;
				break;
			}
		}
		return rsl;
	}

	public Item[] findAll() {
		Item[] allItems = new Item[position];
		for (int i = 0; i < position; i++) {
			allItems[i] = items[i];
		}
		return allItems;
	}

	public Item findById(String id) {
		Item rsl = null;
		for (int i = 0; i < items.length; i++) {
			if (items[i] != null) {
				if (items[i].getId().equals(id)) {
					rsl = items[i];
					break;
				}
			}
		}
		return rsl;
	}

	public Item[] findByName(String key) {
		int count = 0;
		Item[] itemsTmp = new Item[items.length];
		for (int i = 0; i < items.length; i++) {
			if (items[i] != null) {
				if (items[i].getName().equals(key)) {
					itemsTmp[count] = items[i];
					count++;
				}
			}
		}
		Item[] nameItems = new Item[count];
		System.arraycopy(itemsTmp, 0, nameItems, 0, count);
		return nameItems;
	}
}
