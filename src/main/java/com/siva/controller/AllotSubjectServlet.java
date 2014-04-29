package com.siva.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.siva.bean.ClassesBean;
import com.siva.bean.SubjectsBean;
import com.siva.dao.ClassesDAO;
import com.siva.dao.SubjectsDAO;

/**
 * Servlet implementation class AllotSubjectServlet
 */
public class AllotSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AllotSubjectServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");

		String course = request.getParameter("course");
		int semester = Integer.parseInt(request.getParameter("semester"));
		int year = Integer.parseInt(request.getParameter("year"));
		String teacher = request.getParameter("teacher");

		request.setAttribute("course", course);
		request.setAttribute("semester", semester);
		request.setAttribute("year", year);
		request.setAttribute("teacher", teacher);

		ClassesBean cb = new ClassesBean();
		cb.setCourse(course);
		cb.setSemester(semester);
		cb.setYear(year);
		ClassesDAO cd = new ClassesDAO();

		cd.search(cb);

		SubjectsBean sb = new SubjectsBean();
		sb.setSubjectid(cb.getId());
		int j = cb.getId();
		SubjectsDAO sd = new SubjectsDAO();
		ArrayList<String> al = sd.search(sb);

		request.setAttribute("subjects", al);
		request.setAttribute("classid", j);

		RequestDispatcher rd = request
				.getRequestDispatcher("/allotsubjectsecond.jsp");
		rd.forward(request, response);

		/*
		 * String subject=request.getParameter("subject"); String
		 * day=request.getParameter("day"); String
		 * period=request.getParameter("period"); String
		 * allotmenttype=request.getParameter("allotmenttype");
		 */

		// pw.println("subjects-teachers is "+teacher);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
