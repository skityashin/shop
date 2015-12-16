package com.levelup.dao;

import com.levelup.model.Tag;
import java.sql.SQLException;
import java.util.List;

/**
 * Class {@link com.levelup.dao.TagDao}
 *
 * @author Skityashin Vladimir
 * @version 1.0
 * @since 16.12.15
 */

public interface TagDao {

    public void saveTag (Tag tag) throws SQLException;
    public Tag findById (long id_tag) throws SQLException;
    public void updateTag (Tag tag) throws SQLException;
    public void deleteTag (long id_tag) throws SQLException;
    public List<Tag> getAllTag () throws SQLException;
}
