package com.lti.servlet;

import java.io.IOException;
import java.util.Base64;
import com.lti.training.user.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lti.training.user.*;



/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.lti")
public class LoginServlet1 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//reading request data
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//InMemoryUserManager mgr = new InMemoryUserManager();
		DatabaseUserManager mgr=new DatabaseUserManager();
		boolean isValid=mgr.isValidUser(username,password);
		if(isValid) {
				 String rememberMe=request.getParameter("rememberMe");
		/*if(username.equals(mgr) && password.equals(mgr)) {
			String rememberMe = request.getParameter("rememberMe");*/
			if(rememberMe != null && rememberMe.equals("yes")) {
				 String encodedUsername = Base64.getEncoder().encodeToString(
				            username.getBytes("utf-8"));
				 String encodedPassword = Base64.getEncoder().encodeToString(
				            password.getBytes("utf-8"));
			
				Cookie c1 = new Cookie("username",encodedUsername);
				Cookie c2 = new Cookie("password",encodedPassword);
				c1.setMaxAge(60 * 60);
				c2.setMaxAge(60 * 60);
				response.addCookie(c1);
				response.addCookie(c2);
			}
			response.sendRedirect("Welcome.html");
		}
		else
			response.sendRedirect("login.html");
	}
}
