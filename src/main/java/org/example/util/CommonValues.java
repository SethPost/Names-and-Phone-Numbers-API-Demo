package org.example.util;

public class CommonValues {

    public static final String USER_ID = "user_id";
    public static final String NAME = "name";
    public static final String PHONE_NUMBER = "phone_number";
    public static final String USERS = "users";

    public static final String ALPHABETICAL_SORT = "Alphabetical";
    public static final String REVERSE_ALPHABETICAL_SORT = "Reverse Alphabetical";
    public static final int DEFAULT_PAGE_SIZE = 50;
    public static final int DEFAULT_PAGE_NUMBER = 1;

    public static final String ASC = "ASC";
    public static final String DESC = "DESC";

    public static final String SELECT_STATEMENT = "SELECT " + USER_ID + ", " + NAME + ", " + PHONE_NUMBER + " FROM " + USERS;
    public static final String WHERE_STATEMENT = " WHERE " + NAME + " ILIKE '%%%s%%'";
    public static final String ORDER_BY_STATEMENT = " ORDER BY " + NAME + " %s";
    public static final String LIMIT_STATEMENT = " LIMIT %d";
    public static final String OFFSET_STATEMENT = " OFFSET %d";

    public static final String EMPTY_STRING = "";
}
