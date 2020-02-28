/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

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
        
        Customer c1 = new Customer("jønke","jørgensen");
        Customer c2 = new Customer("jens","jensen");
        
        c1.addPhone("222222", "Slow");
        c2.addPhone("3333333", "Fast");
        
        
        c1.addHobby("løb");
        c1.addHobby("øl");
        c2.addHobby("Folkedans");
        
        em.persist(c1);
        em.persist(c2);
        
       em.getTransaction().commit();
        
    }
    
    
}
