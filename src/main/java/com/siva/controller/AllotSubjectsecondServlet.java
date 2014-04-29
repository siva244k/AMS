package com.siva.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.siva.bean.AllotSubjectBean;
import com.siva.dao.AllotSubjectDAO;

/**
 * Servlet implementation class AllotSubjectServlet
 */
public class AllotSubjectsecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AllotSubjectsecondServlet() {
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

		// pw.println(request.getParameter("teacher"));
		int classid = Integer.parseInt(request.getParameter("classid"));
		String teacher = request.getParameter("teacher");
		String subject = request.getParameter("subject");
		String day = request.getParameter("day");
		int period = Integer.parseInt(request.getParameter("period"));
		String allotmenttype = request.getParameter("allotment");
		AllotSubjectBean asb = new AllotSubjectBean();
		asb.setAllotmenttype(allotmenttype);
		asb.setClassid(classid);
		asb.setDay(day);
		asb.setPeriod(period);
		asb.setSubject(subject);
		asb.setTeachername(teacher);
		AllotSubjectDAO asd = new AllotSubjectDAO();
		asd.insert(asb);

		PrintWriter pw=response.getWriter();
		pw.println("you have success fully allotted subject    "+subject+"    to teacher    "+teacher);
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
