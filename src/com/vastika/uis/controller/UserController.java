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
	private static final String USER_FORM="userForm.jsp";
	private static final String USER_EDIT_FORM="userEditForm.jsp";
	private static final String USER_LIST="userList.jsp";
	
	// to send the date to the service, creating object for the service
	UserService userService = new UserServiceImpl();
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String a = request.getParameter("actions");
		String forward="";
		
		if (a.equals("edit")) {
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("user", userService.getUserInfoById(id)); // to retrieve users by id
			forward=USER_EDIT_FORM;
		}
		
		else if (a.equals("delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			userService.deleteUser(id);
			request.setAttribute("users", userService.getAllUserInfo());
			forward=USER_LIST;
		}	
		
		else if (a.equals("add")) {
			forward=USER_FORM;		
		}
		else if (a.equals("list")) {										// TO BRING ALL THE LIST WHILE OPENING USER FROM THE HOME PAGE
			request.setAttribute("users", userService.getAllUserInfo());
			forward=USER_LIST;		
		}
		RequestDispatcher rd = request.getRequestDispatcher(forward);		
		rd.forward(request, response);
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
			
			String userId= request.getParameter("id");
			if(userId==null || userId.isEmpty()) {
				userService.saveUser(user);
		}
			else {
				int id=Integer.parseInt(userId);
				user.setId(id);
				userService.updateUser(user);
			}
		
		// now saving data in the UserService
		
		
		
		//after saving the date and sending to the next form, create another JSP file (userlist)

		RequestDispatcher rd = request.getRequestDispatcher("userList.jsp");
		// to bring all the data in the userlist
		request.setAttribute("users", userService.getAllUserInfo());		
		rd.forward(request, response);
		
		}
	}

}
