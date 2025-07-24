package org.example.controller;

import org.example.exception.PageSizeOrPageNumberInvalidException;
import org.example.logging.Logger;
import org.example.model.User;
import org.example.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PreAuthorize("permitAll")
    @GetMapping("/users")
    public List<User> getUsers(@RequestParam(required = false) String searchQuery, @RequestParam(required = false) String sortIndication,
                               @RequestParam(defaultValue = "50") int pageSize, @RequestParam(defaultValue = "1") int pageNumber) throws PageSizeOrPageNumberInvalidException {

        Logger logger = new Logger();
        logger.logSearch(searchQuery, sortIndication, pageSize, pageNumber);

        return userService.getUsers(searchQuery, sortIndication, pageSize, pageNumber);
    }
}
