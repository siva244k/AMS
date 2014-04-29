package com.siva.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.siva.bean.AuthenticationBean;
import com.siva.bean.TeacherCreationBean;
import com.siva.service.DBConnection;

public class TeacherCreationDAO {

	Connection connection;
	private static final String TeacherCreation_insert = "insert into TeacherCreation values(?,?,?,?,?)";
	private static final String Teachers_res = "select teachername from teachercreation where department=?";
	
	private static final String passwor_updtae = "update TeacherCreation set password=? where password=? and teachername=?";
	private static final String teacherauth = "select teachername from teachercreation where username=? and password=?";

	public void insert(TeacherCreationBean tcb) {

		try {
			connection = new DBConnection().getConnection();

			PreparedStatement ps = connection
					.prepareStatement(TeacherCreation_insert);

			ps.setString(1, tcb.getDepartment());
			ps.setString(2, tcb.getDesignation());
			ps.setString(3, tcb.getTeachername());
			ps.setString(4, tcb.getUsername());
			ps.setString(5, tcb.getPassword());

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
			System.out.println("teachername  is "+ab.getUsername());
			i=ps.executeUpdate();
			System.out.println("here the result of  update rows "+i);

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;

	}

	public String searchteachername(TeacherCreationBean tcb) {
		String teacher = null;

		try {
			connection = new DBConnection().getConnection();

			PreparedStatement ps = connection.prepareStatement(teacherauth);
			ps.setString(1, tcb.getUsername());
			ps.setString(2, tcb.getPassword());

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				teacher = rs.getString(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return teacher;

	}

	public ArrayList<String> search(TeacherCreationBean tcb) {
		ArrayList<String> al = new ArrayList<String>();

		try {
			connection = new DBConnection().getConnection();

			PreparedStatement ps = connection.prepareStatement(Teachers_res);
			ps.setString(1, tcb.getDepartment());

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				al.add(rs.getString(1));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return al;

	}

}
