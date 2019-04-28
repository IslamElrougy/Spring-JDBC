package entity;
// Generated Feb 28, 2019 2:46:56 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Seller generated by hbm2java
 */
public class Seller  implements java.io.Serializable {


     private int id;
     private User user;
     private String value;
     private Set products = new HashSet(0);

    public Seller() {
    }

	
    public Seller(User user, String value) {
        this.user = user;
        this.value = value;
    }
    public Seller(User user, String value, Set products) {
       this.user = user;
       this.value = value;
       this.products = products;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    public String getValue() {
        return this.value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }
    public Set getProducts() {
        return this.products;
    }
    
    public void setProducts(Set products) {
        this.products = products;
    }




}

