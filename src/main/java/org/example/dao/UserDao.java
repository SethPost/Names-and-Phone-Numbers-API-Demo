package org.example.dao;

import org.example.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    List<User> getUsersByName(String searchQuery);

    List<User> getUsersByNameAscending(String searchQuery);

    List<User> getUsersByNameDescending(String searchQuery);

    List<List<User>> getUsersByNameAscendingPaginated(String searchQuery, int usersPerPage);

    List<List<User>> getUsersByNameDescendingPaginated(String searchQuery, int usersPerPage);
}
