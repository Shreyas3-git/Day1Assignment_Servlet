package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.*;


public class FirstServletApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServletApp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String username,password;
			
			
			response.setContentType("text/html");
			username = request.getParameter("user");
			password = request.getParameter("pass");
			PrintWriter out = response.getWriter();
			System.out.println("Generating response for "+ username + " >> " + password);
			
			
			String nameRegex,passwordRegex;
			nameRegex = "^[A-z]{1}[a-z]{2,15}$";
			passwordRegex = "^[^[0-9]][a-zA-Z]{3,14}[\\W[0-9]]{3,7}$";
			
//			Pattern pn = Pattern.compile(nameRegex);
//			Pattern ps = Pattern.compile(passwordRegex);
			
			if (username.matches(nameRegex) && password.matches(passwordRegex)) 
			{
				out.println("You have login successfully:");
			}
			else 
			{
				out.println("Enter correct username/password login fail...");
			}
		}catch (Exception e) {
			System.out.println("Something went wrong");
		}
	}

}
