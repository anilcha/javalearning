package com.vastika.uis.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vastika.uis.model.User;
import com.vastika.uis.util.DbUtil;

public class UserDaoImpl implements UserDao{
	public static final String INSERT_SQL="insert into user_form_db.user_form_tbl(user_name, password, email, gender, hobbies, nationality, dob) values(?,?,?,?,?,?,?)";
	public static final String UPDATE_SQL="update user_form_tbl set user_name=?, password=?, email=?, gender=?, hobbies=?, nationality=?, dob=? where id =?";
	public static final String DELETE_SQL="delete from user_form_tbl where id=?";
	public static final String GET_BY_ID_SQL="select * from user_form_tbl where id=?";
	public static final String GET_ALL_SQL="select * from user_form_tbl";
	

	@Override
	public void saveUser(User user) {		
		try(
		Connection con = DbUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(INSERT_SQL);
		){
		ps.setString(1, user.getUser_name());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getEmail());
		ps.setString(4, user.getGender());
		ps.setString(5, user.getHobbies());
		ps.setString(6, user.getNationality());
		ps.setDate(7, new Date(user.getDob().getTime()));
		ps.executeUpdate();
		
		}catch ( ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void updateUser(User user) {
		try(
		Connection con = DbUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(UPDATE_SQL);
		){
		ps.setString(1, user.getUser_name());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getEmail());
		ps.setString(4, user.getGender());
		ps.setString(5, user.getHobbies());
		ps.setString(6, user.getNationality());
		ps.setDate(7, new Date(user.getDob().getTime()));
		ps.setInt(8,  user.getId());
		ps.executeUpdate();
		
		}catch ( ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
	}

	@Override
	public void deleteUser(int id) {
		try(
				Connection con = DbUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(DELETE_SQL);
				){
			ps.setInt(1, id);
			ps.executeUpdate();
				
				}catch ( ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				} 	
	}

	@Override
	public User getUserInfoById(int id) {
		User user = new User();
		try(Connection con = DbUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(GET_BY_ID_SQL);
				){
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				user.setId(rs.getInt("id"));
				user.setUser_name(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setGender(rs.getNString("gender"));
				user.setHobbies(rs.getString("hobbies"));
				user.setNationality(rs.getString("nationality"));
				user.setDob(rs.getDate("dob"));
				
			}
		}catch ( ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
			
		return user;
	}

	@Override
	public List<User> getAllUserInfo() {
		List<User> userList = new ArrayList<>();
		try(Connection con = DbUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(GET_ALL_SQL);
				){
	
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUser_name(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setGender(rs.getNString("gender"));
				user.setHobbies(rs.getString("hobbies"));
				user.setNationality(rs.getString("nationality"));
				user.setDob(rs.getDate("dob"));
				userList.add(user);
				
			}
		}catch ( ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
			
		return userList;
	}
}
