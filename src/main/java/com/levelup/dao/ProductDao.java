package com.levelup.dao;



import com.levelup.model.Product;
import java.sql.SQLException;
import java.util.List;

/**
 * Class {@link com.levelup.dao.UserDao}
 *
 * @author Skityashin Vladimir
 * @version 1.0
 * @since 16.12.15
 */

public interface ProductDao {

    public void saveProduct (Product product) throws SQLException;
    public Product findById (long id_prod) throws SQLException;
    public void updateProduct (Product product) throws SQLException;
    public void deleteProduct (long id_prod) throws SQLException;
    public List<Product> getAllProduct () throws SQLException;

}

