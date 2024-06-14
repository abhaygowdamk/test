package com.java.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class userpasswordupdate
 */
@WebServlet("/userpasswordupdate")
public class userpasswordupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userpasswordupdate() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "jdbc:postgresql://localhost:5432/FestManagement";
		String user = "postgres";
		String password = "root";
		String sql = "UPDATE userlogin SET password=? WHERE email=?";
		String email = request.getParameter("email");
		String Npassword = request.getParameter("Npassword");
		String Cpassword = request.getParameter("Cpassword");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		if (Npassword == null || Cpassword == null || email == null || !Npassword.equals(Cpassword)) {
			out.println("Passwords do not match or email is missing.");
			return;
		}

		try {
			Class.forName("org.postgresql.Driver");

			try (Connection con = DriverManager.getConnection(url, user, password)) {
				PreparedStatement pr = con.prepareStatement(sql);
				pr.setString(1, Npassword); 
				pr.setString(2, email);

				int result = pr.executeUpdate();
				if (result > 0) {
					out.println("Password update successful.");
				} else {
					out.println("Password update failed. User not found.");
				}
			} catch (SQLException e) {
				e.printStackTrace();
				out.println(e.getMessage());
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			out.println(e.getMessage());
		}
	}
}
