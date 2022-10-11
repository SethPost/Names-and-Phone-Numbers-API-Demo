package org.example.test;

import org.example.dao.JdbcUserDao;
import org.example.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.sql.SQLException;
import java.util.List;

public class JdbcUserDaoTests extends BaseDaoTests {

    private JdbcUserDao sut;

    @Before
    public void setup() throws SQLException {
        sut = new JdbcUserDao(dataSource);
    }

    @Test
    public void getUsers_no_params_gets_51_users() {
        int databaseSize = 51;
        int result = sut.getUsers("", "").size();

        Assert.assertEquals(databaseSize, result);
    }

    @Test
    public void getUsers_search_seth_gets_1_result() {
        int result = sut.getUsers("seth","").size();

        Assert.assertEquals(1, result);
    }

    @Test
    public void getUsers_search_ll_gets_13_results() {
        int result = sut.getUsers("ll", "").size();

        Assert.assertEquals(13, result);
    }

    @Test
    public void getUsers_no_sortIndication_returns_Seth_Post_first() {
        User resultUser = sut.getUsers("", "").get(0);
        String resultUserName = resultUser.getName();

        Assert.assertEquals("Seth Post", resultUserName);
    }

    @Test
    public void getUsers_nonsense_sortIndication_returns_Allina_Sayle_last() {
        List<User> users = sut.getUsers("", "as;dlfkj");
        User resultUser = users.get(users.size() - 1);
        String resultUserName = resultUser.getName();

        Assert.assertEquals("Allina Sayle", resultUserName);
    }

    @Test
    public void getUsers_alphabetical_returns_Addy_Littrik_first() {
        User resultUser = sut.getUsers("", "Alphabetical").get(0);
        String resultUserName = resultUser.getName();

        Assert.assertEquals("Addy Littrik", resultUserName);
    }

    @Test
    public void getUsers_alphabetical_returns_Yorker_Moxham_last() {
        List<User> users = sut.getUsers("", "Alphabetical");
        User resultUser = users.get(users.size() - 1);
        String resultUserName = resultUser.getName();

        Assert.assertEquals("Yorker Moxham", resultUserName);
    }

    @Test
    public void getUsers_reverse_alphabetical_returns_Yorker_Moxham_first() {
        User resultUser = sut.getUsers("", "Reverse Alphabetical").get(0);
        String resultUserName = resultUser.getName();

        Assert.assertEquals("Yorker Moxham", resultUserName);
    }

    @Test
    public void getUsers_reverse_alphabetical_returns_Addy_Littrik_last() {
        List<User> users = sut.getUsers("", "Reverse Alphabetical");
        User resultUser = users.get(users.size() - 1);
        String resultUserName = resultUser.getName();

        Assert.assertEquals("Addy Littrik", resultUserName);
    }

    @Test
    public void getUsers_search_s_alphabetical_returns_Allina_Sayle_first() {
        User resultUser = sut.getUsers("s", "Alphabetical").get(0);
        String resultUserName = resultUser.getName();

        Assert.assertEquals("Allina Sayle", resultUserName);
    }

    @Test
    public void getUsers_search_s_alphabetical_returns_Willow_Rosekilly_last() {
        List<User> users = sut.getUsers("s", "Alphabetical");
        User resultUser = users.get(users.size() - 1);
        String resultUserName = resultUser.getName();

        Assert.assertEquals("Willow Rosekilly", resultUserName);
    }

    @Test
    public void getUsers_search_s_reverse_alphabetical_returns_Willow_Rosekilly_first() {
        User resultUser = sut.getUsers("s", "Reverse Alphabetical").get(0);
        String resultUserName = resultUser.getName();

        Assert.assertEquals("Willow Rosekilly", resultUserName);
    }

    @Test
    public void getUsers_search_s_reverse_alphabetical_returns_Allina_Sayle_last() {
        List<User> users = sut.getUsers("s", "Reverse Alphabetical");
        User resultUser = users.get(users.size() - 1);
        String resultUserName = resultUser.getName();

        Assert.assertEquals("Allina Sayle", resultUserName);
    }

    @Test
    public void paginateResults_max_page_size_is_50() {
        List<User> allUsers = sut.getUsers("", "");
        List<List<User>> paginatedList = sut.paginateResults(allUsers, 51);

        Assert.assertEquals(2, paginatedList.size());
    }

    @Test
    public void paginateResults_min_page_size_is_1() {
        List<User> allUsers = sut.getUsers("", "");
        List<List<User>> paginatedList = sut.paginateResults(allUsers, 0);

        Assert.assertEquals(51, paginatedList.size());
    }

    @Test
    public void getPage_search_s_alphabetical_pageSize_4_pageNumber_2_returns_Christoph_Bengough_first() {
        List<User> users = sut.getUsers("s", "Alphabetical");
        List<List<User>> paginatedList = sut.paginateResults(users, 4);
        List<User> pageTwo = sut.getPage(paginatedList, 2);
        User resultUser = pageTwo.get(0);
        String resultName = resultUser.getName();

        Assert.assertEquals("Christoph Bengough", resultName);
    }

    @Test
    public void getPage_pageSize_51_pageNumber_3_returns_Allina_Sayle_only() {
        List<User> users = sut.getUsers("", "");
        List<List<User>> paginatedList = sut.paginateResults(users, 51);
        List<User> lastPage = sut.getPage(paginatedList, 3);
        User resultUser = lastPage.get(0);
        String resultName = resultUser.getName();

        Assert.assertEquals("Allina Sayle", resultName);
    }
}
