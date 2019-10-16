package com.vastika.uis.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vastika.uis.model.User;
import com.vastika.uis.service.UserService;
import com.vastika.uis.service.UserServiceImpl;


@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// to send the date to the service, creating object for the service
	UserService userService = new UserServiceImpl();
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		User user = new User();
		user.setUser_name(request.getParameter("user_name"));
		user.setPassword(request.getParameter("password"));
		user.setEmail(request.getParameter("email"));
		user.setGender(request.getParameter("gender"));
		
		
		try {
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			Date d = sf.parse(request.getParameter("dob"));
			user.setDob(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		user.setNationality(request.getParameter("nationality"));
		
		String hobbies = "";
		String  [] hh = request.getParameterValues("hobbies");
		for (String h : hh) {
			hobbies += h + ",";					// Concatenate hobbies reading and playing
			
			user.setHobbies(hobbies);
			
		}
		
		// now saving data in the UserService
		
		userService.saveUser(user);
		
		//after saving the date and sending to the next form, create another JSP file (userlist)

		RequestDispatcher rd = request.getRequestDispatcher("userList.jsp");
		rd.forward(request, response);
		

	}

}
