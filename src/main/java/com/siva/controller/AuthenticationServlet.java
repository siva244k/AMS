package com.siva.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.siva.bean.AuthenticationBean;
import com.siva.dao.AuthenticationDAO;
import com.siva.service.DBConnection;

import java.sql.*;
import java.io.*;
import java.net.*;


public class AuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
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
			AuthenticationDAO abdao = new AuthenticationDAO();
			int i=abdao.update(ab);
			if(i==1)
			pw.println("password successfully updated");
			else
				pw.println("you enter wrong credintials");
			
		}
		else
		{
		// String position=request.getParameter("position");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		pw.println(username);
		pw.println(password);

		HttpSession session=request.getSession();
		session.setAttribute("username", username);
		AuthenticationBean ab = new AuthenticationBean();
		ab.setUsername(username);
		ab.setPassword(password);

		AuthenticationDAO abdao = new AuthenticationDAO();

		abdao.search(ab);
		String position = ab.getPosition();

	

		System.out.println("it is going to redirect......");
		response.sendRedirect("/" + position + ".jsp");
		
		
		
		
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);

	}

}
