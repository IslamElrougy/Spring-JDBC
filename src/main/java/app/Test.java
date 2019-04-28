/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import dao.implementation.BuyerDaoImpl;
import dao.implementation.ProductDaoImpl;
import dao.implementation.UserDaoImpl;
import dao.interfaces.BuyerDao;
import dao.interfaces.ProductDao;
import dao.interfaces.UserDao;
import entity.Buyer;
import entity.Product;
import entity.User;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Islam El-Rougy
 */
public class Test
{

    public static void main(String[] args)
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        
        //User Methods Testing
        UserDao userDao = context.getBean("userDao", UserDaoImpl.class);
        /*System.out.println(userDao.countAll("user"));
        User retrievedUser = userDao.retrievebyId(2, "user");
        System.out.println(retrievedUser);
        System.out.println(userDao.retrieveAll("user"));*/
        /*User user = new User("mustafa@gmail.com", "38 Hm NS", "23498196", "01060805824",new Date(), new Date(), "Islam El-Rougy", "THOK_AFC2018", "Islam Muhammad Mustafa Hassan", null, null);
        userDao.insert(user);*/
        /*retrievedUser.setEmail("melshehat1957@yahoo.com");
        userDao.update(retrievedUser);
        userDao.deleteById(14);
        User retrievedUser = userDao.retrievebyId(13);
        userDao.deleteByObject(retrievedUser);*/
        /*Date registrationDate = Date
                .from(
                        LocalDate
                                .of(2019, 3, 5)
                                .atStartOfDay(
                                        ZoneId.of("Africa/Cairo")
                                )
                                .toInstant()
                );
        List<User> users = userDao.retrieveAllByRegistrationDate(registrationDate);
        System.out.println(users);
        userDao.deleteById(15, "user");
        Date registrationDate = Date
                .from(
                        LocalDate
                                .of(2019, 3, 5)
                                .atStartOfDay(
                                        ZoneId.of("Africa/Cairo")
                                )
                                .toInstant()
                );
        List<User> users = userDao.retrieveAllBySingleProperty("user", "registration_date", registrationDate);
        System.out.println(users);*/
        //Buyer Methods Testing
        BuyerDao buyerDao = context.getBean("buyerDao", BuyerDaoImpl.class);
        /*System.out.println(buyerDao.countAll("buyer"));
        Buyer buyer = buyerDao.retrievebyId(8, "buyer");
        System.out.println(buyer);
        List<Buyer> buyers = buyerDao.retrieveAll("buyer");
        System.out.println(buyers);
        Buyer buyer = new Buyer("5000", 6);
        buyerDao.insert(buyer);
        buyerDao.deleteById(9, "buyer");
        Buyer updatedBuyer = buyerDao.retrievebyId(8, "buyer");
        updatedBuyer.setValue("3000");
        buyerDao.update(updatedBuyer);
        Buyer deletedBuyer = buyerDao.retrievebyId(10, "buyer");
        buyerDao.deleteByObject(deletedBuyer);
        System.out.println(buyerDao.retrieveBuyerByUserId(11));*/
        
        //Product Methods Testing
        ProductDao productDao = context.getBean("productDao", ProductDaoImpl.class);
        /*System.out.println(productDao.countAll("product"));
        Product retrievedProduct = productDao.retrievebyId(1, "product");
        System.out.println(retrievedProduct);
        List<Product> products = productDao.retrieveAll("product");
        System.out.println(products);
        Product product = new Product(1, "Playstation", "Playstation", "Playstation", new Date(), new Date(), 10, new Date(), new Date());
        productDao.insert(product);
        Product retrievedProduct = productDao.retrievebyId(10, "product");
        retrievedProduct.setDescription("Sony's celebrated games console.");
        productDao.update(retrievedProduct);
        Date manufacturingDate = Date
                .from(
                        LocalDate
                                .of(2019, 3, 5)
                                .atStartOfDay(
                                        ZoneId.of("Africa/Cairo")
                                )
                                .toInstant()
                );
        List<Product> products = productDao.retrieveProductsByManufacturingDate(manufacturingDate);
        System.out.println(products);
        Product retrievedProduct = productDao.retrievebyId(10, "product");
        productDao.deleteProductByObject(retrievedProduct);*/
        
        //buyer_buy_product Methods Testing
        
    }
}
