package com.vastika.uis.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vastika.uis.model.User;
import com.vastika.uis.service.UserService;
import com.vastika.uis.service.UserServiceImpl;


@WebServlet("/ResetPasswordController")
public class ResetPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UserService userService = new UserServiceImpl();
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		user.setUser_name(request.getParameter("user_name"));
		user.setPassword(request.getParameter("password"));
		user.setEmail(request.getParameter("email"));
		user.setGender(request.getParameter("gender"));
		
		
		try {
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			Date d = (Date) sf.parse(request.getParameter("dob"));
			user.setDob(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		user.setNationality(request.getParameter("nationality"));
		
		String hobbies = "";
		String  [] hh = request.getParameterValues("hobbies");
		for (String h : hh) {
			hobbies += h + ",";					
			
			user.setHobbies(hobbies);
			
			String userId= request.getParameter("id");
			if(userId==null || userId.isEmpty()) {
				userService.saveUser(user);
		}
			else {
				int id=Integer.parseInt(userId);
				user.setId(id);
				userService.updateUser(user);
			}
		

		RequestDispatcher rd = request.getRequestDispatcher("userList.jsp");
		request.setAttribute("users", userService.getAllUserInfo());		
		rd.forward(request, response);
		
		}
	}


}
