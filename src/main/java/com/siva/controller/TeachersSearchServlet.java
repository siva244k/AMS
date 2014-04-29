package com.siva.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.siva.bean.ClassesBean;
import com.siva.bean.TeacherCreationBean;
import com.siva.dao.ClassesDAO;

import com.siva.dao.TeacherCreationDAO;

/**
 * Servlet implementation class TeachersSearchServlet
 */
public class TeachersSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TeachersSearchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stubresponse.setContentType("text/html");
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
		TeacherCreationBean tb = new TeacherCreationBean();
		tb.setDepartment(course.toUpperCase());
		TeacherCreationDAO td = new TeacherCreationDAO();
		ArrayList<String> al = td.search(tb);

		pw.println("<select name=teacher>");
		for (String s : al) {

			pw.println("<option name=" + s + ">");
			pw.println(s);
			pw.println("</option>");

		}
		pw.println("</select>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);// TODO Auto-generated method stub
	}

}
