
package facade;

import entities.Address;
import entities.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;


public class AddressFacade {
 
    
   private static EntityManagerFactory emf;
    private static AddressFacade instance;
 
 
      public static AddressFacade getAddressFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new AddressFacade();
        }
        return instance;
      }
        public AddressFacade() {}
        
        
      
        public Address getAddress(int id){
           
           EntityManager em = emf.createEntityManager();
           try{
           Address address = em.find(Address.class, id);
           return address;
           }finally{
               em.close();
           }  
       }
    
        
      public Address addAddress(Address address){
          
       EntityManager em = emf.createEntityManager();
 
       try{
       em.getTransaction().begin();
       em.persist(address);
       em.getTransaction().commit();
           return address;
       }finally{
          em.close();
       }
      }  
        
      
     public Address deleteAddress(int id){
         
        EntityManager em = emf.createEntityManager();
        
          try{
       em.getTransaction().begin();
       Address adress = em.find(Address.class, id);
       em.remove(adress);
       em.getTransaction().commit();
           return adress;
       }finally{
          em.close();
       }
         
         
      }
      
      
     public Address editAddress(Address address){
         
         EntityManager em = emf.createEntityManager();
         
         
          try{

           em.getTransaction().begin();
           
           Address find = em.find(Address.class, address.getId());
           find.setCity(address.getCity());
           find.setStreet(address.getStreet());
        
           em.getTransaction().commit();
              
           return address;
       }finally{
          em.close();
       }
         
         
     }
     
     
     public List<Address> getAddresses(){
         
          EntityManager em = emf.createEntityManager();
       
       try{
           
        TypedQuery<Address> query = em.createQuery("select e from Address e",Address.class);
        return query.getResultList();
           
       }finally{
           em.close();
           
       }
         
         
     }
     
     
    
    
    
}
