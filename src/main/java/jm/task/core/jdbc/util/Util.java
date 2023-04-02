package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
   // private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "root";
    public static Connection getConnection() {
        Connection connection = null;
        try {
           // Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            connection.setAutoCommit(false);
            System.out.println("Connections ok");

        } catch ( SQLException e) {
            e.printStackTrace();
            System.out.println("Connections error");
        }
        return connection;


    }
     public static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().addAnnotatedClass(User.class);
                configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/mydbtest");
        configuration.setProperty("hibernate.connection.username", "root");
        configuration.setProperty("hibernate.connection.password", "root");
        configuration.setProperty("hibernate.current_session_context_class", "thread");
        SessionFactory  sessionFactory = configuration.buildSessionFactory();
        return sessionFactory;

    }

}
