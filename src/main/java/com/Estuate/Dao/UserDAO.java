package com.Estuate.Dao;



import com.Estuate.models.*;
import java.util.List;

public interface UserDAO {
    void addUser(Users user);
    Users getUserByUsername(String username);
    List<Users> getAllUsers();
    void updateUser(Users user);
    void deleteUser(String username);
}

