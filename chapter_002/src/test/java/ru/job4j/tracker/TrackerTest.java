package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
	@Test
	public void whenAddNewItemThenTrackerHasSameItem() {
		Tracker tracker = new Tracker();
		Item item1 = new Item("test1");
		Item item2 = new Item("test2");
		tracker.add(item1);
		tracker.add(item2);
		Item result = tracker.findById(item2.getId());
		assertThat(result.getName(), is(item2.getName()));
	}

	@Test
	public void whenReplaceNameThenReturnNewName() {
		Tracker tracker = new Tracker();
		Item previous = new Item("test1");
		// Добавляем заявку в трекер. Теперь в объект проинициализирован id.
		tracker.add(previous);
		// Создаем новую заявку.
		Item next = new Item("test2");
		// Проставляем старый id из previous, который был сгенерирован выше.
		next.setId(previous.getId());
		// Обновляем заявку в трекере.
		tracker.replace(previous.getId(), next);
		// Проверяем, что заявка с таким id имеет новые имя test2.
		assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
	}

	@Test
	public void whenDeleteSecondThenReturnFirstThird() {
		Tracker tracker = new Tracker();
		Item first = new Item("test1");
		Item second = new Item("test2");
		Item third = new Item("test3");
		tracker.add(first);
		tracker.add(second);
		tracker.add(third);
		tracker.delete(second.getId());
		ArrayList<Item> expected = new ArrayList<Item>();
        expected.add(first);
        expected.add(third);
		assertThat(tracker.findAll(), is(expected));
	}

	@Test
	public void whenFindNameThenReturnName() {
		Tracker tracker = new Tracker();
		Item first = new Item("test1");
		Item second = new Item("test1");
		Item third = new Item("test3");
		tracker.add(first);
		tracker.add(second);
		tracker.add(third);
        ArrayList<Item> expected = new ArrayList<Item>();
        expected.add(first);
        expected.add(second);
		assertThat(tracker.findByName(first.getName()), is(expected));
	}

	@Test
	public void whenFindAll1234Delete3ThenReturn124() {
		Tracker tracker = new Tracker();
		Item first = new Item("test1");
		Item second = new Item("test2");
		Item third = new Item("test3");
		Item fourth = new Item("test4");
		tracker.add(first);
		tracker.add(second);
		tracker.add(third);
		tracker.add(fourth);
		tracker.delete(third.getId());
        ArrayList<Item> expected = new ArrayList<Item>();
        expected.add(first);
        expected.add(second);
        expected.add(fourth);
		assertThat(tracker.findAll(), is(expected));
	}
}