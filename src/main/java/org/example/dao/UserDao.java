package org.example.dao;

import org.example.model.User;
import java.util.List;

public interface UserDao {

    List<User> getUsers(String searchQuery, String sortIndication, int pageSize, int pageNumber);
}
