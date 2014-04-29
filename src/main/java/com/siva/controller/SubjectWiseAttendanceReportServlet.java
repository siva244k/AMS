package com.siva.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.siva.bean.ClassesBean;
import com.siva.bean.Subjects;
import com.siva.bean.SubjectsBean;
import com.siva.dao.ClassesDAO;
import com.siva.dao.SubjectWiseAggregateDao;
import com.siva.service.AggreGate;

/**
 * Servlet implementation class SubjectWiseAttendanceReportServlet
 */
public class SubjectWiseAttendanceReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SubjectWiseAttendanceReportServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String course = request.getParameter("course");
		int semester = Integer.parseInt(request.getParameter("semester"));
		int year = Integer.parseInt(request.getParameter("year"));
		String subject = request.getParameter("subject");
		String cutoff = request.getParameter("cutoff");
		System.out.println(cutoff);
		if (cutoff != "") {
			int cutof = Integer.parseInt(cutoff);
			pw.println(cutof);
		}

		ClassesBean cb = new ClassesBean();
		cb.setCourse(course);
		cb.setSemester(semester);
		cb.setYear(year);
		ClassesDAO cd = new ClassesDAO();
		cd.search(cb);
		SubjectsBean sb = new SubjectsBean();
		sb.setSubjectid(cb.getId());
		sb.setSubjectname(subject);
		SubjectWiseAggregateDao sao = new SubjectWiseAggregateDao();
		Map<String, Subjects> j = sao.search(sb);
		AggreGate ag = new AggreGate();
		Map<String, Double> sat = ag.subjectWiseAttd(j);
		request.setAttribute("subjectname", subject);
		request.setAttribute("subjectwiaseatt", sat);
		RequestDispatcher rd = request.getRequestDispatcher("/sample2.jsp");
		rd.forward(request, response);

		// System.out.println("selected subject is "+subject.toUpperCase());
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
