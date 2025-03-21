package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    Util util = new Util();

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String query = "CREATE TABLE `kata_task1`.`users` (\n" +
                "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `name` VARCHAR(45) NOT NULL,\n" +
                "  `lastName` VARCHAR(45) NOT NULL,\n" +
                "  `age` INT NOT NULL,\n" +
                "  PRIMARY KEY (`id`));";
        try {
            Statement statement = util.getConnection().createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            System.out.println("Ошибка при создании таблицы SQLException: " + e.getMessage());
        }
    }

    public void dropUsersTable() {
        String query = "DROP TABLE `kata_task1`.`users`;";
        try {
            Statement statement = util.getConnection().createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Ошибка при удалении таблицы SQLException: " + e.getMessage());
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String query = "insert into `kata_task1`.`users`(id, name, lastName, age) values(?,?,?,?);";
        Long id = 0L;
        try {
            PreparedStatement preparedStatement = util.getConnection().prepareStatement(query);
            preparedStatement.setLong(1, id++);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, lastName);
            preparedStatement.setInt(4, age);
            preparedStatement.executeUpdate();
            System.out.println("User с именем - " + name + " " + lastName + " добавлен в БД");

        } catch (SQLException e) {
            System.out.println("Ошибка при добавлении записи SQLException: " + e.getMessage());
        }
    }

    public void removeUserById(long id) {
        String query = "delete from `kata_task1`.`users` where id = " + id;
        try {
            Statement statement = util.getConnection().createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Ошибка при удалении записи SQLException: " + e.getMessage());
        }
    }

    public List<User> getAllUsers() {
        String query = "select * from `kata_task1`.`users`;";
        List<User> usersList = new ArrayList<>(); ;
        try {
            Statement statement = util.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
                usersList.add(user);
            }
            return usersList;

        } catch (SQLException e) {
            System.out.println("Ошибка при получении всех записей SQLException: " + e.getMessage());
        }
        return null;
    }

    public void cleanUsersTable() {
        String query = "delete from `kata_task1`.`users`;";
        try {
            Statement statement = util.getConnection().createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Ошибка при удалении всех записей SQLException: " + e.getMessage());
        }
    }
}
