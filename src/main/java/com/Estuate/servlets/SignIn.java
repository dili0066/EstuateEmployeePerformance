package com.Estuate.servlets;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import com.Estuate.Dao.*;
import com.Estuate.DaoImpl.*;
import com.Estuate.models.Employees;


@WebServlet("/SignIn")
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;
	private String role1 = "Employee";
	private String role2 = "HR Manager";
	private String role3 = "Team Manager";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uemail = req.getParameter("email");
		String password = req.getParameter("password");
		System.out.println(uemail);
		EmployeeDAO emp = new EmployeeDAOImpl ();
		Employees e = emp.getEmployeeById(uemail);
		System.out.println(e.getEmail());
		if( e!=null && uemail.equals(e.getEmail()) && e.getEmail()!=null) {
			System.out.print(e.getEmail());
	
				System.out.print(e.getName());
				if(e.getRole().equalsIgnoreCase(role1)) {
					int userId = e.getId();
					String name = e.getName();
					String mobile = e.getMobile();
					String email = uemail;
					String address = e.getAddress();
					//Cookie ck = new Cookie("email",uemail);
					//resp.addCookie(ck);
					session = req.getSession();
					session.setAttribute("empId", userId);
					session.setAttribute("name", name);
					session.setAttribute("mobile", mobile);
					session.setAttribute("email", email);
					session.setAttribute("address", address);
					
					req.getRequestDispatcher("GetProfile").forward(req, resp);
				
				}
				else if(e.getRole().equalsIgnoreCase(role2)) {
					System.out.print(e.getRole());
					int userId = e.getId();
					String name = e.getName();
					String mobile = e.getMobile();
					String email = uemail;
					String address = e.getAddress();
					//Cookie ck = new Cookie("email",uemail);
					//resp.addCookie(ck);
					session = req.getSession();
					session.setAttribute("empId", userId);
					session.setAttribute("name", name);
					session.setAttribute("mobile", mobile);
					session.setAttribute("email", email);
					session.setAttribute("address", address);
					req.getRequestDispatcher("GetEmployee").forward(req, resp);
					
				}
				else {
				System.out.print(e.getRole());
				int userId = e.getId();
				String name = e.getName();
				String mobile = e.getMobile();
				String email = uemail;
				String address = e.getAddress();
				//Cookie ck = new Cookie("email",uemail);
				//resp.addCookie(ck);
				session = req.getSession();
				session.setAttribute("empId", userId);
				session.setAttribute("name", name);
				session.setAttribute("mobile", mobile);
				session.setAttribute("email", email);
				session.setAttribute("address", address);
				req.getRequestDispatcher("GetEmployee").forward(req, resp);
				
			}
			}
			
			else {
				resp.getWriter().println(e.getPassword());
			}
			
		}
		
		
	}
    
