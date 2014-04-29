package com.siva.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.siva.bean.StudentsBean;
import com.siva.service.DBConnection;

public class StudentsDAO {

	Connection connection;
	ResultSet res;

	private static final String str = "select roll from  students where st_cls_id=?";

	public List<String> search(StudentsBean sb) {

		List<String> l = new ArrayList<String>();

		try {

			connection = new DBConnection().getConnection();

			PreparedStatement ps = connection.prepareStatement(str);

			ps.setInt(1, sb.getSt_cls_id());
			res = ps.executeQuery();

			while (res.next()) {

				l.add(res.getString(1));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return l;
	}

}
