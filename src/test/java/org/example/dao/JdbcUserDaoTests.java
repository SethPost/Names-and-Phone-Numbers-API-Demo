package org.example.dao;

import org.example.model.User;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.util.CommonValues.ALPHABETICAL_SORT;
import static org.example.util.CommonValues.DEFAULT_PAGE_NUMBER;
import static org.example.util.CommonValues.DEFAULT_PAGE_SIZE;
import static org.example.util.CommonValues.EMPTY_STRING;
import static org.example.util.CommonValues.REVERSE_ALPHABETICAL_SORT;

public class JdbcUserDaoTests extends BaseDaoTests {

    private JdbcUserDao jdbcUserDao;

    @Before
    public void setup() {
        jdbcUserDao = new JdbcUserDao(dataSource);
    }

    @Test
    public void getUsers_get_all_rows() {
        int databaseSize = 202;
        int absurdlyLargePageSize = 9999;
        List<User> result = jdbcUserDao.getUsers(EMPTY_STRING, EMPTY_STRING, absurdlyLargePageSize, DEFAULT_PAGE_NUMBER);

        assertThat(result).hasSize(databaseSize);
    }

    @Test
    public void getUsers_search_seth_gets_1_result() {
        List<User> result = jdbcUserDao.getUsers("seth", EMPTY_STRING, DEFAULT_PAGE_SIZE, DEFAULT_PAGE_NUMBER);

        assertThat(result).hasSize(1);
    }

    @Test
    public void getUsers_search_ll_gets_46_results() {
        List<User> result = jdbcUserDao.getUsers("ll", EMPTY_STRING, DEFAULT_PAGE_SIZE, DEFAULT_PAGE_NUMBER);

        assertThat(result).hasSize(46);
    }

    @Test
    public void getUsers_no_sortIndication_returns_Seth_Post_first() {
        User resultUser = jdbcUserDao.getUsers(EMPTY_STRING, EMPTY_STRING, DEFAULT_PAGE_SIZE, DEFAULT_PAGE_NUMBER).get(0);
        String resultUserName = resultUser.getName();

        assertThat(resultUserName).isEqualTo("Seth Post");
    }

    @Test
    public void getUsers_nonsense_sortIndication_returns_Ellary_Castlake_last() {
        List<User> users = jdbcUserDao.getUsers(EMPTY_STRING, "as;dlfkj", DEFAULT_PAGE_SIZE, DEFAULT_PAGE_NUMBER);
        User resultUser = users.get(users.size() - 1);
        String resultUserName = resultUser.getName();

        assertThat(resultUserName).isEqualTo("Ellary Castlake");
    }

    @Test
    public void getUsers_alphabetical_returns_Aaron_Dragonette_first() {
        User resultUser = jdbcUserDao.getUsers(EMPTY_STRING, ALPHABETICAL_SORT, DEFAULT_PAGE_SIZE, DEFAULT_PAGE_NUMBER).get(0);
        String resultUserName = resultUser.getName();

        assertThat(resultUserName).isEqualTo("Aaron Dragonette");
    }

    @Test
    public void getUsers_alphabetical_returns_Eberhard_Hasted_last() {
        List<User> users = jdbcUserDao.getUsers(EMPTY_STRING, ALPHABETICAL_SORT, DEFAULT_PAGE_SIZE, DEFAULT_PAGE_NUMBER);
        User resultUser = users.get(users.size() - 1);
        String resultUserName = resultUser.getName();

        assertThat(resultUserName).isEqualTo("Eberhard Hasted");
    }

    @Test
    public void getUsers_reverse_alphabetical_returns_Zaccaria_Alf_first() {
        User resultUser = jdbcUserDao.getUsers(EMPTY_STRING, REVERSE_ALPHABETICAL_SORT, DEFAULT_PAGE_SIZE, DEFAULT_PAGE_NUMBER).get(0);
        String resultUserName = resultUser.getName();

        assertThat(resultUserName).isEqualTo("Zaccaria Alf");
    }

    @Test
    public void getUsers_reverse_alphabetical_returns_Percival_Vequaud_last() {
        List<User> users = jdbcUserDao.getUsers(EMPTY_STRING, REVERSE_ALPHABETICAL_SORT, DEFAULT_PAGE_SIZE, DEFAULT_PAGE_NUMBER);
        User resultUser = users.get(users.size() - 1);
        String resultUserName = resultUser.getName();

        assertThat(resultUserName).isEqualTo("Percival Vequaud");
    }

    @Test
    public void getUsers_search_s_alphabetical_returns_Adriaens_Sarchwel_first() {
        User resultUser = jdbcUserDao.getUsers("s", ALPHABETICAL_SORT, DEFAULT_PAGE_SIZE, DEFAULT_PAGE_NUMBER).get(0);
        String resultUserName = resultUser.getName();

        assertThat(resultUserName).isEqualTo("Adriaens Sarchwell");
    }

    @Test
    public void getUsers_search_s_alphabetical_returns_Lea_Bushell_last() {
        List<User> users = jdbcUserDao.getUsers("s", ALPHABETICAL_SORT, DEFAULT_PAGE_SIZE, DEFAULT_PAGE_NUMBER);
        User resultUser = users.get(users.size() - 1);
        String resultUserName = resultUser.getName();

        assertThat(resultUserName).isEqualTo("Lea Bushell");
    }

    @Test
    public void getUsers_search_s_reverse_alphabetical_returns_Willow_Rosekilly_first() {
        User resultUser = jdbcUserDao.getUsers("s", REVERSE_ALPHABETICAL_SORT, DEFAULT_PAGE_SIZE, DEFAULT_PAGE_NUMBER).get(0);
        String resultUserName = resultUser.getName();

        assertThat(resultUserName).isEqualTo("Willow Rosekilly");
    }

    @Test
    public void getUsers_search_s_reverse_alphabetical_returns_Lea_Bushell_last() {
        List<User> users = jdbcUserDao.getUsers("s", REVERSE_ALPHABETICAL_SORT, DEFAULT_PAGE_SIZE, DEFAULT_PAGE_NUMBER);
        User resultUser = users.get(users.size() - 1);
        String resultUserName = resultUser.getName();

        assertThat(resultUserName).isEqualTo("Lea Bushell");
    }

    @Test
    public void getUsers_pageSize_0() {
        List<User> result = jdbcUserDao.getUsers(EMPTY_STRING, EMPTY_STRING, 0, DEFAULT_PAGE_NUMBER);

        assertThat(result).hasSize(0);
    }

    @Test
    public void getPage_search_s_alphabetical_pageSize_4_pageNumber_2_returns_Ansel_Pinilla_first() {
        User resultUser = jdbcUserDao.getUsers("s", ALPHABETICAL_SORT, 4, 2).get(0);
        String resultUserName = resultUser.getName();

        assertThat(resultUserName).isEqualTo("Ansel Pinilla");
    }

    @Test
    public void getPage_pageSize_50_pageNumber_5_returns_only_2_results() {
        List<User> result = jdbcUserDao.getUsers(EMPTY_STRING, EMPTY_STRING, DEFAULT_PAGE_SIZE, 5);

        assertThat(result).hasSize(2);
    }
}
