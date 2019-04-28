/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.implementation;

import dao.interfaces.BuyerDao;
import entity.Buyer;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

/**
 *
 * @author Islam El-Rougy
 */
public class BuyerDaoImpl extends GeneralDaoImpl implements BuyerDao
{
    public void setDataSource(DataSource dataSource)
    {
        jdbcTemplate = new JdbcTemplate(dataSource);
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("buyer")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public void update(Buyer buyer)
    {
        String updateQuery = "update buyer set value = ? where id = ?";
        Object[] updateQueryParameters = new Object[]{buyer.getValue(), buyer.getId()};
        jdbcTemplate.update(updateQuery, updateQueryParameters);
    }

    @Override
    public void deleteByObject(Buyer buyer)
    {
        String deletionQuery = "delete from buyer where id = ?";
        Object[] deletionQueryParameters = new Object[]{buyer.getId()};
        jdbcTemplate.update(deletionQuery, deletionQueryParameters);
    }

    @Override
    public Buyer retrieveBuyerByUserId(int buyerId)
    {
        RowMapper rowMapper = tableMap.get("buyer");
        String retrievalQuery = "select * from buyer where user_id = ?";
        Buyer buyer = (Buyer) jdbcTemplate.queryForObject(retrievalQuery, new Object[]{buyerId}, rowMapper);
        return buyer;
    }
    
    
    
}
