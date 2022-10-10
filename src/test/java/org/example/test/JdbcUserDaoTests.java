package org.example.test;

import org.example.dao.JdbcUserDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class JdbcUserDaoTests {

    private JdbcUserDao sut;
    private DataSource dataSource;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcUserDao(jdbcTemplate);
    }

    @Test
    public void getUsers_gets_202_users() {
        int databaseSize = 202;
        int result = sut.getUsers("", "").size();

        Assert.assertEquals(databaseSize, result);
    }


}
