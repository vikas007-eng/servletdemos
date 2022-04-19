package com.userapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addServlet")
public class CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private Connection connection;
	
	public void init() {
		System.out.println("initializing addservlet...");
		try {
			Class.forName("com.mysql.jdbc.Driver"); // loading the driver
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","Vikas@123");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside post method");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		try{
			Statement statement = connection.createStatement();
			// insert into user values ('joe','wilson','abc@gamil.com','test1')
			int result = statement.executeUpdate("insert into user values('" + firstname + "', '" + lastname + "','" + email + "','" + password + "')");
	        PrintWriter out = response.getWriter();
			if(result>0) {
				out.println("<h1>User Created</h1>");
			}else {
				out.println("<h1>error User Created</h1>");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void destroy() {
		try{
			if(connection != null) {
				connection.close();
		      }
		   }catch (SQLException e) {
			 e.printStackTrace();
		}
	
	}

}
