package com.simplilearn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.simplilearn.models.Classes;
import com.simplilearn.models.Student;
import com.simplilearn.models.Subject;
import com.simplilearn.models.Teacher;

public class DbRetrieve
{

	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;

	public DbRetrieve(String jdbcURL, String jdbcUsername, String jdbcPassword)
	{
		this.jdbcURL = jdbcURL;
		this.jdbcUsername = jdbcUsername;
		this.jdbcPassword = jdbcPassword;
	}

	public void connect() throws SQLException
	{
		if (jdbcConnection == null || jdbcConnection.isClosed())
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");

			}
			catch (Exception e)
			{
				throw new SQLException(
					e);
			}
			jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername,
				jdbcPassword);
		}
	}

	public List<Student> getStudents()
	{

		List<Student> students = new ArrayList<>();

		Statement myStmt = null;
		ResultSet myRs = null;

		try
		{

			// create sql stmt
			String sql = "SELECT * FROM students";
			myStmt = jdbcConnection.createStatement();

			// execute query
			myRs = myStmt.executeQuery(sql);

			// process result
			while (myRs.next())
			{

				// retrieve data from result set row
				int id = myRs.getInt("id");
				String firstName = myRs.getString("fname");
				String lastName = myRs.getString("lname");
				int age = myRs.getInt("age");
				int aclass = myRs.getInt("aclass");

				// create new student object
				Student tempStudent = new Student(
					id,
					firstName,
					lastName,
					age,
					aclass);

				// add it to the list of students
				students.add(tempStudent);

			}

		}
		catch (Exception e)
		{
			// TODO: handle exception
		}
		finally
		{
			// close JDBC objects
			close(myStmt, myRs);
		}
		return students;

	}

	public List<Teacher> getTeachers()
	{

		List<Teacher> teachers = new ArrayList<>();

		Statement myStmt = null;
		ResultSet myRs = null;

		try
		{

			// create sql stmt
			String sql = "SELECT * FROM teachers";
			myStmt = jdbcConnection.createStatement();

			// execute query
			myRs = myStmt.executeQuery(sql);

			// process result
			while (myRs.next())
			{

				// retrieve data from result set row
				int id = myRs.getInt("id");
				String firstName = myRs.getString("fname");
				String lastName = myRs.getString("lname");
				int age = myRs.getInt("age");

				// create new teacher object
				Teacher temp = new Teacher(
					id,
					firstName,
					lastName,
					age);

				// add it to the list of teachers
				teachers.add(temp);

			}

		}
		catch (Exception e)
		{
			// TODO: handle exception
		}
		finally
		{
			// close JDBC objects
			close(myStmt, myRs);
		}
		return teachers;

	}

	public List<Subject> getSubjects()
	{

		List<Subject> subjects = new ArrayList<>();

		Statement myStmt = null;
		ResultSet myRs = null;

		try
		{

			// create sql stmt
			String sql = "SELECT * FROM subjects";
			myStmt = jdbcConnection.createStatement();

			// execute query
			myRs = myStmt.executeQuery(sql);

			// process result
			while (myRs.next())
			{

				// retrieve data from result set row
				int id = myRs.getInt("id");
				String name = myRs.getString("name");
				String shortcut = myRs.getString("shortcut");

				// create new student object
				Subject temp = new Subject(
					id,
					name,
					shortcut);

				// add it to the list of students
				subjects.add(temp);

			}

		}
		catch (Exception e)
		{
			// TODO: handle exception
		}
		finally
		{
			// close JDBC objects
			close(myStmt, myRs);
		}
		return subjects;

	}

	public List<Classes> getClasses()
	{

		List<Classes> classes = new ArrayList<>();

		Statement myStmt = null;
		ResultSet myRs = null;

		try
		{

			// create sql stmt
			String sql = "SELECT * FROM classes";
			myStmt = jdbcConnection.createStatement();

			// execute query
			myRs = myStmt.executeQuery(sql);

			// process result
			while (myRs.next())
			{

				// retrieve data from result set row
				int id = myRs.getInt("id");
				int section = myRs.getInt("section");
				int subject = myRs.getInt("subject");
				int teacher = myRs.getInt("teacher");
				String time = myRs.getString("time");

				Teacher tempTeacher = loadTeacher(teacher);
				Subject tempSubject = loadSubject(subject);

				String teacher_name = tempTeacher.getFname() + " "
						+ tempTeacher.getLname();

				// create new student object
				Classes temp = new Classes(
					id,
					section,
					teacher_name,
					tempSubject.getName(),
					time);

				// add it to the list of students
				classes.add(temp);

			}

		}
		catch (Exception e)
		{
			// TODO: handle exception
		}
		finally
		{
			// close JDBC objects
			close(myStmt, myRs);
		}
		return classes;

	}

	public Teacher loadTeacher(int teacherId)
	{

		Teacher theTeacher = null;

		Statement myStmt = null;
		ResultSet myRs = null;

		try
		{

			// create sql stmt
			String sql = "SELECT * FROM teachers WHERE id = " + teacherId;
			myStmt = jdbcConnection.createStatement();

			// execute query
			myRs = myStmt.executeQuery(sql);

			// process result
			while (myRs.next())
			{

				// retrieve data from result set row
				int id = myRs.getInt("id");
				String fname = myRs.getString("fname");
				String lname = myRs.getString("lname");
				int age = myRs.getInt("age");
				theTeacher = new Teacher(
					id,
					fname,
					lname,
					age);

			}

		}
		catch (Exception e)
		{
			// TODO: handle exception
		}
		finally
		{
			// close JDBC objects
			closeDbResources(myStmt, myRs);
		}
		return theTeacher;

	}

	public Subject loadSubject(int subjectId)
	{

		Subject theSubject = null;

		Statement myStmt = null;
		ResultSet myRs = null;

		try
		{

			// create sql stmt
			String sql = "SELECT * FROM subjects WHERE id = " + subjectId;
			myStmt = jdbcConnection.createStatement();

			// execute query
			myRs = myStmt.executeQuery(sql);

			// process result
			while (myRs.next())
			{

				// retrieve data from result set row
				int id = myRs.getInt("id");
				String name = myRs.getString("name");
				String shortcut = myRs.getString("shortcut");

				theSubject = new Subject(
					id,
					name,
					shortcut);

			}

		}
		catch (Exception e)
		{
			// TODO: handle exception
		}
		finally
		{
			// close JDBC objects
			closeDbResources(myStmt, myRs);
		}
		return theSubject;

	}

	public List<Student> loadClassStudents(int classId)
	{

		List<Student> students = new ArrayList<>();

		Statement myStmt = null;
		ResultSet myRs = null;

		try
		{

			// create sql stmt
			String sql = "SELECT * FROM students WHERE aclass = " + classId;
			myStmt = jdbcConnection.createStatement();

			// execute query
			myRs = myStmt.executeQuery(sql);

			// process result
			while (myRs.next())
			{

				// retrieve data from result set row
				int id = myRs.getInt("id");
				String firstName = myRs.getString("fname");
				String lastName = myRs.getString("lname");
				int age = myRs.getInt("age");
				int aclass = myRs.getInt("aclass");

				// create new student object
				Student tempStudent = new Student(
					id,
					firstName,
					lastName,
					age,
					aclass);
				students.add(tempStudent);

			}

		}
		catch (Exception e)
		{
			// TODO: handle exception
		}
		finally
		{
			// close JDBC objects
			close(myStmt, myRs);
		}
		return students;

	}

	private void close(Statement myStmt, ResultSet myRs)
	{

		try
		{
			if (myRs != null)
			{
				myRs.close();
			}
			if (myStmt != null)
			{
				myStmt.close();
			}
			if (jdbcConnection != null)
			{
				jdbcConnection.close();
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}
	private void closeDbResources(Statement myStmt, ResultSet myRs)
	{

		try
		{
			if (myRs != null)
			{
				myRs.close();
			}
			if (myStmt != null)
			{
				myStmt.close();
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}
}
