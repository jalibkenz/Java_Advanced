package servlet_project.dao;

import java.beans.PersistenceDelegate;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;

import servlet_project.dto.Employee;

public class EmployeeDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public String insert(Employee employee) {
		
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
	
		return "Accout created succesfully";
	}
		
	public Object findbyid(int id) {
			
			Employee employee = entityManager.find(Employee.class,id);
		if (employee==null) {
			return "no data founn in id "+" "+id;
		}
		else
		{
			return employee;
		}
	}
			
			
			
	public String deletebyid(int id){
				
		Employee employee = entityManager.find(Employee.class,id);
		if (employee==null) {
			return "no data found in id "+" "+id;
		}
		else
		{
			entityTransaction.begin();
			entityManager.remove(employee);
			entityTransaction.commit();
			
			return "data deleted succesfully";
		}
	}
	
	}


