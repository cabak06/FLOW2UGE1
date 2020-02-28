package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author cahit
 */
@Entity
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;

//    @OneToMany
//    @JoinColumn(name = "Customer_ID")
    
// 
//    @OneToMany(mappedBy = "customer")
  
   @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
   private List<Address> addresses = new ArrayList();

   
    
    
    
    
    
    
    
    
    
    /* ####################COMMENTS/REFLECTIONS ON THE QUESTIONS FOR Exercises JPA Relations####################  
    
    
    
    2) One to One – Uni/Bidirectional:
    
    The expected UML model when operating with OneToOne unidirectional is that it will use
    the Address_id as a foreign key in the Customer class/Table, thereby linking the two tables together.
    As a result, a new field in the Customer table will be generated (ADDRESS_ID);
    
    If you instead operate with oneToOne bidirectional, (without specifying which table is responsible for mapping),
    then the expected UML model will have two extra fields. In the customer table (ADDRESS_ID, which is a foreign key)
    and in the Address table (CUSTOMER_ID, which also is a foreign key). Thereby you have access to both of the Tables via their 
    foreign keys, hence the name bidirectional.
   
    If you on the other hand specify which table is responsible for mapping (i.e  @OneToOne(mappedBy = "address"), then 
    you will only have one extra field generated for the responsible class/table. In this case you specify which class/table that are
    responsibel for mapping the data.
    
     */
     /*
    
   3) OneToMany (unidirectional) How many tables were generated? Explain the purpose of each of the tables.
    
    There are 3 tables generated -> Customer, Address and Customer_Address.
    The Customer table holds data for each customer (ID,Firstname,Lastname)
    The Address table holds data for each address (ID,City,Street)
    
    Because of the fact that a customer can now have several addresses, there need to be a new table which can link
    these data together. The purpose of the new Customer_Address table is to make it possible for a customer with
    a unique ID (primary key) to have several adresses (oneToMany relation). The new table holds the Customer ID and 
    the Address ID.
     */
    
    /*
    
    4) OneToMany (bidirectional)
    
    We find the mapped value in (@OneToMany(mappedBy = "customer"). Here, when the database is created, we find 
    an additional column created in the Address table (" which is responsible for doing the mapping" ) with the foreign key Customer_ID, 
    which indicates which customers (via their ID's) that are associated to their respective adresses.
    The syntax for the code is to have a OneToMany for customer class and a ManyToOne for the Address class.
    
    */
    
    
    /*
    5) Many To Many (bidirectional)
    
    - How can we implement ManyToMany relationships in an OO-language like Java?
    
    -> The way you can implement many to many relationships in OO-language could be by
    creating multiple lists of objects for the different classes. As an example, if you had  a student class 
    and a subject class then you could create two lists, which could hold multiple values and thereby indicating
    a many to many relationship.
    
    
    - How can we implement ManyToMany relationships in a Relational Database?
    
    -> In a database you need to join the foreign keys of the tables, and create new tables, thereby 
    connecting/creating relations with eachother.
    
    */
   
   /*
   5) Many To Many (bidirectional)
   
   There are now three generated tables... Customer , Address and a joined table called CUSTOMER_ADDRESS.
   
   
   */

    public Customer() {
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public void addAddress(Address address){
        addresses.add(address);
    }  
    
    public List<Address> getAddresses(){
         return addresses;
    }
    

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
