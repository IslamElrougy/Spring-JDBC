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

/**
 *
 * @author Islam El-Rougy
 */
public class UserDaoImpl extends GeneralDaoImpl<User, Integer> implements UserDao {

    @Override
    public void update(User user) {
        Object[] updateQueryParameters = new Object[]{user.getEmail(),
            user.getAddress(), user.getPhone(), user.getMobile(),
            user.getDateOfBirth(), user.getRegistrationDate(),
            user.getUserName(), user.getPassword(), user.getFullName(), user.getId()};
        String updateQuery = "update user set email = ?, address = ?, phone = ?, "
                + "mobile = ?, date_of_birth = ?, registration_date = ?, user_name = ?, "
                + "password = ?, full_name = ? where id = ?";
        super.update(updateQuery, updateQueryParameters);
    }

    @Override
    public List<User> retrieveAllByRegistrationDate(Date registrationDate) {
        return super.retrieveAllBySingleProperty("registration_date", registrationDate);
    }
}
