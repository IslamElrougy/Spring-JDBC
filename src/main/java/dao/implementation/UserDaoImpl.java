/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.implementation;

import dao.interfaces.UserDao;
import entity.User;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import rowmappers.UserRowMapper;

/**
 *
 * @author Islam El-Rougy
 */
public class UserDaoImpl extends GeneralDaoImpl implements UserDao
{
    
    public void setDataSource(DataSource dataSource)
    {
        jdbcTemplate = new JdbcTemplate(dataSource);
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("user")
                .usingGeneratedKeyColumns("id");
    }        
    
    @Override
    public void update(User user)
    {
        String updateQuery = "update user set email = ?, address = ?, phone = ?, mobile = ?, date_of_birth = ?, registration_date = ?, user_name = ?, password = ?, full_name = ? where id = ?";
        Object[] updateQueryParameters = new Object[]{user.getEmail(), user.getAddress(), user.getPhone(), user.getMobile(), user.getDateOfBirth(), user.getRegistrationDate(), user.getUserName(),user.getPassword(), user.getFullName(), user.getId()};
        jdbcTemplate.update(updateQuery, updateQueryParameters);    
    }        
    
    @Override
    public void deleteByObject(User user)
    {
        String deletionQuery = "delete from user where id = ?";
        Object[] deletionQueryParameters = new Object[]{user.getId()};
        jdbcTemplate.update(deletionQuery, deletionQueryParameters);
    }
    
    @Override
    public List<User> retrieveAllByRegistrationDate(Date registrationDate)
    {
        String retrievalQuery = "select * from user where registration_date = ?";
        Object[] retrievalQueryParameters = new Object[]{registrationDate};
        List<User> users = jdbcTemplate.query(retrievalQuery, retrievalQueryParameters, new UserRowMapper());
        return users;
    }        
}
