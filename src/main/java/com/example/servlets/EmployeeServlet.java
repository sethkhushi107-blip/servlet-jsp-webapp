package com.example.servlets;

import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class EmployeeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String empid = request.getParameter("empid");

        out.println("<h2>Employee Records</h2>");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/company", "root", "root");

            Statement stmt = con.createStatement();
            String query = (empid != null && !empid.equals(""))
                    ? "SELECT * FROM Employee WHERE EmpID=" + empid
                    : "SELECT * FROM Employee";

            ResultSet rs = stmt.executeQuery(query);

            out.println("<table border='1'><tr><th>ID</th><th>Name</th><th>Salary</th></tr>");
            while (rs.next()) {
                out.println("<tr><td>" + rs.getInt(1) + "</td><td>" +
                        rs.getString(2) + "</td><td>" + rs.getDouble(3) + "</td></tr>");
            }
            out.println("</table>");

            con.close();

        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }
}
