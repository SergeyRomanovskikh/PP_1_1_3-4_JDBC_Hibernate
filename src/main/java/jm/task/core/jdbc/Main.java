package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.dropUsersTable();
        userService.createUsersTable();
        userService.saveUser("Dima", "Kekovich", (byte) 28);
        userService.saveUser("Sergo", "Lolovich", (byte) 26);
        userService.saveUser("Pacha", "Pucovich", (byte) 27);
        userService.saveUser("Yan", "Pidorovich", (byte) 27);
        System.out.println(userService.getAllUsers());
        userService.removeUserById(1);
        userService.cleanUsersTable();
        userService.dropUsersTable();



    }
}
