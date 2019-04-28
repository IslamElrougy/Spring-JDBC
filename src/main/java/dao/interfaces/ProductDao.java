/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaces;

import entity.Product;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Islam El-Rougy
 */
public interface ProductDao extends GeneralDao
{
    public void update(Product product);
    public List<Product> retrieveProductsByManufacturingDate(Date manufacturingDate);
    public void deleteProductByObject(Product product);
}
