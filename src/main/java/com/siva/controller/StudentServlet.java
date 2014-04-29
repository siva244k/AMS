package com.siva.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.siva.bean.StudentRoll;
import com.siva.bean.Subjects;
import com.siva.dao.SingleStudentAttendanceDAO;
import com.siva.service.AggreGate;

/**
 * Servlet implementation class StudentServlet
 */
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Double d;
		String roll = request.getParameter("roll");
		request.setAttribute("roll", roll);
		StudentRoll sr = new StudentRoll();
		sr.setRollno(roll);
		SingleStudentAttendanceDAO sdao = new SingleStudentAttendanceDAO();
		List<Subjects> ls = sdao.search(sr);
		request.setAttribute("attendance", ls);
		
		
		
		
		Map<String,List<Subjects>> m=new TreeMap<String,List<Subjects>>();
		m.put(roll, ls);
		AggreGate g=new AggreGate();
		TreeMap<String,Double> t=(TreeMap<String,Double>)g.individualAtten(m);
		Set<String> s=t.keySet();
		Iterator<String> itr=s.iterator();
		while(itr.hasNext())
		{
			String pe=(String)itr.next();
			d=(Double)t.get(pe);
			request.setAttribute("per", d);
			
		}
			
		
		
		
		
		RequestDispatcher rd=request.getRequestDispatcher("/SingleStudent/studentAttendance.jsp");
		rd.forward(request, response);

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
