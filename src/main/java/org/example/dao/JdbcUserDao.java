package org.example.dao;

import org.example.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;
import java.util.ArrayList;

import static org.example.util.CommonValues.ALPHABETICAL_SORT;
import static org.example.util.CommonValues.ASC;
import static org.example.util.CommonValues.DESC;
import static org.example.util.CommonValues.LIMIT_STATEMENT;
import static org.example.util.CommonValues.NAME;
import static org.example.util.CommonValues.OFFSET_STATEMENT;
import static org.example.util.CommonValues.ORDER_BY_STATEMENT;
import static org.example.util.CommonValues.PHONE_NUMBER;
import static org.example.util.CommonValues.REVERSE_ALPHABETICAL_SORT;
import static org.example.util.CommonValues.SELECT_STATEMENT;
import static org.example.util.CommonValues.USER_ID;
import static org.example.util.CommonValues.WHERE_STATEMENT;

@Component
public class JdbcUserDao implements UserDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcUserDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<User> getUsers(String searchQuery, String sortIndication, int pageSize, int pageNumber) {

        List<User> users = new ArrayList<>();

        String sqlQuery = buildSqlQuery(searchQuery, sortIndication, pageSize, pageNumber);

        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQuery);
        while (results.next()) {
            User user = mapRowToUser(results);
            users.add(user);
        }
        return users;
    }

    private String buildSqlQuery(String searchQuery, String sortIndication, int pageSize, int pageNumber) {
        StringBuilder sqlQuery = new StringBuilder(SELECT_STATEMENT);

        if (!searchQuery.isBlank()) {
            String whereClause = String.format(WHERE_STATEMENT, searchQuery);
            sqlQuery.append(whereClause);
        }

        if (ALPHABETICAL_SORT.equals(sortIndication)) {
            String orderByClause = String.format(ORDER_BY_STATEMENT, ASC);
            sqlQuery.append(orderByClause);
        }

        if (REVERSE_ALPHABETICAL_SORT.equals(sortIndication)) {
            String orderByClause = String.format(ORDER_BY_STATEMENT, DESC);
            sqlQuery.append(orderByClause);
        }

        String limitClause = String.format(LIMIT_STATEMENT, pageSize);
        sqlQuery.append(limitClause);

        int offset = calculateOffset(pageSize, pageNumber);
        String offsetClause = String.format(OFFSET_STATEMENT, offset);
        sqlQuery.append(offsetClause);

        return sqlQuery.toString();
    }

    private int calculateOffset(int pageSize, int pageNumber) {
        int indexNumber = pageNumber - 1;
        return indexNumber * pageSize;
    }

    private User mapRowToUser(SqlRowSet rowSet) {
        User user = new User();
        user.setUserId(rowSet.getInt(USER_ID));
        user.setName(rowSet.getString(NAME));
        user.setPhoneNumber(rowSet.getString(PHONE_NUMBER));
        return user;
    }
}
