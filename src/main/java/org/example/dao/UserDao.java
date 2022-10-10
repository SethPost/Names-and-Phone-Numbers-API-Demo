package org.example.dao;

import org.example.model.User;

import java.util.List;

public interface UserDao {

    List<User> getUsers(String searchQuery, String sortIndication);

    List<List<User>> paginateResults(List<User> users, int pageSize);

    List<User> getPage(List<List<User>> users, int pageNumber);

}
