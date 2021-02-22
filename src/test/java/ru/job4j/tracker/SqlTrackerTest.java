package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.tracker.sql.ConnectionRollback;
import ru.job4j.tracker.sql.SqlTracker;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SqlTrackerTest {

    public Connection init() {
        try (InputStream in = SqlTracker.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
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
    public void addItemTest() throws SQLException {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("desc"));
            Assert.assertEquals(tracker.findByName("desc").size(), 1);
        }
    }

    @Test
    public void replaceItemTest() throws SQLException {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("desc"));
            Item item = new Item("asc");
            String id = Integer.toString(tracker.findByName("desc").get(0).getId());
            tracker.replace(id, item);
            Assert.assertEquals(tracker.findByName("asc").size(), 1);
        }
    }

    @Test
    public void findByNameTest() throws SQLException {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("desc"));
            tracker.add(new Item("desc"));
            tracker.add(new Item("asc"));
            Assert.assertEquals(tracker.findByName("asc").size(), 1);
            Assert.assertEquals(tracker.findByName("desc").size(), 2);
        }
    }

    @Test
    public void deleteItemTest() throws SQLException {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("desc"));
            tracker.add(new Item("asc"));
            String descId = String.valueOf(tracker.findByName("desc").get(0).getId());
            String ascId = String.valueOf(tracker.findByName("asc").get(0).getId());
            Assert.assertEquals(tracker.findById(descId).getName(), "desc");
            Assert.assertEquals(tracker.findById(ascId).getName(), "asc");
            tracker.delete(descId);
            tracker.delete(ascId);
            Assert.assertEquals(tracker.findByName("asc").size(), 0);
            Assert.assertEquals(tracker.findByName("desc").size(), 0);
        }
    }
}