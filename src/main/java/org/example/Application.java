package org.example;

import org.apache.commons.dbcp2.BasicDataSource;
import org.example.dao.JdbcUserDao;
import org.example.dao.UserDao;
import org.example.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
public class Application {


    public static void main(String[] args) {
        
        SpringApplication.run(Application.class, args);
    }

//        private void run() {
//        // Instantiating datasource and setting connection string
//        BasicDataSource dataSource = new BasicDataSource();
//        dataSource.setUrl("jdbc:postgresql://localhost:5432/interviewDB");
//        // Setting credentials. This would be externalized in a "real" project.
//        dataSource.setUsername("postgres");
//        dataSource.setPassword("postgres1");
//
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//    }
}