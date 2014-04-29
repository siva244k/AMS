package com.siva.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.siva.bean.ClassesBean;
import com.siva.bean.Subjects;
import com.siva.bean.SubjectsBean;
import com.siva.service.DBConnection;

public class AggregateDAO {
	Connection connection;
	public static final String Stud_atd = "select  distinct a.roll,a.subjectname,a.abscentclasses,b.totalclasses from stud_atd a,subjects b where a.subjectid=? and b.subjectid=? order by roll,subjectname";

	public void update(SubjectsBean sb) {

		try {
			connection = new DBConnection().getConnection();

			PreparedStatement ps = connection.prepareStatement(Stud_atd);

			ps.setString(1, sb.getSubjectname());
			ps.setInt(2, sb.getSubjectid());

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Map<String, List<Subjects>> search(ClassesBean cb, int subjects) {
		// Map<String,Map<String,List<Integer>>> m=new
		// TreeMap<String,Map<String,List<Integer>>>();
		Map<String, List<Subjects>> m6 = new TreeMap<String, List<Subjects>>();

		try {
			connection = new DBConnection().getConnection();

			PreparedStatement ps = connection.prepareStatement(Stud_atd);

			ps.setInt(1, cb.getId());
			ps.setInt(2, cb.getId());

			ResultSet rs = ps.executeQuery();
			int count = 0;
			int sub = subjects;
			List<Subjects> al = new ArrayList<Subjects>();

			while (rs.next()) {
				count = count + 1;

				Subjects s = new Subjects();
				s.setTotalclasses(rs.getInt(4));

				s.setAttendentlasses((int) rs.getInt(4) - (int) rs.getInt(3));
				// System.out.println("total attendede classews are "+(rs.getInt(4)-rs.getInt(3)));
				s.setSubjectname(rs.getString(2));
				al.add(s);

				System.out.println(count + "" + sub);
				if ((count % sub) == 0) {

					m6.put(rs.getString(1), al);
					al = new ArrayList<Subjects>();
					// System.out.println(m6);
				}

				// System.out.println("here the subjects size in aggregateDAO is "+m6.size());

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("the size of the map is" + m6.size());
		return m6;

	}
}
