package servlet_project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import servlet_project.dto.Employee;

public class EmployeeDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public String insert(Employee employee) {
		entityTransaction.begin();
		entityManager.persist(employee); // persist to create a new and merge() to update to the existing data
		entityTransaction.commit();
		return "account created successfully";
	}

	public Object findById(int id) {
		Employee employee = entityManager.find(Employee.class, id);
		if (employee == null) {
			return "no data found with id" + " " + id;
		} else
			return employee;
	}

	public String deleteById(int id) {
		Employee employee = entityManager.find(Employee.class, id);
		if (employee == null) {
			return "no data found with id" + " " + id;
		} else {
			entityTransaction.begin();
			entityManager.remove(employee);
			entityTransaction.commit();
			return "data deleted successfully";
		}
	}

	public List<Employee> fetchAll() {
		// select vn from tablename vn
		Query q = entityManager.createQuery("select a from Employee a");
		List<Employee> list = q.getResultList();
		return list;
	}

	public String deleteAll() {
		// select vn from tablename vn
		Query q = entityManager.createQuery("select a from Employee a");
		List<Employee> list = q.getResultList();
		if (list.isEmpty()) {
			return "no object found";
		} else {
			for (Employee e : list) {
				entityTransaction.begin();
				entityManager.remove(e);
				entityTransaction.commit();
			}
			return "data deleted";
		}
	}

}
