package org.example.dao;

import org.example.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    List<List<User>> getUsersByNameAscending(String searchQuery, int usersPerPage);

    List<List<User>> getUsersByNameDescending(String searchQuery, int usersPerPage);
}
