package org.example.test;

import org.example.dao.JdbcUserDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;


import javax.sql.DataSource;

public class JdbcUserDaoTests extends BaseDaoTests {

    private JdbcUserDao sut;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcUserDao(jdbcTemplate);
    }

    @Test
    public void getUsers_no_params_gets_51_users() {
        int databaseSize = 51;
        int result = sut.getUsers("", "").size();

        Assert.assertEquals(databaseSize, result);
    }


}
