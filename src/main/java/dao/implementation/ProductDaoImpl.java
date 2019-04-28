/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.implementation;

import dao.interfaces.ProductDao;
import entity.Product;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

/**
 *
 * @author Islam El-Rougy
 */
public class ProductDaoImpl extends GeneralDaoImpl implements ProductDao
{
    public void setDataSource(DataSource dataSource)
    {
        jdbcTemplate = new JdbcTemplate(dataSource);
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("product")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public void update(Product product)
    {
        String updateQuery = "update product set name = ?, description = ?, manufacturing_name = ?, manufacturing_date = ?, expiration_date = ?, seller_id = ?, quantity = ?, offered_date = ?, finish_date = ? where id = ?";
        Object[] updateQueryParameters = new Object[]{product.getName(), product.getDescription(), product.getManufacturingName(), product.getManufacturingDate(), product.getExpirationDate(), product.getSellerId(), product.getQuantity(), product.getOfferedDate(), product.getFinishDate(), product.getId()};
        jdbcTemplate.update(updateQuery, updateQueryParameters);
    }
    
    @Override
    public List<Product> retrieveProductsByManufacturingDate(Date manufacturingDate)
    {
        String retrievalQuery = "select * from product where manufacturing_date = ?";
        Object[] retrievalQueryParameters = new Object[]{manufacturingDate};
        List<Product> products = jdbcTemplate.query(retrievalQuery, retrievalQueryParameters, tableMap.get("product"));
        return products;
    }        

    @Override
    public void deleteProductByObject(Product product)
    {
        String deletionQuery = "delete from product where id = ?";
        Object[] deletionQueryParameters = new Object[]{product.getId()};
        jdbcTemplate.update(deletionQuery, deletionQueryParameters);
    }
        
    
    
    
}
