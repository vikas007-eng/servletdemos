package com.testParams.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestParamServlet")
public class TestParamServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
 
    private String greeting;
    private String license;
    
	public void init() {
		 greeting = getServletConfig().getInitParameter("greeting");
		 license = getServletConfig().getInitParameter("license");
		
	}
    public TestParamServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("Inside TestParamservlet  Get Method");
	    PrintWriter out = response.getWriter();
	    
	    ServletContext sc = getServletContext();
	    String projectName = sc.getInitParameter("project-name");
	    String expirationSeconds = sc.getInitParameter("login-expriration-time-in-seconds");
	    
	    out.println("From get method");
	    out.println("---------------------------------------");
	    out.println("Project Name: " + projectName);
	    out.println("Expiration Seconds: " + expirationSeconds);
	    out.println("---------------------------------------");
	    out.println("Greeting Message: " + greeting);
	    out.println("license: " + license);
	    
	  
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside Get Method");
	}

}
