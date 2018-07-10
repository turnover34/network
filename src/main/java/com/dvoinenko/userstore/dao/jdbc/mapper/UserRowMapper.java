package com.dvoinenko.userstore.dao.jdbc.mapper;

import com.dvoinenko.userstore.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class UserRowMapper {
    public User mapRow(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setSalary(resultSet.getInt("salary"));
        user.setFirstName(resultSet.getString("firstName"));
        user.setLastName(resultSet.getString("lastName"));
        Timestamp dateOfBirthFromTimestamp = resultSet.getTimestamp("dateOfBirth");
        LocalDateTime dateOfBirth = dateOfBirthFromTimestamp.toLocalDateTime();
        user.setDateOfBirth(dateOfBirth);
        return user;
    }
}
