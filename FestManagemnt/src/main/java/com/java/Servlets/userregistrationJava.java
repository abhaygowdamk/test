package com.java.Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class userregistrationJava
 */
@WebServlet("/userregistrationJava")
public class userregistrationJava extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userregistrationJava() {
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
		String url = "jdbc:postgresql://localhost:5432/FestManagement";
        String user = "postgres";
        String password = "root";

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String passwordValue = request.getParameter("password");

        String sql = "INSERT INTO userdetails(email3, name3, phone3, password3) VALUES (?, ?, ?, ?)";
        
        try {
			Class.forName("org.postgresql.Driver");
			try {
				Connection con = DriverManager.getConnection(url, user, password);
				 PreparedStatement ps = con.prepareStatement(sql);
			            ps.setString(1, email);
			            ps.setString(2, name);
			            ps.setString(3, phone);
			            ps.setString(4, passwordValue);
			            
			           ps.execute();
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
