package com.Estuate.DaoImpl;



import com.Estuate.Dao.EmployeeDAO;
import com.Estuate.models.Employees;
import com.Estuate.DbConnection.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public int addEmployee(Employees employee) {
        String sql = "INSERT INTO employees(emp_id,emp_name,emp_email,mobile,address,password,role) values(?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, employee.getId());
            stmt.setString(2, employee.getName());
            stmt.setString(3, employee.getEmail());
            stmt.setString(4, employee.getMobile());
            stmt.setString(5, employee.getAddress());
            stmt.setString(6, employee.getPassword());
            stmt.setString(7, employee.getRole());
            
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public Employees getEmployeeById(String email) {
        String sql = "SELECT * FROM employees WHERE emp_email = ?";
        try (Connection conn = DbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Employees(
                        rs.getInt("emp_id"),
                        rs.getString("emp_name"),
                        rs.getString("emp_email"),
                        rs.getString("mobile"),
                        rs.getString("address"),
                        rs.getString("rating"),
                        rs.getString("role")
                        
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Employees> getAllEmployees() {
        List<Employees> employees = new ArrayList<>();
        String sql = "SELECT * FROM employees where role = ?";
        try {
        	Connection conn = DbConnection.connect();
        		PreparedStatement stmt = conn.prepareStatement(sql);
        		stmt.setString(1, "employee");
             ResultSet rs = stmt.executeQuery(); 
            while (rs.next()) {
                employees.add(new Employees(
                        rs.getInt("emp_id"),
                        rs.getString("emp_name"),
                        rs.getString("emp_email"),
                        rs.getString("mobile"),
                        rs.getString("address"),
                        rs.getString("rating")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public void updateEmployee(String rating,int id) {
        String sql = "UPDATE employee SET rating=? where emp_id=?";
        try (Connection conn = DbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, rating);
            stmt.setInt(2, id);
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(int empId) {
        String sql = "DELETE FROM employee WHERE emp_id = ?";
        try (Connection conn = DbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, empId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
