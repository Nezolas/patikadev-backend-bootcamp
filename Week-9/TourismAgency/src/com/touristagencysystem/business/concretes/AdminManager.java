package com.touristagencysystem.business.concretes;

import com.touristagencysystem.business.abstracts.IUserService;
import com.touristagencysystem.dataAccess.abstracts.IAdminRepository;
import com.touristagencysystem.dataAccess.abstracts.IUserRepository;
import com.touristagencysystem.dataAccess.concretes.MysqlAdminRepository;
import com.touristagencysystem.entities.concretes.User;

import java.util.ArrayList;

public class AdminManager implements IAdminRepository {
    private final IAdminRepository adminRepository;
    public AdminManager(){
        this.adminRepository = new MysqlAdminRepository();
    }

    @Override
    public boolean addUser(String tcNo, String username, String password, String name, String surname, String userType) {
        return adminRepository.addUser(tcNo,username,password,name,surname,userType);
    }

    @Override
    public boolean updateUser(int userID,String tcNo, String username, String password, String name, String surname, String userType) {
        return adminRepository.updateUser(userID,tcNo,username,password,name,surname,userType);
    }

    @Override
    public boolean deleteUser(int userID) {
        return adminRepository.deleteUser(userID);
    }

    @Override
    public ArrayList<User> getUserList() {
        return adminRepository.getUserList();
    }
}
