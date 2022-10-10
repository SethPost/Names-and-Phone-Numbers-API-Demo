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

    // This method gets all users in the database.
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

    // This method gets all users in the database in alphabetical order by name.
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

    // This method gets all users in the database in reverse alphabetical order by name.
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

    // This method uses a search query to return all users whose names contain the search query (case-sensitive).
    // It returns the users in order of their entry number (or userId).
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

    // This method uses a search query to return all users whose names contain the search query (case-sensitive).
    // It returns the users in alphabetical order by name.
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

    // This method uses a search query to return all users whose names contain the search query (case-sensitive).
    // It returns the users in reverse alphabetical order by name.
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

    //This method takes a list and paginates it by the number of users per page provided.
    @Override
    public List<List<User>> paginateResults(List<User> users, int pageSize) {

        // Initialize an empty list of pages (or list of lists of users)
        List<List<User>> pages = new ArrayList<>();

        // Setting up the first loop. The iterator increases by pageSize so that each list does not overlap.
        for (int i = 0; i < users.size(); i += pageSize) {

            // Initialize an empty list of users at the start of each page (every time the first loop starts again).
            List<User> pageOfUsers = new ArrayList<>();

            // The second loop starts at the beginning of each new 'page' (indicated by 'i')
            // It adds users to the current page until the end of the page is reached OR the end of the users list is reached.
            for (int j = i; (j < i + pageSize) && (j < users.size()); j++) {
                pageOfUsers.add(users.get(j));
            }

            // Adding the 'page' created by the second loop to our list of pages before starting on the next page.
            pages.add(pageOfUsers);
        }
        return pages;
    }

    //This method takes a list of pages and returns the one indicated by pageNumber.
    @Override
    public List<User> getPage(List<List<User>> users, int pageNumber) {
        if (pageNumber > users.size()) {
            pageNumber = users.size();
        } else if (pageNumber < 1) {
            pageNumber = 1;
        }
        return users.get(pageNumber - 1);
    }

    private User mapRowToUser(SqlRowSet rowSet) {
        User user = new User();
        user.setUserId(rowSet.getInt("user_id"));
        user.setName(rowSet.getString("name"));
        user.setPhoneNumber(rowSet.getString("phone_number"));
        return user;
    }
}
