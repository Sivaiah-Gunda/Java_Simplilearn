package com.hibernate.mvc.service;

import com.hibernate.mvc.dao.PersonDao;
import com.hibernate.mvc.dao.PersonDaoImpl;
import com.hibernate.mvc.dto.Person;

public class PersonServiceImpl implements PersonService {
	private PersonDao dao;
	
	public PersonServiceImpl()
	{
		dao=new PersonDaoImpl();
	}
	@Override
	public Integer addPerson(Person person) {
		
		return dao.addPerson(person);
	}

}
