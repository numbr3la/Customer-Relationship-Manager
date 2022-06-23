/**
 * Db Connection Test
 * Author: numbr3la
 */
package com.numbr3la.testdb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String user = "springapp";
        String pass = "springapp";
        String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";

        String driver = "com.mysql.cj.jdbc.Driver";
        try {

            PrintWriter out = response.getWriter();
            out.println("Connecting to database: " + jdbcUrl);
            Class.forName(driver);

            Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);

            out.println("Connected with database.");
            myConn.close();

        } catch (Exception e)
        {
            e.printStackTrace();
            throw new ServletException(e);
        }

    }
}