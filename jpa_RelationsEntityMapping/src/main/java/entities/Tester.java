package entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author cahit
 */
public class Tester {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

    public static void main(String[] args) {

     EntityManager em = emf.createEntityManager();

   em.getTransaction().begin();
       
//        Address a4 = new Address("GrenaaGården","Grenaa");
//        Address a5 = new Address("ÅrhusGården","Århus");
//        Address a6 = new Address("HorsensGården","Horsens");
//        Address a7 = new Address("AalborgGården","Aalborg");
//        Address a8 = new Address("SilkeborgGården","Silkeborg");
//
//        Customer c1 = new Customer("Bent", "Bentsen");
//        Customer c2 = new Customer("Lars", "Larsen");
//        Customer c3 = new Customer("Hans", "Hansen");
//
//      c1.addAddress(a4);
//      c1.addAddress(a6);
//      c2.addAddress(a5);
//      c3.addAddress(a8);
//      
//    
//   
//       
//
//        em.persist(c1);
//        em.persist(c2);
//        em.persist(c3);
      

        Customer c1 = new Customer("Bent", "Bentsen");
        Customer c2 = new Customer("Lars", "Larsen");
        Customer c3 = new Customer("Hans", "Hansen");
        
        Address a1 = new Address("GrenaaGården","Grenaa");
        Address a2 = new Address("ÅrhusGården","Århus");
        Address a3 = new Address("HorsensGården","Horsens");
        Address a4 = new Address("AalborgGården","Aalborg");
        
      c1.addAddress(a1);
      c1.addAddress(a2);
      c2.addAddress(a3);
      c3.addAddress(a4);
        
//      a1.addCustomer(c1);
//      a1.addCustomer(c2);
//      a2.addCustomer(c3);


//      em.persist(c1);
//      em.persist(c2);
    
      em.persist(a1);
      em.persist(a2);
      em.persist(a3);
      em.persist(a4);
      em.persist(c1);
      em.persist(c2);
      em.persist(c3);
  

      em.getTransaction().commit();

    
    
    
    
    }

}
