package com.levelup.dao;

import com.levelup.model.Category;
import java.sql.SQLException;
import java.util.List;

/**
 * Class {@link com.levelup.dao.UserDao}
 *
 * @author Skityashin Vladimir
 * @version 1.0
 * @since 16.12.15
 */

public interface CategoryDao {

    public void saveCategory (Category category) throws SQLException;
    public Category findById (long id_category) throws SQLException;
    public void updateCategory (Category category) throws SQLException;
    public void deleteCategory (long id_category) throws SQLException;
    public List<Category> getAllCategory () throws SQLException;

}
