package ru.job4j.tracker;

import java.io.FileReader;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {
    private Connection cn;

    public void init() {
        try (/*InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("./src/main/resources/app.properties")*/
                FileReader in = new FileReader("./src/main/resources/app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) {
        return null;
    }

    @Override
    public boolean replace(String id, Item item) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public List<Item> findAll() {
        List<Item> listItems = new ArrayList<>();
        try(Statement st = cn.createStatement()) {
            String sql = "select * from items;";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                listItems.add(new Item(rs.getInt("id"), rs.getString("name")));
            }
        } catch (SQLException se) {
            se.fillInStackTrace();
        }
        return listItems;
    }

    @Override
    public List<Item> findByName(String key) {
        return null;
    }

    @Override
    public Item findById(String id) {
        return null;
    }
}