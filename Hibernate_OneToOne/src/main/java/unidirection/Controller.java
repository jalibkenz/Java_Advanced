package unidirection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Controller {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		// CREATE ONLY ONE OBJECT ADDRESS FOR PANCARD
		Pancard p1 = new Pancard();
		p1.setId(13);
		p1.setName("Suhasa");
		p1.setPhno(7019177029l);

		// CREATE ONLY ONE OBJECT ADDRESS FOR PERSON
		Person pr = new Person();
		pr.setAddress("Bengaluru");
		pr.setEmail("shetty@gmail.com");
		pr.setName("Suhasa");

		//
		p1.setP(pr);
		et.begin();
		em.persist(p1);
		em.persist(pr);
		et.commit();
	}
}