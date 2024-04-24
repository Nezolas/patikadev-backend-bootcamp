package com.touristagencysystem.dataAccess.concretes;

import com.touristagencysystem.core.DBConnector;
import com.touristagencysystem.dataAccess.abstracts.IUserRepository;
import com.touristagencysystem.entities.concretes.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlUserRepository implements IUserRepository {
    public int login(String username_tcno, String password) {
        String query = "SELECT * FROM tbl_user WHERE ((tcNo=? OR username=?) AND password=?)";
        try(PreparedStatement ps = DBConnector.getPreparedStatement(query)){
            ps.setString(1,username_tcno);
            ps.setString(2,username_tcno);
            ps.setString(3,password);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return rs.getInt("id");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }
    public User getUserByID(int id){
        User user = null;
        String query = "SELECT * FROM tbl_user WHERE id="+id;
        try(PreparedStatement ps = DBConnector.getPreparedStatement(query)){
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                user = match(rs);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }
    private User match(ResultSet rs) throws SQLException {
        return new User(rs.getInt("id"),
                rs.getString("tcNo"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("name"),
                rs.getString("surname"),
                rs.getString("usertype"));
    }
}