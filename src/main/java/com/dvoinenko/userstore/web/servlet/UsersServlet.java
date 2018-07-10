package com.dvoinenko.userstore.web.servlet;

import com.dvoinenko.userstore.entity.User;
import com.dvoinenko.userstore.service.UserService;
import com.dvoinenko.userstore.web.templater.PageGenerator;
import freemarker.template.TemplateException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsersServlet extends HttpServlet {
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, Object> paramMap= new HashMap<>();

        List<User> userList = null;
        try {
            userList = userService.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        paramMap.put("users", userList);
        PageGenerator pageGenerator = PageGenerator.instance();
        String page = null;
        try {
            page = pageGenerator.getPage("users.ftl", paramMap);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        response.getWriter().write(page);

    }
}
