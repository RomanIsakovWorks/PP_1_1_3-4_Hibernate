package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
    private final UserDao userDabHibernate = new UserDaoHibernateImpl();

    public void createUsersTable() {
        userDabHibernate.createUsersTable();
    }

    public void dropUsersTable() {
        userDabHibernate.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        userDabHibernate.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        userDabHibernate.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return userDabHibernate.getAllUsers();
    }

    public void cleanUsersTable() {
        userDabHibernate.cleanUsersTable();
    }
}
