package com.siva.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.siva.bean.SubjectsBean;
import com.siva.service.DBConnection;

import java.util.ArrayList;

public class SubjectsDAO {

	public static final String Subjects_atd = "update subjects set totalclasses=1+(select totalclasses from subjects where subjectname=? and subjectid=?) where subjectname=? and subjectid=?";
	public static final String subjects = "select subjectname from subjects where subjectid=?";

	Connection connection;

	public void update(SubjectsBean sb) {

		try {
			connection = new DBConnection().getConnection();

			PreparedStatement ps = connection.prepareStatement(Subjects_atd);

			ps.setString(1, sb.getSubjectname());
			ps.setInt(2, sb.getSubjectid());
			ps.setString(3, sb.getSubjectname());
			ps.setInt(4, sb.getSubjectid());

			int i = ps.executeUpdate();
			System.out.println(i + "Subject is Updated");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ArrayList<String> search(SubjectsBean sb) {
		ArrayList<String> al = new ArrayList<String>();

		try {
			connection = new DBConnection().getConnection();

			PreparedStatement ps = connection.prepareStatement(subjects);
			ps.setInt(1, sb.getSubjectid());

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
