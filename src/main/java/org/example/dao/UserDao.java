package org.example.dao;

import org.example.exception.PageSizeOrPageNumberInvalidException;
import org.example.model.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserDao {

    List<User> getUsers(String searchQuery, String sortIndication);

    List<List<User>> paginateResults(List<User> users, int pageSize) throws PageSizeOrPageNumberInvalidException;

    List<User> getPage(List<List<User>> users, int pageNumber) throws PageSizeOrPageNumberInvalidException;

}
