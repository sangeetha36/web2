package com.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		
		String uname = request.getParameter("uname");
		String password = request.getParameter("pass");
		String email = request.getParameter("email");
		String phno = request.getParameter("ph");
		String gen = request.getParameter("gen");
		
		
		try
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","password");
			
			Statement st = con.createStatement();
			String qry="insert into user values ('"+uname+"','"+password+"','"+email+"','"+phno+"','"+gen+"')";
			System.out.println(qry);
			int i=st.executeUpdate(qry);
			if(i>0)
			{
				System.out.println("Success");
			}
			else
			{
				System.out.println("Try Again");
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
	}

	
}
