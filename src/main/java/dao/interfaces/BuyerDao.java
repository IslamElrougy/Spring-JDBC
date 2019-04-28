/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaces;

import entity.Buyer;

/**
 *
 * @author Islam El-Rougy
 */
public interface BuyerDao extends GeneralDao
{
    public void update(Buyer buyer);
    public void deleteByObject(Buyer buyer);
    public Buyer retrieveBuyerByUserId(int userId);
}
