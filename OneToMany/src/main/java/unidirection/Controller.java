package unidirection;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Controller {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev-connection");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		// setting up UniDirectional+OneToMany Relationship
		// Create one object for AadhaarCard
		AadhaarCard ac = new AadhaarCard();
		ac.setAadhaarNumber(55555);
		ac.setAadhaarName("Jalib Kenz");
		ac.setAadhaarPhone(9895);

		// Create Bank Account 1
		BankAccounts ba1 = new BankAccounts();
		ba1.setBankAccount(111);
		ba1.setBankName("SBI");
		ba1.setBankAddress("Calicut");

		// Create Bank Account 2
		BankAccounts ba2 = new BankAccounts();
		ba2.setBankAccount(222);
		ba2.setBankName("HDFC");
		ba2.setBankAddress("Calicut");

		// Create Bank Account 3
		BankAccounts ba3 = new BankAccounts();
		ba3.setBankAccount(222);
		ba3.setBankName("ICICI");
		ba3.setBankAddress("Calicut");
		
		
		//List of BankAccounts
		List<BankAccounts> listba=new ArrayList<BankAccounts>();
		listba.add(ba1);
		listba.add(ba2);
		listba.add(ba3);
		
		//Establish Relationship
		ac.setLba(listba);
		
		
		et.begin();
		
		em.persist(ac);
		em.persist(ba1);
		em.persist(ba2);
		em.persist(ba3);
		
		et.commit();

	}

}
