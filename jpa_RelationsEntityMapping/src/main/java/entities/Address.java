
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;



/**
 *
 * @author cahit
 */
@Entity
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String city;
//    @ManyToOne
//    private Customer customer;
    @ManyToMany(mappedBy = "addresses")
    private List<Customer> customers;
  
  


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Address() {
    }

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

    
     public void addCustomer(Customer customer){
         customers.add(customer);

    }
    
    
    public List<Customer> getCustomers(){
        return customers;
    } 
     
     
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
}
