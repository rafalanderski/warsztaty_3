package pl.coderslab.warsztaty3.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.warsztaty3.util.DbUtil;


@WebServlet("/dbtest")
public class DbUtilTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DbUtilTest() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Connection c = DbUtil.getConn();
			
		PreparedStatement ps = c.prepareStatement("Insert into test(id,data) VALUES (default, 'someData');");
		ps.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
			}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
