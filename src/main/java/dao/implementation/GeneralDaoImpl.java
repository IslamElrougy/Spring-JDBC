/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.implementation;

import dao.interfaces.GeneralDao;
import entity.Buyer;
import entity.Product;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import rowmappers.BuyerBuyProductRowMapper;
import rowmappers.UserRowMapper;

/**
 *
 * @author Islam El-Rougy
 */
public abstract class GeneralDaoImpl implements GeneralDao
{
    protected JdbcTemplate jdbcTemplate;
    protected SimpleJdbcInsert simpleJdbcInsert;
    protected static Map<String, RowMapper> tableMap = new HashMap<>();
    
    static
    {
        tableMap.put("user", new UserRowMapper());
        tableMap.put("buyer", new BeanPropertyRowMapper<>(Buyer.class));
        tableMap.put("product", new BeanPropertyRowMapper<>(Product.class));
        tableMap.put("buyer_buy_product", new BuyerBuyProductRowMapper());
    }
    
    
    @Override
    public int countAll(String tableName)
    {
        String countQuery = "select count(*) from " + tableName;
        int rowCount = jdbcTemplate.queryForObject(countQuery, Integer.class);
        return rowCount;
    }

    @Override
    public <T, G> T retrievebyId(G id, String tableName)
    {
        RowMapper rowMapper = tableMap.get(tableName);
        String retrievalQuery = "select * from " + tableName + " where id = ?";
        T retrievedEntity = (T) jdbcTemplate.queryForObject(retrievalQuery, new Object[]{id}, rowMapper);
        return retrievedEntity;
    }

    @Override
    public <T> List<T> retrieveAll(String tableName)
    {
        RowMapper rowMapper = tableMap.get(tableName);
        String retrievalQuery = "select * from " + tableName;
        List<T> retrievedList = jdbcTemplate.query(retrievalQuery, rowMapper);
        return retrievedList;
    }

    @Override
    public <T> void insert(T entity)
    {
        SqlParameterSource parameters = new BeanPropertySqlParameterSource(entity);
        simpleJdbcInsert.execute(parameters);
    }

    @Override
    public <T> void deleteById(T userId, String tableName)
    {
       String deletionQuery = "delete from " + tableName + " where id = ?";
       Object[] deletionQueryParameters = new Object[]{userId};
       jdbcTemplate.update(deletionQuery, deletionQueryParameters);
    }

    @Override
    public <T, G> List<T> retrieveAllBySingleProperty(String tableName, String columnName, G retrievalProperty)
    {
        RowMapper rowMapper = tableMap.get(tableName);
        String retrievalQuery = "select * from " + tableName + " where " + columnName + " = ?";
        Object[] retrievalQueryParameters = new Object[]{retrievalProperty};
        List<T> retrievedList = jdbcTemplate.query(retrievalQuery, retrievalQueryParameters, rowMapper);
        return retrievedList;
    }

    @Override
    public <T, G> T retrieveByUniqueKey(String tableName, String columnName, G retrievalProperty)
    {
        RowMapper rowMapper = tableMap.get(tableName);
        String retrievalQuery = "select * from " + tableName + " where " + columnName + " = ?";
        T retrievedEntity = (T) jdbcTemplate.queryForObject(retrievalQuery, new Object[]{retrievalProperty}, rowMapper);
        return retrievedEntity;
    }

    
    
    
    
}
