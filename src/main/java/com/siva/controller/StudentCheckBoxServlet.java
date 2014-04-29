package com.siva.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.siva.bean.StudentsBean;
import com.siva.dao.StudentsDAO;

/**
 * Servlet implementation class StudentCheckBoxServlet
 */
public class StudentCheckBoxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentCheckBoxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		int clasid=Integer.parseInt(request.getParameter("classid"));
		String subject=request.getParameter("subject");
		StudentsDAO st=new StudentsDAO();
		StudentsBean sb=new StudentsBean();
		sb.setSt_cls_id(clasid);
		List<String> l=(ArrayList<String>) st.search(sb);
		request.setAttribute("students", l);
		request.setAttribute("subject", subject);
		request.setAttribute("classid",clasid);
		RequestDispatcher rd=request.getRequestDispatcher("/studentcheckboxattd.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
