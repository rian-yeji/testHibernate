package testHibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class testMain {

	private static SessionFactory sessionFactory;
	
	public static void main(String[] args) {
		
		/*Configuration conf = new Configuration();
		conf.configure("hibernate.cfg.xml"); //default이름이라 안써줘도 됨
		sessionFactory = conf.buildSessionFactory();*/
		
		sessionFactory = new Configuration().configure().buildSessionFactory();
		
		/*Category category1 = new Category();
		category1.setName("Computer");
		
		Category category2 = new Category();
		category2.setName("Car");
		
		Product product1 = new Product();
		product1.setName("notebook");
		product1.setPrice(1000);
		product1.setDescription("Powerful notebook!!");
		product1.setCategory(category1);
		category1.getProducts().add(product1);
		
		Product product2 = new Product();
		product2.setName("Desktop");
		product2.setPrice(800);
		product2.setDescription("Powerful Desktop!!");
		product2.setCategory(category1);
		category1.getProducts().add(product2);
		
		Product product3 = new Product();
		product3.setName("Sonata");
		product3.setPrice(10000000);
		product3.setDescription("대중적인 자동차!!");
		product3.setCategory(category2);
		category2.getProducts().add(product3);*/
		
		Person person1 = new Person();
		person1.setFirstName("Namyun");
		person1.setLastName("Kim");
		
		License license1 = new License();
		license1.setLicenseNumber("123456");
		license1.setIssueDate(new Date());
		license1.setPerson(person1);
		
		person1.setLicense(license1);
		
		Person person2 = new Person();
		person2.setFirstName("Yeji");
		person2.setLastName("Lee");
		
		License license2 = new License();
		license2.setLicenseNumber("453256");
		license2.setIssueDate(new Date());
		license2.setPerson(person2);
		
		person2.setLicense(license2);
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(person1);
		session.save(person2);
		
		/*session.save(category1);
		session.save(category2);
		
		session.delete(category1);*/
		
		/*product1.setCategory(null);
		session.delete(product1);
		//session.delete(product3); //category2 - product3
*/		
		tx.commit();
		session.close();
	}

}
