package com.Estuate.servlets;

import java.io.IOException;

import com.Estuate.models.Employees;
import com.Estuate.Dao.EmployeeDAO;
import com.Estuate.DaoImpl.EmployeeDAOImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int ID = Integer.parseInt(req.getParameter("empID"));
		String name = req.getParameter("username");
		String email = req.getParameter("email");
		String mobile = req.getParameter("mobile");
		String address = req.getParameter("address");
		String password = req.getParameter("password");
		String role = req.getParameter("role");
		Employees em = new Employees(ID,name,mobile,email,address,password);
		EmployeeDAO ei = new EmployeeDAOImpl();
		
		
		 if(ei.addEmployee(em)!=0) {
			 resp.sendRedirect("Login.html");
		 }
		 else {
			 resp.sendRedirect("ReFailure.html");
		 }
	}

}
