package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {
    private Connection cn;

    public SqlTracker(Connection cn) {
        this.cn = cn;
    }

    public SqlTracker() {
    }

    @Override
    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
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
        try (PreparedStatement prSt = cn.prepareStatement("INSERT INTO items(name) VALUES(?)", Statement.RETURN_GENERATED_KEYS)) {
            prSt.setString(1, item.getName());
            prSt.executeUpdate();
            ResultSet generatedKeys = prSt.getGeneratedKeys();
            if (generatedKeys.next()) {
                String strId = Integer.toString(generatedKeys.getInt(1));
                item.setId(strId);
            }
        } catch (SQLException eSQL) {
            eSQL.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(String id, Item item) {
        boolean rsl = false;
        int rows = -1;
        int intId = Integer.parseInt(id);
        try (PreparedStatement prSt = cn.prepareStatement("UPDATE items SET name=? WHERE id=?")) {
            prSt.setString(1, item.getName());
            prSt.setInt(2, intId);
            rows = prSt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (rows == 1) {
            rsl = true;
        }
        return rsl;
    }

    @Override
    public boolean delete(String id) {
        boolean rsl = false;
        int rows = -1;
        int intId = Integer.parseInt(id);
        try (PreparedStatement prSt = cn.prepareStatement("DELETE FROM items WHERE id=?")) {
            prSt.setInt(1, intId);
            rows = prSt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (rows == 1) {
            rsl = true;
        }
        return rsl;
    }

    @Override
    public List<Item> findAll() {
        List<Item> rsl = new ArrayList<>();
        try (PreparedStatement prSt = cn.prepareStatement("SELECT * FROM items")) {
            ResultSet rs = prSt.executeQuery();
            while (rs.next()) {
                Item item = new Item(rs.getString("name"));
                String dbId = Integer.toString(rs.getInt("id"));
                item.setId(dbId);
                rsl.add(item);
            }
        } catch (SQLException eSQL) {
            eSQL.printStackTrace();
        }
        return rsl;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        try (PreparedStatement prSt = cn.prepareStatement("SELECT * FROM items WHERE name=?")) {
            prSt.setString(1, key);
            ResultSet rs = prSt.executeQuery();
            while (rs.next()) {
                Item item = new Item(rs.getString("name"));
                String dbId = Integer.toString(rs.getInt("id"));
                item.setId(dbId);
                rsl.add(item);
            }
        } catch (SQLException eSQL) {
            eSQL.printStackTrace();
        }
        return rsl;
    }

    @Override
    public Item findById(String id) {
        Item item = null;
        int intId = Integer.parseInt(id);
        try (PreparedStatement prSt = cn.prepareStatement("SELECT * FROM items WHERE id=?")) {
            prSt.setInt(1, intId);
            ResultSet rs = prSt.executeQuery();
            if (rs.next()) {
                item = new Item(rs.getString("name"));
                String dbId = Integer.toString(rs.getInt("id"));
                item.setId(dbId);
            }
        } catch (SQLException eSQL) {
            eSQL.printStackTrace();
        }
        return item;
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }
}
