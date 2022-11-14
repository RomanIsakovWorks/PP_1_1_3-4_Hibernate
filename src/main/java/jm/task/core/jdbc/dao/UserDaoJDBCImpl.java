package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        Connection connection = Util.getConnection();
        try (Statement statement = connection.createStatement();) {
            statement.execute("CREATE TABLE IF NOT EXISTS Users_table (\n" +
                    " id INT NOT NULL AUTO_INCREMENT,\n" +
                    " name VARCHAR(45) NOT NULL,\n" +
                    " lastName VARCHAR(45),\n" +
                    " age INT NOT NULL,\n" +
                    " PRIMARY KEY (`id`));");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void dropUsersTable() {
        Connection connection = Util.getConnection();
        try (Statement statement = connection.createStatement();) {
            statement.execute("DROP TABLE IF EXISTS Users_table;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        Connection connection = Util.getConnection();
        try (Statement statement = connection.createStatement();) {
            statement.execute("INSERT INTO Users_table (name, lastName, age) values ('" + name + "', '" + lastName + "', '" + age + "');");
            System.out.println("User с именем – " + name + " добавлен в базу данных");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        public void removeUserById(long id) {
            Connection connection = Util.getConnection();
            try (Statement statement = connection.createStatement()) {
                statement.execute("DELETE FROM Users_table WHERE Id = " + id + ";");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public List<User> getAllUsers() {
            List<User> users = new ArrayList<>();
            Connection connection = Util.getConnection();
            try (Statement statement = connection.createStatement();) {
                ResultSet resultSet = statement.executeQuery("select * from Users_table");
                while(resultSet.next()) {
                    User user = new User();
                    user.setId((long) resultSet.getInt("id"));
                    user.setName(resultSet.getString("name"));
                    user.setLastName(resultSet.getString("lastName"));
                    user.setAge((byte) resultSet.getInt("age"));
                    System.out.println(user);
                    users.add(user);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return users;
    }

    public void cleanUsersTable() {
        Connection connection = Util.getConnection();
        try (Statement statement = connection.createStatement();) {
            statement.execute("TRUNCATE TABLE `Users_table`;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
