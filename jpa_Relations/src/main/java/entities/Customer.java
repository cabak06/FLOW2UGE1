/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;

/**
 *
 * @author cahit
 */
@Entity
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customer_id;
    private String firstName;
    private String lastName;
  
    
    
@ElementCollection(fetch = FetchType.LAZY)
@MapKeyColumn(name = "PHONE")
@Column(name="Description")
public Map<String,String> phones = new HashMap();
    
    public void addPhone (String phoneNo, String description){
    phones.put(phoneNo, description);
        
        
    }
    
    public String getPhoneDescription(String phoneNo){
    String v = phones.get(phoneNo);
        return v;
   }
 
    
    
    
    
    
    @ElementCollection
    @CollectionTable(
    name = "hobby",
    joinColumns=@JoinColumn(name="customer_id")        )
    private List<String> hobbies = new ArrayList();

    
    
    public Customer() {
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    
   public  void addHobby(String s){
   hobbies.add(s);
   }
    
   public String getHobbies(){
       return String.join(",", hobbies);
   }
   

    public Long getId() {
        return customer_id;
    }

    public void setId(Long id) {
        this.customer_id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customer_id != null ? customer_id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.customer_id == null && other.customer_id != null) || (this.customer_id != null && !this.customer_id.equals(other.customer_id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Customer[ id=" + customer_id + " ]";
    }
    
}
