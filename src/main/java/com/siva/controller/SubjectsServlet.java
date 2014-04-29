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

import com.siva.dao.ClassesDAO;
import com.siva.dao.SubjectsDAO;

/**
 * Servlet implementation class SubjectsServlet
 */
public class SubjectsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 * 
	 *      /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
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

		pw.println("<select name=subject>");
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
		doGet(request, response);
	}

}
