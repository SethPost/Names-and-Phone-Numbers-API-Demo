package org.example.controller;

import org.example.dao.UserDao;
import org.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
//I would include a @PreAuthorize annotation here if I were implementing that in the project
public class UserController {

    @Autowired
    private UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/users")
    public List<User> getUsers(@RequestParam(required = false) String searchQuery, @RequestParam(required = false) String sortIndication,
                               @RequestParam(defaultValue = "50") int pageSize, @RequestParam(defaultValue = "1") int pageNumber) {
        List<List<User>> pages = new ArrayList<>();
        List<User> users = userDao.getAllUsers();
        if (searchQuery != null && sortIndication != null) {
            if (sortIndication.equals("Alphabetical")) {
                users = userDao.getUsersByNameAscending(searchQuery);
            } else if (sortIndication.equals("Reverse Alphabetical")) {
                users = userDao.getUsersByNameDescending(searchQuery);
            } else {
                users = userDao.getUsersByName(searchQuery);
            }
        } else if (searchQuery!= null) {
            users = userDao.getUsersByName(searchQuery);
        } else if (sortIndication != null) {
            if (sortIndication.equals("Alphabetical")) {
                users = userDao.getAllUsersAscending();
            } else if (sortIndication.equals("Reverse Alphabetical")) {
                users = userDao.getAllUsersDescending();
            }
        }
        if (users.size() != 0) {
            pages = userDao.paginateResults(users, pageSize);
            return userDao.getPage(pages, pageNumber);
        } else {
            return users;
        }
    }
}
