package com.siva.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.siva.bean.Stud_AtdBean;
import com.siva.bean.SubjectsBean;
import com.siva.dao.Stud_AtdDAO;
import com.siva.dao.SubjectsDAO;

/**
 * Servlet implementation class AttendanceInsertServlet
 */
public class AttendanceInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AttendanceInsertServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String s[] = request.getParameterValues("student");
		String subject = request.getParameter("subject");
		int classid = Integer.parseInt(request.getParameter("classid"));
		// subject total classes updation code
		SubjectsBean sb = new SubjectsBean();
		sb.setSubjectname(subject);
		sb.setSubjectid(classid);
		SubjectsDAO sdao = new SubjectsDAO();
		 sdao.update(sb);

		 PrintWriter pw = response.getWriter();
		 //students att injcerement code
		 if(s!=null)
		 {
		 
		Stud_AtdBean sab = new Stud_AtdBean();
		sab.setSubjectid(classid);
		sab.setRollno(s);
		sab.setSubjectname(subject);
		Stud_AtdDAO stdao = new Stud_AtdDAO();
		stdao.update(sab);

		
		for (String t : s) {
			pw.println(t);
		}
		 }else{
			 pw.println("No Students were Abscent so full attendance only subjectv totla classes aare updated");
		 }
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
