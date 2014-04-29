package com.siva.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.TreeMap;

import com.siva.bean.AllotSubjectBean;
import com.siva.bean.DialyAttBean;
import com.siva.service.DBConnection;

public class AllotSubjectDAO {

	Connection connection;
	ResultSet res;

	private static final String str = "insert into allotsubject values(?,?,?,?,?,?)";
	private static final String str2 = "select day,period,subjectname,classid from allotsubject where teachername=?";

	public void insert(AllotSubjectBean as) {

		try {

			connection = new DBConnection().getConnection();
			PreparedStatement ps = ((Connection) connection)
					.prepareStatement(str);

			ps.setString(1, as.getTeachername());
			ps.setString(2, as.getSubject());
			ps.setString(3, as.getDay());

			ps.setInt(4, as.getPeriod());
			ps.setInt(5, as.getClassid());
			ps.setString(6, as.getAllotmenttype());

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void update() {

	}

	public void delete() {

	}

	public Map<String, DialyAttBean> getAllotsubjects(AllotSubjectBean as) {
		Map<String, DialyAttBean> m = new TreeMap<String, DialyAttBean>();

		try {

			connection = new DBConnection().getConnection();
			PreparedStatement ps = connection.prepareStatement(str2);

			ps.setString(1, as.getTeachername());

			res = ps.executeQuery();

			while (res.next()) {
				DialyAttBean db = new DialyAttBean();
				String day = res.getString(1);
				int period = res.getInt(2);
				String subject = res.getString(3);
				int classid = res.getInt(4);
				db.setClassid(classid);
				db.setSubjectname(subject);

				String Skey = day + "" + period;
				m.put(Skey, db);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return m;
	}

}
