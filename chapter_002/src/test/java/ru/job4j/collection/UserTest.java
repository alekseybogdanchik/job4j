package ru.job4j.collection;

import org.junit.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.ItemSortByName;

import java.util.*;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserTest {
    @Test
    public void whenAsc() {
        Set<User> users = new TreeSet<>();
        users.add(new User("Petr", 32));
        users.add(new User("Ivan", 31));
        Iterator<User> it = users.iterator();
        assertThat(it.next(), is(new User("Ivan", 31)));
        assertThat(it.next(), is(new User("Petr", 32)));
    }

    @Test
    public void whenComparePertVSIvan() {
        int rsl = new User("Petr", 32)
                .compareTo(
                        new User("Ivan", 31)
                );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparePert32VSPert45() {
        int rsl = new User("Petr", 32)
                .compareTo(
                        new User("Petr", 45)
                );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void UserSortDecrByAge() {
        User ivan = new User("Ivan", 28);
        User petr = new User("Petr", 32);
        User aleksey = new User("Aleksey", 35);

        List<User> users = Arrays.asList(ivan, aleksey, petr);
        Collections.sort(users, new UserDecrByAge());
        assertThat(users, is(Arrays.asList(
                aleksey,
                petr,
                ivan
                )
        ));
    }

    @Test
    public void UserSortDecrByName() {
        User ivan = new User("Ivan", 28);
        User petr = new User("Petr", 32);
        User aleksey = new User("Aleksey", 35);

        List<User> users = Arrays.asList(ivan, petr, aleksey);
        Collections.sort(users, new UserDecrByName());
        assertThat(users, is(Arrays.asList(
                petr,
                ivan,
                aleksey
                )
        ));
    }

    @Test
    public void whenComparatorByNameAndAgeDecr() {
        Comparator<User> cmpNamePriority = new UserDecrByName().thenComparing(new UserDecrByAge());
        int rsl = cmpNamePriority.compare(
                new User("Ivan", 32),
                new User("Ivan", 31)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByNameIncrAndAge() {
        Comparator<User> cmpNamePriority = new UserIncrByName().thenComparing(new UserDecrByAge());
        int rsl = cmpNamePriority.compare(
                new User("Ivan", 32),
                new User("Petr", 31)
        );
        assertThat(rsl, lessThan(0));
    }
}