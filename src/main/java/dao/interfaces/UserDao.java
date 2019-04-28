/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaces;

import entity.User;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Islam El-Rougy
 */
public interface UserDao extends GeneralDao<User, Integer> {

    public void update(User user);

    public List<User> retrieveAllByRegistrationDate(Date registrationDate);
}
