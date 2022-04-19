package com.samples.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AdditionServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String number1 = req.getParameter("number1");
		String number2 = req.getParameter("number2");
		if(number1 != null && number2 != null && number1.trim().length()>0 && number2.trim().length()>0) {
        int num1 = Integer.parseInt(number1);
        int num2 = Integer.parseInt(number2);
        
			PrintWriter out = res.getWriter();
			out.println("<p>Result =" + (num1+num2) + "</p>");
		}else {
			PrintWriter out = res.getWriter();
			out.println("<p> Invalid inpiut </p>");
		}
		
	}

}
