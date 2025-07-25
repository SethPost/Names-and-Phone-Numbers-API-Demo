package org.example.controller;

import org.example.model.User;
import org.example.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.example.util.CommonValues.ALPHABETICAL_SORT;
import static org.example.util.CommonValues.DEFAULT_PAGE_NUMBER;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void testGetUsers_withDefaults_returns200() throws Exception {
        Mockito.when(userService.getUsers(any(), any(), anyInt(), anyInt()))
                .thenReturn(Collections.emptyList());

        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        verify(userService).getUsers(null, null, 50, 1);
    }

    @Test
    public void testGetUsers_withParams_returns200() throws Exception {
        User testUser = new User(1, "Seth Post", "3308073006");
        List<User> testUsers = List.of(testUser);

        Mockito.when(userService.getUsers(any(), any(), anyInt(), anyInt()))
                .thenReturn(testUsers);

        mockMvc.perform(get("/users")
                        .param("searchQuery", "seth")
                        .param("sortIndication", ALPHABETICAL_SORT)
                        .param("pageSize", "1")
                        .param("pageNumber", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].userId").value(testUser.getUserId()))
                .andExpect(jsonPath("$[0].name").value(testUser.getName()))
                .andExpect(jsonPath("$[0].phoneNumber").value(testUser.getPhoneNumber()));


        verify(userService).getUsers("seth", ALPHABETICAL_SORT, 1, DEFAULT_PAGE_NUMBER);
    }
}
