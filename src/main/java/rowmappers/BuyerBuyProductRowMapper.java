/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rowmappers;

import entity.BuyerBuyProduct;
import entity.BuyerBuyProductId;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Islam El-Rougy
 */
public class BuyerBuyProductRowMapper implements RowMapper
{

    @Override
    public Object mapRow(ResultSet resultSet, int rowNumber) throws SQLException
    {
        BuyerBuyProduct buyerBuyProduct = new BuyerBuyProduct();
        buyerBuyProduct.setBuyerId(resultSet.getInt(1));
        buyerBuyProduct.setProductId(resultSet.getInt(2));
        buyerBuyProduct.setPaymentDate(resultSet.getDate(3));
        buyerBuyProduct.setAmount(resultSet.getFloat(4));
        buyerBuyProduct.setQuantity(resultSet.getInt(5));
        return buyerBuyProduct;
    }
           
}
