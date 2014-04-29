package com.siva.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.siva.bean.ClassesBean;
import com.siva.bean.Subjects;
import com.siva.bean.SubjectsBean;
import com.siva.dao.AggregateDAO;
import com.siva.dao.ClassesDAO;
import com.siva.dao.SubjectsDAO;
import com.siva.service.AggreGate;

/**
 * Servlet implementation class ClassWiseAttendanceServlet
 */
public class ClassWiseAttendanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClassWiseAttendanceServlet() {
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
		PrintWriter pw = response.getWriter();
		String course = request.getParameter("course");
		int semester = Integer.parseInt(request.getParameter("semester"));
		int year = Integer.parseInt(request.getParameter("year"));
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
		SubjectsDAO sd = new SubjectsDAO();
		ArrayList<String> a2 = sd.search(sb);
		pw.print(a2.size());
		pw.println();

		AggregateDAO ad = new AggregateDAO();
		Map<String, List<Subjects>> a = ad.search(cb, a2.size());

		AggreGate ag = new AggreGate();
		Map<String, Double> iAtt = ag.individualAtten(a);
		request.setAttribute("inAtt", iAtt);
		RequestDispatcher rd = request.getRequestDispatcher("/sample.jsp");
		rd.forward(request, response);

		/*
		 * Set s=.keySet(); Iterator itr=s.iterator(); while(itr.hasNext()) {
		 * String roll=(String) itr.next(); pw.println(roll);
		 * pw.println("*************************************************");
		 * List<Subjects> j=a.get(roll);
		 * System.out.println("here in aggreateservice  the subjects size is "
		 * +a.size()); Iterator itre=j.iterator(); while(itre.hasNext()) {
		 * Subjects t=(Subjects)itre.next();
		 * pw.println(t.getTotalclasses()+"--"+
		 * t.getAbscentclasses()+"--"+t.getSubjectname()); } } /* AggreGate
		 * ag=new AggreGate(); Map r=ag.individualAtten(a); Set l=r.keySet();
		 * Iterator itr=l.iterator(); while(itr.hasNext()) {
		 * pw.print(itr.next()+
		 * "-------------------"+r.get(itr.next())+"--------------");
		 * pw.println();
		 * 
		 * 
		 * }
		 * 
		 * 
		 * 
		 * //System.out.println(cutoff+""+year+""+semester+course);
		 * 
		 * 
		 * 
		 * }
		 * 
		 * /**
		 * 
		 * @see HttpServlet#doPost(HttpServletRequest request,
		 * HttpServletResponse response)
		 */
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
