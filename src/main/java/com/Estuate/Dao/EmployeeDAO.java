package com.Estuate.Dao;



import com.Estuate.models.Employees;
import java.util.List;

public interface EmployeeDAO {
    int addEmployee(Employees employee);
    Employees getEmployeeById(String email);
    List<Employees> getAllEmployees();
    void updateEmployee(String rating,int id);
    void deleteEmployee(int empId);
}

