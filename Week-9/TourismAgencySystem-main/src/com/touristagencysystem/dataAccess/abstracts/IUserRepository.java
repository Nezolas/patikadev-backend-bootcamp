package com.touristagencysystem.dataAccess.abstracts;

import com.touristagencysystem.entities.concretes.User;

public interface IUserRepository {
    public int login(String username_tcno, String password);
    public User getUserByID(int id);
}
