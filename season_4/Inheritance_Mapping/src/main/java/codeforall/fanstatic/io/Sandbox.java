package codeforall.fanstatic.io;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Sandbox {
    public static void main(String[] args) {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        EntityManager em = emf.createEntityManager();

        Customer customer1 = new Customer();
        Account account1 = new Account();
        Customer customer2 = new Customer();
        Account account2 = new Account();
        Customer customer3 = new Customer();
        Account account3 = new Account();


        customer1.setName("Jose");
        account1.setBalance(34.00);

        customer2.setName("Maria");
        account2.setBalance(134.00);

        customer3.setName("Diogo");
        account3.setBalance(600.10);

        em.getTransaction().begin();

        em.persist(customer1);
        em.persist(account1);
        em.persist(customer2);
        em.persist(account2);
        em.persist(customer3);
        em.persist(account3);


        em.getTransaction().commit();
        em.close();

        emf.close();



    }
}
