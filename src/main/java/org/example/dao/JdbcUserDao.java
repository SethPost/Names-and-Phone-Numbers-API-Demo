package org.example.dao;

import org.example.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.ArrayList;

@Component
public class JdbcUserDao implements UserDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcUserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "Select * FROM users";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            User user = mapRowToUser(results);
            users.add(user);
        }
        return users;
    }

    @Override
    public List<User> getAllUsersAscending() {
        List<User> users = new ArrayList<>();
        String sql = "Select * FROM users ORDER BY name ASC";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            User user = mapRowToUser(results);
            users.add(user);
        }
        return users;
    }

    @Override
    public List<User> getAllUsersDescending() {
        List<User> users = new ArrayList<>();
        String sql = "Select * FROM users ORDER BY name DESC";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            User user = mapRowToUser(results);
            users.add(user);
        }
        return users;
    }

    @Override
    public List<User> getUsersByName(String searchQuery) {
        List<User> users = new ArrayList<>();
        String sql = "SELECT user_id, name, phone_number FROM users WHERE name LIKE '%" + searchQuery + "%'";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            User user = mapRowToUser(results);
            users.add(user);
        }
        return users;
    }

    //This method gets all users by search query ascending but does not paginate.
    @Override
    public List<User> getUsersByNameAscending(String searchQuery) {
        List<User> users = new ArrayList<>();
        String sql = "SELECT user_id, name, phone_number FROM users WHERE name LIKE '%" + searchQuery + "%' ORDER BY name ASC";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            User user = mapRowToUser(results);
            users.add(user);
        }
        return users;
    }

    //This method gets all users by search query descending but does not paginate.
    @Override
    public List<User> getUsersByNameDescending(String searchQuery) {
        List<User> users = new ArrayList<>();
        String sql = "SELECT user_id, name, phone_number FROM users WHERE name LIKE '%" + searchQuery + "%' ORDER BY name DESC";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            User user = mapRowToUser(results);
            users.add(user);
        }
        return users;
    }

    @Override
    public List<List<User>> getUsersByNameAscendingPaginated(String searchQuery, int usersPerPage) {
        //making a note here: sql "LIKE '%value1%' contains value1
        List<List<User>> usersAscending = new ArrayList<>();
        String sql = "SELECT user_id, name, phone_number FROM users WHERE name LIKE '%" + searchQuery + "%' ORDER BY name ASC";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, searchQuery);
        if (results.next()) {

        }

        return usersAscending;
    }

    @Override
    public List<List<User>> getUsersByNameDescendingPaginated(String searchQuery, int usersPerPage) {
        //making a note here: sql "LIKE '%value1%' contains value1
        List<List<User>> usersDescending = new ArrayList<>();

        return usersDescending;
    }

    private User mapRowToUser(SqlRowSet rowSet) {
        User user = new User();
        user.setUserId(rowSet.getInt("user_id"));
        user.setName(rowSet.getString("name"));
        user.setPhoneNumber(rowSet.getString("phone_number"));
        return user;
    }
}
