package com.siva.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.siva.bean.ExtraClassBean;
import com.siva.dao.ExtraClassDAO;

/**
 * Servlet implementation class ExtraClassSearchServlet
 */
public class ExtraClassSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExtraClassSearchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		
		String teacher=request.getParameter("teacher");
		ExtraClassBean eb=new ExtraClassBean();
		eb.setTeachername(teacher);
		ExtraClassDAO edao=new ExtraClassDAO();
		List<ExtraClassBean> lb=edao.search(eb);
		request.setAttribute("classes", lb);
		RequestDispatcher rd=request.getRequestDispatcher("/ExtraClassAttendance/extraclassAttendance.jsp");
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
