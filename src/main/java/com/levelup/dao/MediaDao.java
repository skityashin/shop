package com.levelup.dao;

import com.levelup.model.Media;
import java.sql.SQLException;
import java.util.List;

/**
 * Class {@link com.levelup.dao.UserDao}
 *
 * @author Skityashin Vladimir
 * @version 1.0
 * @since 16.12.15
 */

public interface MediaDao {

    public void saveMedia (Media media) throws SQLException;
    public Media findById (long id_media) throws SQLException;
    public void updateMedia (Media media) throws SQLException;
    public void deleteMedia (long id_media) throws SQLException;
    public List<Media> getAllMedia () throws SQLException;

}

