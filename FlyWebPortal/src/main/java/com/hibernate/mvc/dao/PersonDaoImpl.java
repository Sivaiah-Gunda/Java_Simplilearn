package com.hibernate.mvc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.mvc.dto.Person;
import com.hibernate.mvc.util.SessionFactoryManagerImpl;

public class PersonDaoImpl implements PersonDao {
	private SessionFactory factory;
	
	
	public PersonDaoImpl()
	{
		factory = new SessionFactoryManagerImpl().getSessionFactory();
	}
	
	@Override
	public Integer addPerson(Person person) {
		Integer id=null;
		System.out.println("====PersonDaoIml==id==="+id);
		Session session =factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		id=(Integer)session.save(person);
		System.out.println(id);
		transaction.commit();
		session.close();
		return id;
	}

}
