package loking_and_timestamps;

import io.codeforall.fanstatics.Cadet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Sandbox_lock_timestamp {
    public static void main(String[] args) {

       // Use the test persistence unit to configure a new
// entity manager factory and start up JPA
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");

// Open a new database connection by getting a new
// entity manager from the entity manager factory
        EntityManager em = emf.createEntityManager();

        Cadet_lock_timestamp cadet1 = new Cadet_lock_timestamp();
        //cadet1.setId(1);
        cadet1.setName("Manuel");
        cadet1.setAge(24);

        //7cadet1.setId(100);
      //  cadet1.setName("Maria");
       // cadet1.setAge(48);

        em.getTransaction().begin();
        em.persist(cadet1);
        em.getTransaction().commit();

// Used to test the database connection, should return 2
       // System.out.println("Result: " +
         //       em.createNativeQuery("select 1 + 1").getSingleResult());

// Close the database connection
        em.close();

// Shutdown JPA
        emf.close();

    }
}
