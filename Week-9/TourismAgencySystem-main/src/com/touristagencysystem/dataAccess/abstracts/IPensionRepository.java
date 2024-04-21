package com.touristagencysystem.dataAccess.abstracts;

import com.touristagencysystem.entities.concretes.Pension;

import java.util.ArrayList;

public interface IPensionRepository {
    public ArrayList<Pension> getPensionList(int hotelID);
    public ArrayList<Pension> getPensionTypeList();
    public boolean addPensiontoHotel(int hotelID,int pensionID,String pensionName);
}
