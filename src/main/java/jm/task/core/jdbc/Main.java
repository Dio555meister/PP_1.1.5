package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();// переделать на обращение к юзер сервис
        userService.createUsersTable();
        userService.saveUser("Nail", "Alishev", (byte) 30);
        userService.saveUser("Zaur", "Tregulov", (byte) 32);
        userService.saveUser("Alexey", "Vladykin", (byte) 40);
        userService.saveUser("Oleg", "Surnychev", (byte) 34);

        System.out.println(userService.getAllUsers().toString());
        userService.createUsersTable();
        userService.dropUsersTable();


        // реализуйте алгоритм здесь
    }
}
