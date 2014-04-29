package com.siva.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.siva.bean.StudentRoll;
import com.siva.bean.Subjects;
import com.siva.service.DBConnection;

public class SingleStudentAttendanceDAO {
	public static final String Stud_atd = "select stud_atd.subjectname,stud_atd.abscentclasses,subjects.totalclasses from stud_atd inner join subjects on stud_atd.subjectid=subjects.subjectid and stud_atd.subjectname=subjects.subjectname where stud_atd.roll=?";

	Connection connection;

	public List<Subjects> search(StudentRoll sr) {
		List<Subjects> al = new ArrayList<Subjects>();
		try {
			connection = new DBConnection().getConnection();

			PreparedStatement ps = connection.prepareStatement(Stud_atd);

			ps.setString(1, sr.getRollno());

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Subjects s = new Subjects();
				s.setTotalclasses(rs.getInt(3));

				s.setAttendentlasses((int) rs.getInt(3) - (int) rs.getInt(2));

				s.setSubjectname(rs.getString(1));
				al.add(s);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return al;

	}
}
