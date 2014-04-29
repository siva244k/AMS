package com.siva.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.siva.bean.ClassesBean;
import com.siva.bean.ExtraClassBean;
import com.siva.dao.ClassesDAO;
import com.siva.dao.ExtraClassDAO;

/**
 * Servlet implementation class ExtraClassSecondServlet
 */
public class ExtraClassSecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExtraClassSecondServlet() {
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

		String date = request.getParameter("date");
		System.out
				.println("Iam from extraclass asecond srvlet the date from the html oage ois "
						+ date);
		String teacher = request.getParameter("teacher");

		String course = request.getParameter("course");
		int year = Integer.parseInt(request.getParameter("year"));
		int semester = Integer.parseInt(request.getParameter("semester"));
		String subject = request.getParameter("subject");

		int period = Integer.parseInt(request.getParameter("period"));
		String allotmenttype = request.getParameter("allotmenttype");

		String remarks = request.getParameter("remarks");

		ClassesBean cb = new ClassesBean();
		cb.setCourse(course);
		cb.setSemester(semester);
		cb.setYear(year);
		ClassesDAO cd = new ClassesDAO();

		cd.search(cb);

		ExtraClassBean eb = new ExtraClassBean();

		eb.setDateofextraclass(date);
		eb.setPeriod(period);
		eb.setClassid(cb.getId());
		eb.setSubject(subject);
		eb.setTeachername(teacher);
		eb.setRemarks(remarks);
		eb.setAllotmenttype(allotmenttype);

		ExtraClassDAO exdao = new ExtraClassDAO();
		exdao.insert(eb);

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
