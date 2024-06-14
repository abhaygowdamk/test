package com.java.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Adminlogin
 */
@WebServlet("/Adminlogin")
public class Adminlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Adminlogin() {
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

	    String id1 = request.getParameter("id");
	    String password1 = request.getParameter("password");

	    try {
	        Class.forName("org.postgresql.Driver");

	        try (Connection con = DriverManager.getConnection(url, user, password)) {
	            String sql = "SELECT * FROM admindata";

	            Statement stm = con.createStatement();
	            ResultSet rs = stm.executeQuery(sql);
	            boolean isValidUser = false;
	            
	            while (rs.next()) {
	                if (id1.equals(rs.getString(1)) && password1.equals(rs.getString(5))) {
	                    isValidUser = true;
	                    break;
	                }
	            }

	            if (isValidUser) {
	                // Retrieve total number of registered users
	                String userCountSql = "SELECT COUNT(*) AS total FROM userdetails";
	                ResultSet userCountRs = stm.executeQuery(userCountSql);
	                int totalUsers = 0;
	                if (userCountRs.next()) {
	                    totalUsers = userCountRs.getInt("total");
	                }

	                // Set totalUsers in session
	                request.getSession().setAttribute("totalUsers", totalUsers);

	                // Redirect to admin dashboard
	                response.sendRedirect("adminDashboard.jsp");
	            } else {
	                PrintWriter prt = response.getWriter();
	                prt.print("Invalid credentials");
	            }
	            

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }




		doGet(request, response);
	}

}
