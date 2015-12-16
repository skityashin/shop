package com.levelup.dao;

import com.levelup.dao.impl.*;

/**
 * Class {@link com.levelup.dao.Factory}
 *
 * @author Skityashin Vladimir
 * @version 1.0
 * @since 09.12.15
 */
public class Factory {
    private static Factory instance = null;
    private static UserDao userDao = null;
    private static ProductDao productDao = null;
    private static CategoryDao categoryDao = null;
    private static MediaDao mediaDao = null;
    private static TagDao tagDao = null;



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

    public ProductDao getProductDao(){
        if (productDao == null){
            productDao = new ProductDaoImpl();
        }
        return productDao;
    }

    public CategoryDao getCategoryDao(){
        if (categoryDao == null){
            categoryDao = new CategoryDaoImpl();
        }
        return categoryDao;
    }

    public MediaDao getMediaDao(){
        if (mediaDao == null){
            mediaDao = new MediaDaoImpl();
        }
        return mediaDao;
    }

    public TagDao getTagDao(){
        if (tagDao == null){
            tagDao = new TagDaoImpl();
        }
        return tagDao;
    }
}
