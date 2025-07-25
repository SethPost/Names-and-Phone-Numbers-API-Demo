package org.example.service;

import org.example.dao.UserDao;
import org.example.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.example.util.CommonValues.DEFAULT_PAGE_NUMBER;
import static org.example.util.CommonValues.DEFAULT_PAGE_SIZE;
import static org.example.util.CommonValues.EMPTY_STRING;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserDao userDao;

    @InjectMocks
    private UserService userService;

    @Test
    public void testGetUsers_default_values() {
        List<User> mockResult = new ArrayList<>();
        when(userDao.getUsers(EMPTY_STRING, EMPTY_STRING, DEFAULT_PAGE_SIZE, DEFAULT_PAGE_NUMBER)).thenReturn(mockResult);
        List<User> result = userService.getUsers(EMPTY_STRING, EMPTY_STRING, DEFAULT_PAGE_SIZE, DEFAULT_PAGE_NUMBER);
        verify(userDao, times(1)).getUsers(EMPTY_STRING, EMPTY_STRING, DEFAULT_PAGE_SIZE, DEFAULT_PAGE_NUMBER);
    }

    @Test
    public void testGetUsers_page_size_51() {
        when(userDao.getUsers(any(), any(), anyInt(), anyInt())).thenReturn(Collections.emptyList());
        userService.getUsers(EMPTY_STRING, EMPTY_STRING, DEFAULT_PAGE_SIZE + 1, DEFAULT_PAGE_NUMBER);

        ArgumentCaptor<Integer> pageSizeCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(userDao).getUsers(any(), any(), pageSizeCaptor.capture(), anyInt());

        int actualPageSize = pageSizeCaptor.getValue();
        assertThat(actualPageSize).isEqualTo(DEFAULT_PAGE_SIZE);
    }

    @Test
    public void testGetUsers_page_size_0() {
        when(userDao.getUsers(any(), any(), anyInt(), anyInt())).thenReturn(Collections.emptyList());
        userService.getUsers(EMPTY_STRING, EMPTY_STRING, 0, DEFAULT_PAGE_NUMBER);

        ArgumentCaptor<Integer> pageSizeCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(userDao).getUsers(any(), any(), pageSizeCaptor.capture(), anyInt());

        int actualPageSize = pageSizeCaptor.getValue();
        assertThat(actualPageSize).isEqualTo(0);
    }

    @Test
    public void testGetUsers_page_size_negative() {
        when(userDao.getUsers(any(), any(), anyInt(), anyInt())).thenReturn(Collections.emptyList());
        userService.getUsers(EMPTY_STRING, EMPTY_STRING, -1, DEFAULT_PAGE_NUMBER);

        ArgumentCaptor<Integer> pageSizeCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(userDao).getUsers(any(), any(), pageSizeCaptor.capture(), anyInt());

        int actualPageSize = pageSizeCaptor.getValue();
        assertThat(actualPageSize).isEqualTo(DEFAULT_PAGE_SIZE);
    }

    @Test
    public void testGetUsers_page_number_0() {
        when(userDao.getUsers(any(), any(), anyInt(), anyInt())).thenReturn(Collections.emptyList());
        userService.getUsers(EMPTY_STRING, EMPTY_STRING, 0, DEFAULT_PAGE_NUMBER);

        ArgumentCaptor<Integer> pageNumberCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(userDao).getUsers(any(), any(), anyInt(), pageNumberCaptor.capture());

        int actualPageNumber = pageNumberCaptor.getValue();
        assertThat(actualPageNumber).isEqualTo(DEFAULT_PAGE_NUMBER);
    }
}
