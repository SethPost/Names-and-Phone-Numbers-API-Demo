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
    List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT name, phone_number FROM users";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            User user = mapRowToUser(results);
            users.add(user);
        }

        return users;
    }

    private User mapRowToUser(SqlRowSet rowSet) {
        User user = new User();
        user.setUserId(rowSet.getInt("user_id"));
        user.setName(rowSet.getString("name"));
        user.setPhoneNumber(rowSet.getString("phone_number"));
        return user;
    }
}
