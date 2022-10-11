package org.example.controller;

import org.example.dao.UserDao;
import org.example.exception.PageSizeOrPageNumberInvalidException;
import org.example.logging.Logger;
import org.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @PreAuthorize("permitAll")
    @GetMapping("/users")
    public List<User> getUsers(@RequestParam(required = false) String searchQuery, @RequestParam(required = false) String sortIndication,
                               @RequestParam(defaultValue = "50") int pageSize, @RequestParam(defaultValue = "1") int pageNumber) throws PageSizeOrPageNumberInvalidException {

        // Log the search first
        Logger logger = new Logger();
        logger.logSearch(searchQuery, sortIndication, pageSize, pageNumber);
        // Start by declaring a new list of lists that will be used to pull a single page from.
            List<List<User>> pages = new ArrayList<>();

        // Get a list of all users that we will then filter out by request params.
            List<User> users = userDao.getUsers(searchQuery, sortIndication);

        // Checking that our resulting list is not empty. If not, the list is paginated by the pageSize indicated.

        // Make sure pageSize is not more than 50, less than 1, or not a number.
        // This code is in the JdbcUserDao method but did not reflect the pageSize change
        // in the logger.
        // Make sure pageSize is not more than 50 or less than 1.
        if (pageSize > 50) {
            pageSize = 50;
        } else if (pageSize < 1) {
            pageSize = 1;
        }
        else if (pageSize >= 1 || pageSize <= 0) {
            pageSize += 0;
        } else {
            throw new PageSizeOrPageNumberInvalidException();
        }

            if (users.size() != 0) {
                pages = userDao.paginateResults(users, pageSize);

                // Ensuring that the pageNumber requested exists in our paginated list.
                if (pageNumber > pages.size()) {
                    pageNumber = pages.size();
                } else if (pageNumber < 1) {
                    pageNumber = 1;
                }

                // Log the response before returning it
                logger.logResponse(searchQuery, sortIndication, pageSize, pageNumber, userDao.getPage(pages, pageNumber));

                // Returning the specific page requested from our paginated list of results.
                return userDao.getPage(pages, pageNumber);

                // Returns an empty list. Avoids IndexOutOfBoundsException.
            } else {
                // Log the response before returning it
                logger.logResponse(searchQuery, sortIndication, pageSize, pageNumber, users);

                return users;
            }
    }
}
