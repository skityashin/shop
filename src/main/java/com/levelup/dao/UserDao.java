package com.levelup.dao;

import com.levelup.model.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Class {@link com.levelup.dao.UserDao}
 *
 * @author Skityashin Vladimir
 * @version 1.0
 * @since 09.12.15
 */
public interface UserDao {
    public void saveUser (User user) throws SQLException;
    public User findById (long id) throws SQLException;
    public void updateUser (User user) throws SQLException;
    public void deleteUser (User user) throws SQLException;
    public List<User> getAllUsers () throws SQLException;
}
