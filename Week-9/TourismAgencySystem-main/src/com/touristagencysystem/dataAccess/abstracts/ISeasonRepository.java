package com.touristagencysystem.dataAccess.abstracts;

import com.touristagencysystem.entities.concretes.Season;

import java.util.ArrayList;

public interface ISeasonRepository {
    public ArrayList<Season> getSeasonListByHotelID(int hotelID);
    public boolean addSeason(int hotelID, String seasonName, String startDate, String endDate);
}
