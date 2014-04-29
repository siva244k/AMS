package com.siva.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.siva.bean.ClassesBean;
import com.siva.service.DBConnection;

public class ClassesDAO {

	private static final String id_search = "select id from classes where course=? and year=? and semester=?";

	Connection connection;

	public void update() {

	}

	public void delete() {

	}

	public void search(ClassesBean cb) {

		int id = 0;

		try {
			connection = new DBConnection().getConnection();

			PreparedStatement ps = connection.prepareStatement(id_search);

			ps.setString(1, cb.getCourse().toUpperCase());
			ps.setInt(2, cb.getYear());
			ps.setInt(3, cb.getSemester());

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				id = rs.getInt(1);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		cb.setId(id);
	}

}
