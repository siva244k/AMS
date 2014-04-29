package com.siva.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.siva.bean.ExtraClassBean;
import com.siva.service.DBConnection;

public class ExtraClassDAO {

	Connection connection;

	private static final String str = "insert into extraclass values(to_date(?,'dd-mm-yyyy'),?,?,?,?,?,?)";
	private static final String str_search = "select subject,period,classid,dof from extraclass where teachername=? and dof>(select sysdate from dual) order by dof";

	public void insert(ExtraClassBean eb) {

		try {
			connection = new DBConnection().getConnection();

			PreparedStatement ps = connection.prepareStatement(str);

			ps.setString(1, eb.getDateofextraclass());
			ps.setInt(2, eb.getClassid());
			ps.setInt(3, eb.getPeriod());
			ps.setString(4, eb.getSubject());
			ps.setString(5, eb.getTeachername());
			ps.setString(6, eb.getAllotmenttype());
			ps.setString(7, eb.getRemarks());

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<ExtraClassBean> search(ExtraClassBean eb) {
		List<ExtraClassBean> l = new ArrayList<ExtraClassBean>();

		try {

			connection = new DBConnection().getConnection();

			PreparedStatement ps = connection.prepareStatement(str_search);

			ps.setString(1, eb.getTeachername());

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ExtraClassBean eb2 = new ExtraClassBean();

				eb2.setSubject(rs.getString(1));
				eb2.setPeriod(rs.getInt(2));
				eb2.setClassid(rs.getInt(3));
				eb2.setDateofextraclass(rs.getDate(4).toString());

				l.add(eb2);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;

	}

	public void update() {

	}

	public void delete() {

	}

}
