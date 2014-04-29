package com.siva.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.Map;
import java.util.TreeMap;

import com.siva.bean.Subjects;
import com.siva.bean.SubjectsBean;
import com.siva.service.DBConnection;

public class SubjectWiseAggregateDao {
	public static final String Subjectwise_atd = "select  distinct a.roll,a.subjectname,a.abscentclasses,b.totalclasses from stud_atd a,subjects b where (a.subjectid=? and b.subjectid=?) and (a.subjectname=?) order by roll,subjectname";

	Connection connection;

	public void update(SubjectsBean sb) {

		try {
			connection = new DBConnection().getConnection();

			PreparedStatement ps = connection.prepareStatement(Subjectwise_atd);

			ps.setString(1, sb.getSubjectname());
			ps.setInt(2, sb.getSubjectid());

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Map<String, Subjects> search(SubjectsBean sb) {
		// Map<String,Map<String,List<Integer>>> m=new
		// TreeMap<String,Map<String,List<Integer>>>();
		Map<String, Subjects> m6 = new TreeMap<String, Subjects>();

		try {
			connection = new DBConnection().getConnection();

			PreparedStatement ps = connection.prepareStatement(Subjectwise_atd);

			ps.setInt(1, sb.getSubjectid());
			ps.setInt(2, sb.getSubjectid());
			ps.setString(3, sb.getSubjectname());

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Subjects s = new Subjects();
				s.setTotalclasses(rs.getInt(4));

				s.setAttendentlasses((int) rs.getInt(4) - (int) rs.getInt(3));

				s.setSubjectname(rs.getString(2));

				m6.put(rs.getString(1), s);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("the size of the map is" + m6.size());
		return m6;

	}
}
