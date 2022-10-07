package org.example.dao;

import org.example.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    List<User> getAllUsersAscending();

    List<User> getAllUsersDescending();

    List<User> getUsersByName(String searchQuery);

    List<User> getUsersByNameAscending(String searchQuery);

    List<User> getUsersByNameDescending(String searchQuery);

    List<List<User>> paginateResults(List<User> users, int pageSize);

    List<User> getPage(List<List<User>> users, int pageNumber);

}
