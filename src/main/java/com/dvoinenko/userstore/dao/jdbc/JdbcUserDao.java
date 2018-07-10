package com.dvoinenko.userstore.dao.jdbc;

import com.dvoinenko.userstore.dao.jdbc.mapper.UserRowMapper;
import com.dvoinenko.userstore.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcUserDao {
    private static final String GET_ALL_SQL = "SELECT id, salary, firstName, lastName, dateOfBirth FROM user_ivan;";
    /*private static final String PUT_USER = "INSERT INTO user_ivan (salary, firstName, lastName, dateOfBirth)";*/

    public List<User> getAll() throws SQLException {
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_ALL_SQL);
            UserRowMapper userRowMapper = new UserRowMapper();

            while (resultSet.next()) {
                User user = userRowMapper.mapRow(resultSet);
                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

/*    public void addUser(User user) throws SQLException {
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(PUT_USER + "VALUES (" + user + ")");
        }
    }*/

    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://danit.cukm9c6zpjo8.us-west-2.rds.amazonaws.com/fs3";
        String user = "fs3_user";
        String password = "bostoN";
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }
}
