/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rowmappers;

import entity.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Islam El-Rougy
 */
public class UserRowMapper implements RowMapper
{

    @Override
    public Object mapRow(ResultSet resultSet, int rowNumber) throws SQLException
    {
        User user = new User();
        user.setId(resultSet.getInt(1));
        user.setEmail(resultSet.getString(2));
        user.setAddress(resultSet.getString(3));
        user.setPhone(resultSet.getString(4));
        user.setMobile(resultSet.getString(5));
        user.setDateOfBirth(resultSet.getDate(6));
        user.setRegistrationDate(resultSet.getDate(7));
        user.setUserName(resultSet.getString(8));
        user.setPassword(resultSet.getString(9));
        user.setFullName(resultSet.getString(10));
        return user;
    }
    
}
