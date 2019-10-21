package com.vastika.uis.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vastika.uis.model.User;
import com.vastika.uis.service.UserService;
import com.vastika.uis.service.UserServiceImpl;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService userService = new UserServiceImpl();   	// creating the object

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// to display message after successfully logged out.
		
		HttpSession session = request.getSession();
		session.invalidate();
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		request.setAttribute("msg", "you are successfully logged out");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String user_name = request.getParameter("uname");
	String password =request.getParameter("pass");
	
	User user = userService.getUserByUsernameAndPassword(user_name, password);
	if (user != null){
		HttpSession session = request.getSession();
		session.setAttribute("u", user_name);  // we can give parameter as any name and second arg as anything eg. username, id
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
	}else {
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		request.setAttribute("msg", "Incorrect username or password. Please try again");
		rd.forward(request, response);
	}
	
	}

}
