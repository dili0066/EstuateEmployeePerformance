package com.Estuate.servlets;

import java.io.IOException;
import java.util.List;

import com.Estuate.Dao.*;
import com.Estuate.DaoImpl.EmployeeDAOImpl;
import com.Estuate.models.Employees;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/GetEmployee")
public class GetEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Employees> employeeList;
	private HttpSession session;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			EmployeeDAO ed = new EmployeeDAOImpl();
			employeeList = ed.getAllEmployees();
			//System.out.print(employeeList);
			session = req.getSession();
			 session.setAttribute("employeeList", employeeList);
			 resp.sendRedirect("EmployeeReport.jsp");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
    

}
