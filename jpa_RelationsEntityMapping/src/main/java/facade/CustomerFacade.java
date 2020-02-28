
package facade;

import entities.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


public class CustomerFacade {


// EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

    private static EntityManagerFactory emf;
    private static CustomerFacade instance;
 
 
      public static CustomerFacade getCustomerFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CustomerFacade();
        }
        return instance;
      }
        public CustomerFacade() {}
        
        
      
        public Customer getCustomer(int id){
           
           EntityManager em = emf.createEntityManager();
           try{
           Customer customer = em.find(Customer.class, id);
           return customer;
           }finally{
               em.close();
           }  
       }
    
        
      public Customer addCustomer(Customer cust){
          
       EntityManager em = emf.createEntityManager();
 
       try{
       em.getTransaction().begin();
       em.persist(cust);
       em.getTransaction().commit();
           return cust;
       }finally{
          em.close();
       }
      }  
        
      
     public Customer deleteCustomer(int id){
         
        EntityManager em = emf.createEntityManager();
        
       try{
       em.getTransaction().begin();
       Customer cust = em.find(Customer.class, id);
       em.remove(cust);
       em.getTransaction().commit();
           return cust;
       }finally{
          em.close();
       }
         
         
      }
      
      
     public Customer editCustomer(Customer cust){
         
         EntityManager em = emf.createEntityManager();
         
          try{

           em.getTransaction().begin();
           
           Customer find = em.find(Customer.class, cust.getId());
           find.setFirstName(cust.getFirstName());
           find.setLastName(cust.getLastName());
           
           em.getTransaction().commit();
              
           return cust;
       }finally{
          em.close();
       }
         
         
     }
     
     
     public List<Customer> getCustomers(){
         
          EntityManager em = emf.createEntityManager();
       
       try{
           
        TypedQuery<Customer> query = em.createQuery("select c from Customer c",Customer.class);
        return query.getResultList();
           
       }finally{
           em.close();
           
       }
         
         
     }
     
     
     
     
        
 
}
