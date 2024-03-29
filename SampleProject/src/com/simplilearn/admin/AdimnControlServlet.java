package com.simplilearn.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.dao.DbRetrieve;
import com.simplilearn.models.Classes;
import com.simplilearn.models.Student;
import com.simplilearn.models.Subject;
import com.simplilearn.models.Teacher;

/**
 * Servlet implementation class AdimControlServlet
 */
public class AdimnControlServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	private DbRetrieve dbRetrieve;

	public void init()
	{
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext()
			.getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext()
			.getInitParameter("jdbcPassword");

		dbRetrieve = new DbRetrieve(
			jdbcURL,
			jdbcUsername,
			jdbcPassword);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException
	{

		doGet(req, resp);
	}

		protected void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		try
		{
			dbRetrieve.connect();

			// read the "command" parameter
			String command = request.getParameter("command");

			if (command == null)
			{
				command = "CLASSES";
			}

			// if no cookeies
			if (!getCookies(request, response) && (!command.equals("LOGIN")))
			{

				response.sendRedirect("/SampleProject/Login.jsp");
			}

			else
			{

				// if there is no command, how to handle

				// route the data to the appropriate method
				switch (command)
				{

					case "STUDENTS" :
						studentsList(request, response);
						break;

					case "TEACHERS" :
						teachersList(request, response);
						break;

					case "SUBJECTS" :
						subjectList(request, response);
						break;

					case "CLASSES" :
						classestList(request, response);
						break;

					case "ST_LIST" :
						classStudentsList(request, response);
						break;

					case "LOGIN" :
						login(request, response);
						break;

					default :
						classestList(request, response);

				}
			}
		}
		catch (Exception e)
		{
			throw new ServletException(
				e);
		}
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
	}

	private void studentsList(HttpServletRequest request,
		HttpServletResponse response) throws Exception
	{
		// get students from db util
		List<Student> students = dbRetrieve.getStudents();

		// add students to the request
		request.setAttribute("STUDENT_LIST", students);

		// send it to the jsp view page
		RequestDispatcher dispatcher = request
			.getRequestDispatcher("/ListStudents.jsp");
		dispatcher.forward(request, response);

	}

	private void teachersList(HttpServletRequest request,
		HttpServletResponse response) throws Exception
	{
		// get students from db util
		List<Teacher> teachers = dbRetrieve.getTeachers();

		// add students to the request
		request.setAttribute("TEACHERS_LIST", teachers);

		// send it to the jSP view page
		RequestDispatcher dispatcher = request
			.getRequestDispatcher("/TeacherList.jsp");
		dispatcher.forward(request, response);

	}

	private void subjectList(HttpServletRequest request,
		HttpServletResponse response) throws Exception
	{
		// get subjects from db util
		List<Subject> subjects = dbRetrieve.getSubjects();

		// add subjects to the request
		request.setAttribute("SUBJECTS_LIST", subjects);

		// send it to the jSP view page
		RequestDispatcher dispatcher = request
			.getRequestDispatcher("/SubjectList.jsp");
		dispatcher.forward(request, response);

	}

	private void classestList(HttpServletRequest request,
		HttpServletResponse response) throws Exception
	{
		// get subjects from db util
		List<Classes> classes = dbRetrieve.getClasses();

		// add subjects to the request
		request.setAttribute("CLASSES_LIST", classes);

		// send it to the jSP view page
		RequestDispatcher dispatcher = request
			.getRequestDispatcher("/ClassList.jsp");
		dispatcher.forward(request, response);

	}

	private void login(HttpServletRequest request,
		HttpServletResponse response) throws Exception
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (username.toLowerCase().equals("admin")
				&& password.toLowerCase().equals("admin"))
		{

			Cookie cookie = new Cookie(
				username,
				password);

			// Setting the maximum age to 1 day
			cookie.setMaxAge(86400); // 86400 seconds in a day

			// Send the cookie to the client
			response.addCookie(cookie);
			classestList(request, response);
		}
		else
		{
			RequestDispatcher dispatcher = request
				.getRequestDispatcher("/Login.jsp");
			dispatcher.forward(request, response);
		}

	}

	private void classStudentsList(HttpServletRequest request,
		HttpServletResponse response) throws Exception
	{

		int classId = Integer.parseInt(request.getParameter("classId"));
		String section = request.getParameter("section");
		String subject = request.getParameter("subject");

		// get subjects from db util
		List<Student> students = dbRetrieve.loadClassStudents(classId);

		// add subjects to the request
		request.setAttribute("STUDENTS_LIST", students);
		request.setAttribute("SECTION", section);
		request.setAttribute("SUBJECT", subject);

		// send it to the jSP view page
		RequestDispatcher dispatcher = request
			.getRequestDispatcher("/ClassStudents.jsp");
		dispatcher.forward(request, response);

	}

	private boolean getCookies(HttpServletRequest request,
		HttpServletResponse response) throws Exception
	{

		boolean check = false;
		Cookie[] cookies = request.getCookies();
		// Find the cookie of interest in arrays of cookies
		for (Cookie cookie : cookies)
		{

			if (cookie.getName().equals("admin")
					&& cookie.getValue().equals("admin"))
			{
				check = true;
				break;
			}

		}

		return check;

	}

}
