package core.java.service;

import java.util.List;

import core.java.hibernateDAO.HibernateDao;
import core.java.model.Book;
import core.java.model.Subject;

public class LibraryService {

	HibernateDao dao=new HibernateDao();
	
	public boolean addSubject(Subject subject)
	{
		return dao.addSubject(subject);
	}
	
	public Subject getSubject(long refid)
	{
		return dao.getSubject(refid);
	}
	
	public boolean deleteSubject(long refid)
	{
		return dao.deleteSubject(refid);
	}
	
	public List<Subject> getAllSubjects()
	{
		return dao.getAllSubjects();
	}
	
	public boolean addBook(Book book)
	{
		return dao.addBook(book);
	}
	
	public Book getBook(long refid)
	{
		return dao.getBook(refid);
	}
	
	public boolean deleteBook(long refid)
	{
		return dao.deleteBook(refid);
	}
	
	public List<Book> getAllBooks()
	{
		return dao.getAllBooks();
	}
	
	public void close()
	{
		dao.close();
	}
}
