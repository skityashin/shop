package com.levelup.dao.impl;

import com.levelup.dao.TagDao;
import com.levelup.model.Tag;
import com.levelup.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class {@link com.levelup.dao.impl.TagDaoImpl}
 *
 * @author Skityashin Vladimir
 * @version 1.0
 * @since 16.12.15
 */
public class TagDaoImpl implements TagDao {

    Session session = null;

    @Override
    public void saveTag(Tag tag) throws SQLException {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(tag);
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
    public Tag findById(long id_tag) throws SQLException {
        Tag tag = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tag =  (Tag) session.get(Tag.class, id_tag);
            Hibernate.initialize(tag);
        } catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
        return tag;
    }

    @Override
    public void updateTag(Tag tag) throws SQLException {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(tag);
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
    public void deleteTag(long id_tag) throws SQLException {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(findById(id_tag));
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
    public List<Tag> getAllTag() throws SQLException {
        List<Tag> tag = new ArrayList<Tag>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tag = session.createCriteria(Tag.class).list();
        } catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
        return tag;
    }
}
