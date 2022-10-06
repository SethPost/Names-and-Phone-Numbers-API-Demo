package org.example.controller;

import org.example.dao.UserDao;
import org.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @GetMapping("/users-ascending/?q={searchQuery}")
    public List<User> getUsersByNameAscending(@PathVariable String searchQuery) {
        return userDao.getUsersByNameAscending(searchQuery);
    }

    @GetMapping("/users-descending/?q={searchQuery}")
    public List<User> getUsersByNameDescending(@PathVariable String searchQuery) {
        return userDao.getUsersByNameDescending(searchQuery);
    }

    @GetMapping("/users-ascending-paginated/?q={searchQuery}&n={usersPerPage}")
    public List<List<User>> getUsersByNameAscendingPaginated(@PathVariable String searchQuery, @PathVariable int usersPerPage) {
        return userDao.getUsersByNameAscendingPaginated(searchQuery, usersPerPage);
    }

    @GetMapping("/users-descending-paginated/?q={searchQuery}&n={usersPerPage}")
    public List<List<User>> getUsersByNameDescendingPaginated(@PathVariable String searchQuery, @PathVariable int usersPerPage) {
        return userDao.getUsersByNameDescendingPaginated(searchQuery, usersPerPage);
    }

}
