package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;

public class Main {

    public static void main(String[] args) {

        UserDao userDao = new UserDaoJDBCImpl();

        userDao.createUsersTable();
        userDao.saveUser("name1", "lastName1", (byte) 10);
        userDao.saveUser("name2", "lastName2", (byte) 20);
        userDao.saveUser("name3", "lastName3", (byte) 30);
        userDao.saveUser("name4", "lastName4", (byte) 40);
        userDao.getAllUsers();
        userDao.cleanUsersTable();
        userDao.dropUsersTable();
    }
}
