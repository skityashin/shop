package com.levelup.dao.impl;

import com.levelup.dao.ProductDao;
import com.levelup.model.Product;
import com.levelup.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class {@link com.levelup.dao.impl.ProductDaoImpl}
 *
 * @author Skityashin Vladimir
 * @version 1.0
 * @since 16.12.15
 */

public class ProductDaoImpl implements ProductDao {

    Session session = null;

    @Override
    public void saveProduct(Product product) throws SQLException {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(product);
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
    public Product findById(long id_prod) throws SQLException {
        Product product = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            product =  (Product) session.get(Product.class, id_prod);
            Hibernate.initialize(product);
        } catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
        return product;
    }

    @Override
    public void updateProduct(Product product) throws SQLException {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(product);
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
    public void deleteProduct(long id_prod) throws SQLException {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(findById(id_prod));
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
    public List<Product> getAllProduct() throws SQLException {
        List<Product> products = new ArrayList<Product>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            products = session.createCriteria(Product.class).list();
        } catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
        return products;
    }
}
