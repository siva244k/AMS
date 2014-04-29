package com.siva.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

import com.siva.bean.AuthenticationBean;
import com.siva.service.DBConnection;

public class AuthenticationDAO {

	private static final String str_insert = "insert into authentication values(?,?,?)";
	private static final String passwor_updtae = "update authentication set password=? where password=? and username=?";
	private static final String position_search = "select position from authentication where username=? and password=?";

	Connection connection;

	public void insert(AuthenticationBean ab) {

		try {

			connection = new DBConnection().getConnection();

			PreparedStatement ps = connection.prepareStatement(str_insert);

			ps.setString(1, ab.getPosition());
			ps.setString(2, ab.getUsername());
			ps.setString(3, ab.getPassword());

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public int update(AuthenticationBean ab) {
		int i=0;
		try {
			connection = new DBConnection().getConnection();

			PreparedStatement ps = connection.prepareStatement(passwor_updtae);

			ps.setString(1, ab.getNewpassword());
			ps.setString(2, ab.getPassword());
			ps.setString(3, ab.getUsername());
			System.out.println(ab.getNewpassword());
			System.out.println(ab.getPassword());
			System.out.println("username is "+ab.getUsername());
			i=ps.executeUpdate();
			System.out.println("here the result of  update rows "+i);

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;

	}

	public void search(AuthenticationBean ab) {
		String position=null;

		try {
		
			 position="error";
			connection = new DBConnection().getConnection();

			PreparedStatement ps = connection.prepareStatement(position_search);

			ps.setString(1,ab.getUsername());
			ps.setString(2, ab.getPassword());

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				position = rs.getString(1);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		ab.setPosition(position);
	}

}
