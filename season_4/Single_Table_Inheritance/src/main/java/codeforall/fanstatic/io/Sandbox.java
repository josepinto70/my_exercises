package codeforall.fanstatic.io;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Sandbox {
    public static void main(String[] args) {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        EntityManager em = emf.createEntityManager();

        Car car = new Car();
        Boat boat = new Boat();
        Bicycle bicycle = new Bicycle();
        //Account account1 = new Account();
        //Customer customer2 = new Customer();
        //Account account2 = new Account();
        //Customer customer3 = new Customer();
        //Account account3 = new Account();


        car.setGears(5);
        boat.setEngines(50);
        bicycle.setKms(34);
        /*account1.setBalance(34.00);

        customer2.setName("Maria");
        account2.setBalance(134.00);

        customer3.setName("Diogo");
        account3.setBalance(600.10);
*/
        em.getTransaction().begin();

        em.persist(car);
        em.persist(boat);
        em.persist(bicycle);
      //  em.persist(account2);
      //  em.persist(customer3);
      //  em.persist(account3);


        em.getTransaction().commit();
        em.close();

        emf.close();



    }
}
