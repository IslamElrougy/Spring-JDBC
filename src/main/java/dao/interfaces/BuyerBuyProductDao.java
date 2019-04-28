/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaces;

import entity.BuyerBuyProduct;
import entity.BuyerBuyProductId;

/**
 *
 * @author Islam El-Rougy
 */
public interface BuyerBuyProductDao extends GeneralDao
{
    public void deleteById(BuyerBuyProductId buyerBuyProductId);
    public void deleteByObject(BuyerBuyProduct buyerBuyProduct);
    public BuyerBuyProduct retrieveById(BuyerBuyProductId buyerBuyProductId);
}
