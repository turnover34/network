package com.dvoinenko.userstore;

import com.dvoinenko.userstore.dao.jdbc.JdbcUserDao;
import com.dvoinenko.userstore.service.UserService;
import com.dvoinenko.userstore.web.servlet.UsersServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Starter {
    public static void main(String[] args) throws Exception {
        JdbcUserDao jdbcUserDao = new JdbcUserDao();


        UserService userService = new UserService();
        userService.setJdbcUserDao(jdbcUserDao);


        UsersServlet usersServlet = new UsersServlet();
        usersServlet.setUserService(userService);


        ServletHolder allUsersHolder = new ServletHolder(usersServlet);

        ServletContextHandler handler = new ServletContextHandler();
        handler.addServlet(allUsersHolder, "/users");


        Server server = new Server(8080);
        server.setHandler(handler);
        server.start();
        server.join();
    }
}
