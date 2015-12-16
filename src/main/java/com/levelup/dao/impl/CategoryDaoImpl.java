package com.levelup.dao.impl;

import com.levelup.dao.CategoryDao;
import com.levelup.model.Category;
import com.levelup.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class {@link com.levelup.dao.UserDao}
 *
 * @author Skityashin Vladimir
 * @version 1.0
 * @since 16.12.15
 */

public class CategoryDaoImpl implements CategoryDao {

    Session session = null;

    @Override
    public void saveCategory(Category category) throws SQLException {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(category);
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
    public Category findById(long id_category) throws SQLException {
        Category category = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            category =  (Category) session.get(Category.class, id_category);
            Hibernate.initialize(category);
        } catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
        return category;
    }

    @Override
    public void updateCategory(Category category) throws SQLException {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(category);
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
    public void deleteCategory(long id_category) throws SQLException {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(findById(id_category));
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
    public List<Category> getAllCategory() throws SQLException {
        List<Category> categories = new ArrayList<Category>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            categories = session.createCriteria(Category.class).list();
        } catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
        return categories;
    }
}
