package com.levelup.dao.impl;

import com.levelup.dao.UserDao;
import com.levelup.model.User;
import com.levelup.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class {@link com.levelup.dao.impl.UserDaoImpl}
 *
 * @author Skityashin Vladimir
 * @version 1.0
 * @since 09.12.15
 */
public class UserDaoImpl implements UserDao {

    @Override
    public void saveUser(User user) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
    }

    @Override
    public User findById(long id) throws SQLException {
        Session session = null;
        User user = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            user =  (User) session.get(User.class, id);
            Hibernate.initialize(user);
        } catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
        return user;
    }


    @Override
    public void updateUser(User user) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        } catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
    }

    @Override
    public void deleteUser(long id) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(findById(id));
            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }

    }
    @Override
    public List<User> getAllUsers() throws SQLException {
        Session session = null;
        List<User> users = new ArrayList<User>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            users = session.createCriteria(User.class).list();
        } catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
        return users;
    }
}
