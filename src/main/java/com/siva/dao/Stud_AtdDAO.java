package com.siva.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.siva.bean.Stud_AtdBean;
import com.siva.service.DBConnection;

public class Stud_AtdDAO {

	Connection connection;

	private static final String str = "update stud_atd set abscentclasses=1+(select abscentclasses  from stud_atd where subjectid=? and roll=? and subjectname=?) where subjectid=? and roll=? and subjectname=?";

	public void update(Stud_AtdBean stb) {

		try {
			connection = new DBConnection().getConnection();

			PreparedStatement ps = connection.prepareStatement(str);
			String u[] = stb.getRollno();
			for (String y : u) {
				ps.setInt(1, stb.getSubjectid());
				ps.setString(2, y);
				ps.setString(3, stb.getSubjectname());
				ps.setInt(4, stb.getSubjectid());
				ps.setString(5, y);
				ps.setString(6, stb.getSubjectname());
				ps.addBatch();
			}

			int i[] = ps.executeBatch();
			System.out.println("total number of reords updated is " + i);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void search(Stud_AtdBean stb) {

	}

}
