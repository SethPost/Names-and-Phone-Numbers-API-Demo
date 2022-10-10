package org.example.dao;

import org.example.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;
import java.util.ArrayList;

@Component
public class JdbcUserDao implements UserDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcUserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcUserDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<User> getUsers(String searchQuery, String sortIndication) {

        // Declare the list we will ultimately return.
        List<User> users = new ArrayList<>();

        // Starter sql statement that we will add onto depending on the search parameters provided.
        String sql = "Select user_id, name, phone_number FROM users";

        // If both a searchQuery and sortIndication are provided
        if (searchQuery != null && sortIndication != null) {

            // If sortIndication is alphabetical
            if (sortIndication.equals("Alphabetical")) {
                sql += " WHERE name LIKE '%" + searchQuery + "%' ORDER BY name ASC";

            // If sortIndication is reverse alphabetical
            } else if (sortIndication.equals("Reverse Alphabetical")) {
                sql += " WHERE name LIKE '%" + searchQuery + "%' ORDER BY name DESC";

            // If a sortIndication is provided but doesn't match "Alphabetical"
            // or "Reverse Alphabetical", results will be sorted by default (entry number)
            } else {
                sql += " WHERE name LIKE '%" + searchQuery + "%'";
            }

        // If only a searchQuery is provided, no sortIndication
        } else if (searchQuery != null) {
            sql += " WHERE name LIKE '%" + searchQuery + "%'";

        // If only sortIndication is provided, no searchQuery
        } else if (sortIndication != null) {
            if (sortIndication.equals("Alphabetical")) {
                sql += " ORDER BY name ASC";
            } else if (sortIndication.equals("Reverse Alphabetical")) {
                sql += " ORDER BY name DESC";
            }
        }

        // Map results of database search to User model, add each one
        // to the users list we declared at start of method.
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
