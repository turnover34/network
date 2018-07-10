package com.dvoinenko.userstore.service;

import com.dvoinenko.userstore.dao.jdbc.JdbcUserDao;
import com.dvoinenko.userstore.entity.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private JdbcUserDao userDao;

    public void setJdbcUserDao(JdbcUserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getAll() throws SQLException {
        return userDao.getAll();
    }

}
