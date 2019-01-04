package core.java.hibernateDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.HibernateException;

import core.java.model.Book;
import core.java.model.Subject;
import core.java.util.JPAUtil;

public class HibernateDao {

	EntityManager manager = JPAUtil.getEntityManagerFactory().createEntityManager();
	EntityTransaction transcation = manager.getTransaction();

	
	
	public boolean addSubject(Subject subject)
	{
		try {
		 transcation.begin(); 
		 manager.persist(subject); 
		 transcation.commit();
		 return true;
		}catch(HibernateException e)
		{
			e.printStackTrace();
			transcation.rollback();
			return false;
		}
		 
	}
	
	public boolean deleteSubject(long refid)
	{
		try {
		transcation.begin();
		Subject subject=manager.find(Subject.class, refid);
		manager.remove(subject);
		transcation.commit();
		return true;
		}catch(HibernateException e)
		{
			e.printStackTrace();
			transcation.rollback();
			return false;
		}
	}
	
	public Subject getSubject(long refid)
	{
		Subject subject=manager.find(Subject.class, refid);
		return subject;
	}
	
	public List<Subject> getAllSubjects()
	{
		String sqlquery="select s from Subject s";
		Query hquery = manager.createQuery(sqlquery);
		@SuppressWarnings("unchecked")
		List<Subject> allsubjects=hquery.getResultList();
		return allsubjects;
	}
	

	public boolean addBook(Book book)
	{
		try {
		 transcation.begin(); 
		 manager.persist(book); 
		 transcation.commit();
		 //JPAUtil.shutdown(); 
		 return true;
	}catch(HibernateException e)
		{
		e.printStackTrace();
		transcation.rollback();
		return false;
	}
	}
	
	public boolean deleteBook(long refid)
	{
		try {
		transcation.begin();
		Book book=manager.find(Book.class, refid);
		manager.remove(book);
		transcation.commit();
		return true;
	}catch(HibernateException e)
		{
		e.printStackTrace();
		transcation.rollback();
		return false;
	}
	}
	public List<Book> getAllBooks()
	{
		String sqlquery="select b from Book b";
		Query hquery = manager.createQuery(sqlquery);
		@SuppressWarnings("unchecked")
		List<Book> allbooks=hquery.getResultList();
		return allbooks;
	}
	
	public Book getBook(long refid)
	{		
		Book book=manager.find(Book.class, refid);
		return book;
	}
	
	public void close()
	{
		JPAUtil.shutdown();
	}

}
