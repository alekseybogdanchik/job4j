package ru.job4j.tracker;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class SqlTrackerTest {

    public Connection init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void createItem() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("name"));
            List<Item> rsl = tracker.findByName("name");
            assertThat(rsl.size(), is(1));
        }
    }

   @Test
    public void WhenReplaceItem() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            String id = tracker.add(new Item("name")).getId();
            tracker.replace(id, (new Item("replaced")));
            List<Item> rsl = tracker.findByName("name");
            assertThat(rsl.size(), is(0));
        }
    }
   @Test
    public void WhenAddTwoAndDeleteOneItemsThenDBHasOne() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            List<Item> rsl = tracker.findAll();
            assertThat(rsl.size(), is(0));
            tracker.add(new Item("first"));
            String id = tracker.add(new Item("second")).getId();
            rsl = tracker.findAll();
            assertThat(rsl.size(), is(2));
            tracker.delete(id);
            rsl = tracker.findAll();
            assertThat(rsl.size(), is(1));
        }
    }
   @Test
    public void WhenAddTwoThenDBFindByIdTwoDifferentItems() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            String idFirst = tracker.add(new Item("first")).getId();
            String idSecond = tracker.add(new Item("second")).getId();
            assertThat(tracker.findById(idFirst).getName(), is("first"));
            assertThat(tracker.findById(idSecond).getName(), is("second"));
        }
    }
}