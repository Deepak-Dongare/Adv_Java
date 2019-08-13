package com.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Databasec
 */
@WebServlet("/register")
public class register extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		
		String userId=request.getParameter("userId");
		String userName=request.getParameter("userName");
		String UserCity=request.getParameter("UserCity");
		String UserEmail=request.getParameter("UserEmail");
		String Userpass=request.getParameter("Userpass");
		String UserCountry=request.getParameter("UserCountry");

		
		
		Scanner sc=new Scanner(System.in);
		{
				try
				{
					String driver =("com.mysql.jdbc.Driver");
					String jdbc_url=("jdbc:mysql://localhost:3306/userlogin");
					String User=("root");
				    String pwd=("system");

					Class.forName(driver);
					Connection con=DriverManager.getConnection(jdbc_url,User,pwd);
					 String sqlquery="insert into userdata values(?,?,?,?,?,?)";
					 java.sql.PreparedStatement pst=con.prepareStatement(sqlquery);
					 
					 pst.setString(1,userId);
						pst.setString(2,userName);
						pst.setString(3,UserCity);
						pst.setString(4,UserEmail);
						pst.setString(5,Userpass);
						pst.setString(6,UserCountry);
						
					 
					
				}catch(Exception e)
				{
					System.out.println(e);
				}
		}
		
		
		
	}

}
