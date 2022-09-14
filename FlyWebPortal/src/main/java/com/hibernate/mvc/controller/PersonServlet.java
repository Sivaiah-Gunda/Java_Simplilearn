package com.hibernate.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hibernate.mvc.dto.Account;
import com.hibernate.mvc.dto.AccountStatus;
import com.hibernate.mvc.dto.Person;
import com.hibernate.mvc.service.PersonServiceImpl;

public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PersonServlet() {
        super();
     
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Person person = new Person();
		Account account=new Account();
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		String email=request.getParameter("email");
		int phone=Integer.parseInt(request.getParameter("phone"));
		
		person.setName(name);
		person.setAddress(address);
		person.setEmailId(email);
		person.setPhone(phone);
		account.setAcc_id(request.getParameter("accId"));
		account.setPassword(request.getParameter("password"));
		account.setAccount_type(request.getParameter("account_type"));
		person.setAccount(account);
		
		System.out.println(person.toString());
		Integer id=new PersonServiceImpl().addPerson(person);
		System.out.println("========AddPersonServlet====id"+id);
		String msg=null;
		if(id > 0)
		{
			msg="Person Added Successfully";
			request.setAttribute("msg", msg);
			RequestDispatcher dispatcher=request.getRequestDispatcher("addAdminPerson.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			msg="Some error while adding user";
			request.setAttribute("msg", msg);
			RequestDispatcher dispatcher=request.getRequestDispatcher("addAdminPerson.jsp");
			dispatcher.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
