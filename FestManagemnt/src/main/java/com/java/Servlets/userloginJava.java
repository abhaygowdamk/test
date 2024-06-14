package com.java.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class userloginJava
 */
@WebServlet("/userloginJava")
public class userloginJava extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userloginJava() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String url="jdbc:postgresql://localhost:5432/FestManagement";
		String user ="postgres";
		String password="root";
		
		String email = request.getParameter("email");
		String password1 = request.getParameter("password");
		
		try {
			Class.forName("org.postgresql.Driver");
			
			try {
				Connection con = DriverManager.getConnection(url, user, password);
				String sql = "SELECT * FROM userdetails";
				
				Statement stm = con.createStatement();
				
				ResultSet rs = stm.executeQuery(sql);
				while(rs.next()){
					rs.getString(1);
					rs.getString(4);
					
					if(email.equals(rs.getString(3)) && password1.equals(rs.getString(5))) {
						System.out.println("Login Successfull");
					}
					
				}
				
					
				PrintWriter prt=response.getWriter();
				prt.print("login succesfull");
				} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		doGet(request, response);
	}

}
