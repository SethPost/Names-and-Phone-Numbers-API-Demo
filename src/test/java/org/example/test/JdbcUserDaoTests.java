package org.example.test;

import org.example.dao.JdbcUserDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;
import java.sql.SQLException;

public class JdbcUserDaoTests extends BaseDaoTests {

    private JdbcUserDao sut;

    @Before
    public void setup() throws SQLException {
        sut = new JdbcUserDao(dataSource);
    }

    @Test
    public void getUsers_no_params_gets_51_users() {
        int databaseSize = 51;
        int result = sut.getUsers("", "").size();

        Assert.assertEquals(databaseSize, result);
    }

    @Test
    public void getUsers_search_Seth_gets_1_result() {
        int result = sut.getUsers("Seth","").size();

        Assert.assertEquals(1, result);
    }


}
