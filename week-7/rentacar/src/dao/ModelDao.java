package dao;

import core.Db;
import entity.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModelDao {
    private Connection con;
    private final BrandDao brandDao = new BrandDao();

    public ModelDao() {
        this.con = Db.getInstance();
    }

    public Model getById(int id) {
        Model obj = null;
        String query = "SELECT * FROM public.model WHERE model_id = ?";
        try {
            PreparedStatement pr = con.prepareStatement(query);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) obj = this.match(rs);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return obj;
    }

    public ArrayList<Model> findAll() {
        return this.selectByQuery("SELECT * FROM public.model ORDER BY model_id ASC");
    }

    public ArrayList<Model> getByListBrandId(int brandId) {
        return this.selectByQuery("SELECT * FROM public.model WHERE model_brand_id = " + brandId);
    }


    public ArrayList<Model> selectByQuery(String query) {
        ArrayList<Model> modelList = new ArrayList<>();
        try {
            ResultSet rs = this.con.createStatement().executeQuery(query);
            while (rs.next()) {
                modelList.add(this.match(rs));
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return modelList;
    }

    public boolean save(Model model) {
        String query = "INSERT INTO public.model " +
                "(" +
                "model_brand_id," +
                "model_name," +
                "model_type," +
                "model_year," +
                "model_fuel," +
                "model_gear" +
                ")" +
                " VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement pr = con.prepareStatement(query);
            pr.setInt(1, model.getBrand_id());
            pr.setString(2, model.getName());
            pr.setString(3, model.getType().toString());
            pr.setString(4, model.getYear());
            pr.setString(5, model.getFuel().toString());
            pr.setString(6, model.getGear().toString());
            return pr.executeUpdate() != -1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }

    public boolean update(Model model) {
        String query = "UPDATE public.model SET " +
                "model_brand_id = ? , " +
                "model_name = ? , " +
                "model_type = ? , " +
                "model_year = ? , " +
                "model_fuel = ? , " +
                "model_gear = ? " +
                "WHERE model_id = ?";
        try {
            PreparedStatement pr = con.prepareStatement(query);
            pr.setInt(1, model.getBrand_id());
            pr.setString(2, model.getName());
            pr.setString(3, model.getType().toString());
            pr.setString(4, model.getYear());
            pr.setString(5, model.getFuel().toString());
            pr.setString(6, model.getGear().toString());
            pr.setInt(7, model.getId());
            return pr.executeUpdate() != -1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }

    public boolean delete(int model_id) {
        String query = "DELETE FROM public.model WHERE model_id = ?";
        try {
            PreparedStatement pr = con.prepareStatement(query);
            pr.setInt(1, model_id);
            return pr.executeUpdate() != -1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }


    public Model match(ResultSet rs) throws SQLException {
        Model model = new Model();
        model.setId(rs.getInt("model_id"));
        model.setName(rs.getString("model_name"));
        model.setFuel(Model.Fuel.valueOf(rs.getString("model_fuel")));
        model.setGear(Model.Gear.valueOf(rs.getString("model_gear")));
        model.setType(Model.Type.valueOf(rs.getString("model_type")));
        model.setYear(rs.getString("model_year"));
        model.setBrand(this.brandDao.getById(rs.getInt("model_brand_id")));
        model.setBrand_id(rs.getInt("model_brand_id"));
        return model;
    }
}
