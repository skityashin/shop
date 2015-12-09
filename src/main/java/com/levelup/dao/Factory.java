package com.levelup.dao;

import com.levelup.dao.impl.UserDaoImpl;

/**
 * Class {@link com.levelup.dao.Factory}
 *
 * @author Skityashin Vladimir
 * @version 1.0
 * @since 09.12.15
 */
public class Factory {
    private static UserDao userDao = null;
    private static Factory instance = null;

    public static synchronized Factory getInstance(){
        if (instance == null){
            instance = new Factory();
        }
        return instance;
    }
    public UserDao getUserDao(){
        if (userDao == null){
            userDao = new UserDaoImpl();
        }
        return userDao;
    }
}
