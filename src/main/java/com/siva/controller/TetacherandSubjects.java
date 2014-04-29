package com.siva.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.siva.bean.ClassesBean;
import com.siva.bean.SubjectsBean;
import com.siva.bean.TeacherCreationBean;
import com.siva.dao.ClassesDAO;
import com.siva.dao.SubjectsDAO;
import com.siva.dao.TeacherCreationDAO;

public class TetacherandSubjects extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		String course = request.getParameter("course");
		int semester = Integer.parseInt(request.getParameter("semester"));
		int year = Integer.parseInt(request.getParameter("year"));

		ClassesBean cb = new ClassesBean();
		cb.setCourse(course);
		cb.setSemester(semester);
		cb.setYear(year);
		ClassesDAO cd = new ClassesDAO();

		cd.search(cb);

		SubjectsBean sb = new SubjectsBean();
		sb.setSubjectid(cb.getId());
		SubjectsDAO sd = new SubjectsDAO();
		ArrayList<String> al = sd.search(sb);

		TeacherCreationBean tb = new TeacherCreationBean();
		tb.setDepartment(course.toUpperCase());
		TeacherCreationDAO td = new TeacherCreationDAO();
		ArrayList<String> an = td.search(tb);

		pw.println("<table border=2>");

		pw.println("<tr>");
		pw.println("<td>");
		pw.println("subject");
		pw.println("</td>");
		pw.println("<td>");
		pw.println("<select name=subject>");
		for (String s : al) {

			pw.println("<option name=" + s + ">");
			pw.println(s);
			pw.println("</option>");

		}
		pw.println("</select>");
		pw.println("</td>");
		pw.println("</tr>");

		pw.println("<br/>");
		pw.println("<tr>");
		pw.println("<td>");
		pw.println("teacher");
		pw.println("</td>");
		pw.println("<td>");
		pw.println("<select name=teacher>");
		for (String r : an) {

			pw.println("<option name=" + r + ">");
			pw.println(r);
			pw.println("</option>");

		}
		pw.println("</select>");

		pw.println("</td>");

		pw.println("</tr>");
		pw.println("</table>");

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

}
