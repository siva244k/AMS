package com.siva.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.siva.bean.TeacherCreationBean;
import com.siva.dao.TeacherCreationDAO;

/**
 * Servlet implementation class TeacherCreationServlet
 */
public class TeacherCreationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TeacherCreationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request
				.getRequestDispatcher("/passwordnotmatch.jsp");
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String department = request.getParameter("department");
		String designation = request.getParameter("designation");
		String teachername = request.getParameter("teachername");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirmpassword = request.getParameter("confirmpassword");
		if (password.equalsIgnoreCase(confirmpassword)) {

			TeacherCreationBean tb = new TeacherCreationBean();
			tb.setDepartment(department);
			tb.setDesignation(designation);
			tb.setTeachername(teachername);
			tb.setUsername(username);
			tb.setPassword(confirmpassword);

			TeacherCreationDAO tdao = new TeacherCreationDAO();
			tdao.insert(tb);

			pw.println("you have succesfully cretaed " + tb.getTeachername()
					+ "'s Profile");

		} else {

			rd.forward(request, response);
		}

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
