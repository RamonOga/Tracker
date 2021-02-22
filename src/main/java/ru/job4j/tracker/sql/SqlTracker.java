package ru.job4j.tracker.sql;

import ru.job4j.tracker.Item;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {
    private Connection cn;

    public SqlTracker(Connection connection) {
        this.cn = connection;
    }

    public SqlTracker() {
    }

    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
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
    public Item add(Item item) {
        Item rsl = null;
            String query = String.format("insert into items (name) values ('%s');", item.getName());
            if (executeQuery(query)) {
                rsl = item;
            }
        return rsl;
    }

    @Override
    public boolean replace(String id, Item item) {
        String query = String.format("update items set name='%s' where id=%s;", item.getName(), id);
        return executeQuery(query);
    }

    @Override
    public boolean delete(String id) {
        String query = String.format("delete from items where id='%s';", id);
        return executeQuery(query);
    }

    @Override
    public List<Item> findAll() {
        List<Item> listItems = new ArrayList<>();
        String query = "select * from items;";
        ResultSet rs = executeQueryWithResultSet(query);
        try {
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
        List<Item> rsl = new ArrayList<>();
        String query = String.format("select * from items where name='%s';", key);
        ResultSet rs = executeQueryWithResultSet(query);
        try {
            while (rs.next()) {
                rsl.add(new Item(rs.getInt("id"), rs.getString("name")));
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return rsl;
    }

    @Override
    public Item findById(String id) {
        Item rsl = null;
        String query = String.format("select * from items where id='%s';", id);
        ResultSet rs = executeQueryWithResultSet(query);
        try {
            rs.next();
            rsl = new Item(rs.getInt("id"), rs.getString("name"));
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return rsl;
    }

    public void dropTable(String table) {
        executeQuery(String.format("drop table %s", table));
    }

    public void createTable(String table) {
        executeQuery(String.format("create table %s (id serial primary key, name text);", table));
    }

    private boolean executeQuery(String query) {
        boolean rsl = false;
        try (Statement st = cn.createStatement()) {
            st.execute(query);
            if (st.getUpdateCount() > 0) {
                rsl =  true;
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return rsl;
    }

    private ResultSet executeQueryWithResultSet(String query) {
        ResultSet rsl = null;
        try (Statement st = cn.createStatement()) {
            st.execute(query);
            rsl = st.getResultSet();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return rsl;
    }

    @Override
    public void close() {
        if (cn != null) {
            try {
                cn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}