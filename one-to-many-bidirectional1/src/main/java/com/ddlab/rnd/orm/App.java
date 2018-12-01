package com.ddlab.rnd.orm;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
	public static void showDepartment(Session session) {
		try {
			String hql = "FROM Department";
			Query query = session.createQuery(hql);
			List results = query.list();
			for( int i = 0 ; i < results.size() ; i++) {
				Department dept = (Department) results.get(i);
				System.out.println(dept.getDepartmentName());
				List<Employee> empList = dept.getEmployees();
				for(Employee emp : empList) {
					System.out.println(emp.getFirstname()+"----"+emp.getLastname()+"----"+emp.getEmployeeId());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void saveDepartment(Session session) {
		session.beginTransaction();

		Department department = new Department();
		department.setDepartmentName("Sales");

		Employee emp1 = new Employee("Lilu", "Mishra");
		Employee emp2 = new Employee("Bibhu", "Tripathy");

		department.setEmployees(new ArrayList<Employee>());
		department.getEmployees().add(emp1);
		department.getEmployees().add(emp2);

		session.save(department);

		session.getTransaction().commit();
		session.close();
	}

	public static void main( String[] args )
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
		SessionFactory sessionFactory = (SessionFactory)context.getBean("hibSessionFactory");
		Session session = sessionFactory.openSession();
		
//		saveDepartment(session);
		showDepartment(session);
	}
}
