package com.levelup.dao.impl;

import com.levelup.dao.MediaDao;
import com.levelup.model.Media;
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
public class MediaDaoImpl implements MediaDao{

    Session session = null;

    @Override
    public void saveMedia(Media media) throws SQLException {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(media);
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
    public Media findById(long id_media) throws SQLException {
        Media media = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            media =  (Media) session.get(Media.class, id_media);
            Hibernate.initialize(media);
        } catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
        return media;
    }

    @Override
    public void updateMedia(Media media) throws SQLException {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(media);
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
    public void deleteMedia(long id_media) throws SQLException {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(findById(id_media));
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
    public List<Media> getAllMedia() throws SQLException {
        List<Media> medias = new ArrayList<Media>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            medias = session.createCriteria(Media.class).list();
        } catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
        return medias;
    }
}
