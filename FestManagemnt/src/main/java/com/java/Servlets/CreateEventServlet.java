package com.java.Servlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateEventServlet
 */
@WebServlet("/CreateEventServlet")
public class CreateEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateEventServlet() {
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
        
        String eventid = request.getParameter("id");
        String eventName = request.getParameter("name");
        String eventDate = request.getParameter("date");
        String eventTime = request.getParameter("time");
        String eventVenue = request.getParameter("venue");
        String eventPrice = request.getParameter("price");

        try {
            Class.forName("org.postgresql.Driver");

            try (Connection con = DriverManager.getConnection(url, user, password)) {
                String sql = "INSERT INTO events (event_id, event_name, event_date, event_time, event_venue, event_price) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = con.prepareStatement(sql);
                
                ps.setString(1, eventid);
                ps.setString(2, eventName);
                ps.setDate(3, Date.valueOf(eventDate));
                ps.setTime(4, Time.valueOf(eventTime + ":00"));  
                ps.setString(5, eventVenue);
                ps.setBigDecimal(6, new BigDecimal(eventPrice));

                int result = ps.executeUpdate();

                if (result > 0) {
                    response.getWriter().println("Event created successfully!");
                } else {
                    response.getWriter().println("Failed to create event.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                response.getWriter().println("Database error: " + e.getMessage());
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            response.getWriter().println("Driver not found: " + e.getMessage());
        }

		doGet(request, response);
	}

}
