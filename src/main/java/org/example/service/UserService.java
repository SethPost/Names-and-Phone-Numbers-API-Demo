package org.example.service;

import org.example.dao.UserDao;
import org.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getUsers(String searchQuery, String sortIndication, int pageSize, int pageNumber) {
        if (pageSize > 50 || pageSize < 0) {
            pageSize = 50;
        }
        if (pageNumber < 1) {
            pageNumber = 1;
        }
        return userDao.getUsers(searchQuery, sortIndication, pageSize, pageNumber);
    }
}
