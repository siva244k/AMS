package com.siva.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.siva.bean.AllotSubjectBean;
import com.siva.bean.AuthenticationBean;
import com.siva.bean.DialyAttBean;
import com.siva.bean.TeacherCreationBean;
import com.siva.dao.AllotSubjectDAO;
import com.siva.dao.TeacherCreationDAO;

/**
 * Servlet implementation class TeacherInterfaceController
 */
public class TeacherInterfaceController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TeacherInterfaceController() {
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
		PrintWriter pw=response.getWriter();
		
		if((request.getParameter("method"))!=null&&request.getParameter("method").equals("changepassword"))
		{
			
			HttpSession session=request.getSession();
			String username=(String)session.getAttribute("username");
			String oldpassword=request.getParameter("oldpassword");
			String newpassword=request.getParameter("newpassword");
			System.out.println(username);
			System.out.println(oldpassword);
			System.out.println(newpassword);
			AuthenticationBean ab = new AuthenticationBean();
			ab.setNewpassword(newpassword);
			ab.setPassword(oldpassword);
			ab.setUsername(username);
			System.out.println("in servlet method the username is "+username);
			TeacherCreationDAO tdao = new TeacherCreationDAO();
			int i=tdao.update(ab);
			if(i==1)
			pw.println("password successfully updated");
			else
				pw.println("you enter wrong credintials");
			
		}
		else{
		
		String username = request.getParameter("username");
		HttpSession session=request.getSession();
		session.setAttribute("username", username);
		
		String password = request.getParameter("password");
		System.out.println("in tecaheController");
		TeacherCreationBean tb = new TeacherCreationBean();
		tb.setUsername(username);
		tb.setPassword(password);
		TeacherCreationDAO tdao = new TeacherCreationDAO();
		String teacher = tdao.searchteachername(tb);
		
		AllotSubjectDAO adao = new AllotSubjectDAO();
		AllotSubjectBean as = new AllotSubjectBean();
		as.setTeachername(teacher);
		Map<String, DialyAttBean> m = adao.getAllotsubjects(as);
		HttpSession s = request.getSession();
		s.setAttribute("teacher", teacher);
		s.setAttribute("timetable", m);
		if(teacher==null)
		{RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
		rd.forward(request, response);}
		else
		{

		RequestDispatcher rd2 = request.getRequestDispatcher("/teacher.jsp");
		rd2.forward(request, response);
		}
		
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
