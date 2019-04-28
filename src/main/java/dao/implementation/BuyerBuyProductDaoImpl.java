/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.implementation;

import dao.interfaces.BuyerBuyProductDao;
import entity.BuyerBuyProduct;
import entity.BuyerBuyProductId;

/**
 *
 * @author Islam El-Rougy
 */
public class BuyerBuyProductDaoImpl extends GeneralDaoImpl implements BuyerBuyProductDao
{

    @Override
    public void deleteById(BuyerBuyProductId buyerBuyProductId)
    {
       String deletionQuery = "delete from buyer_buy_product where buyer_id = ? and product_id = ?";
       Object[] deletionQueryParameters = new Object[]{buyerBuyProductId.getBuyerId(), buyerBuyProductId.getProductId()};
       jdbcTemplate.update(deletionQuery, deletionQueryParameters);
    }

    @Override
    public void deleteByObject(BuyerBuyProduct buyerBuyProduct)
    {
       String deletionQuery = "delete from buyer_buy_product where buyer_id = ? and product_id = ?";
       Object[] deletionQueryParameters = new Object[]{buyerBuyProduct.getBuyerId(), buyerBuyProduct.getProductId()};
       jdbcTemplate.update(deletionQuery, deletionQueryParameters);
    }
          
    @Override
    public BuyerBuyProduct retrieveById(BuyerBuyProductId buyerBuyProductId)
    {
        String retrievalQuery = "select * from buyer_buy_product where buyer_id = ? and product_id = ?";
        BuyerBuyProduct buyerBuyProduct = (BuyerBuyProduct) jdbcTemplate.queryForObject(retrievalQuery, new Object[]{buyerBuyProductId.getBuyerId(), buyerBuyProductId.getProductId()}, tableMap.get("buyer_buy_product"));
        return buyerBuyProduct;
    }
        
    
    
}
