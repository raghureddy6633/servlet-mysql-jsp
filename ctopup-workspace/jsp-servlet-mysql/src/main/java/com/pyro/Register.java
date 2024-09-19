package com.pyro;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class Register extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		try {
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			int age = Integer.parseInt(req.getParameter("age"));
			String msisdn = req.getParameter("msisdn");
			String gender = req.getParameter("gender");
			System.out.println("gender :" + gender);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/crud-1?user=root&password=Raghu@6633");

			PreparedStatement statement = con.prepareStatement(
					"insert into user (id,name,age,msisdn,email,password,gender) values(?,?,?,?,?,?,?)");

			String id = randomId();
			statement.setInt(1, Integer.parseInt(id));
			statement.setString(2, name);
			statement.setInt(3, age);
			statement.setString(4, msisdn);

			statement.setString(5, email);
			statement.setString(6, password);
			statement.setString(7, gender);
			int result = statement.executeUpdate();
			System.err.println(result);
			if (result > 0) {
				resp.setContentType("text/html");
				out.println("<h3 style='color:green;text-align:center;'>User Registration Successfull</h3> ");
				req.getRequestDispatcher("/index.jsp").include(req, resp);
			} else {
				resp.setContentType("text/html");
				out.println("<h3 style='color:red;text-align:center;'>User Registration Failed</h3> ");
				req.getRequestDispatcher("/index.jsp").include(req, resp);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			resp.setContentType("text/html");
			out.println("<h3 style='color:red;text-align:center;'>User Registration '" + e.getMessage() + "'</h3> ");
			req.getRequestDispatcher("/index.jsp").include(req, resp);
		}

	}

	public String randomId() {

		StringBuilder builder = new StringBuilder();
		String id = "0123456789";
		Random random = new Random();

		// Generate random characters for the password
		for (int i = 0; i < 6; i++) {
			int randomIndex = random.nextInt(id.length());
			char randomChar = id.charAt(randomIndex);
			builder.append(randomChar);
		}

		return builder.toString();

	}

}
