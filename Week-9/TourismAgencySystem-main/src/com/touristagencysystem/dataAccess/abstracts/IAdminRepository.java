package com.touristagencysystem.dataAccess.abstracts;

import com.touristagencysystem.entities.concretes.User;

import java.util.ArrayList;

public interface IAdminRepository {
    public boolean addUser(String tcNo,String username,String password,String name,String surname,String userType);
    public boolean updateUser(int userID,String tcNo,String username,String password,String name,String surname,String userType);
    public boolean deleteUser(int userID);
    public ArrayList<User> getUserList();
}
