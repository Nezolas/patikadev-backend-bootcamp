package com.touristagencysystem.business.abstracts;

import com.touristagencysystem.entities.concretes.Season;

import java.util.ArrayList;

public interface ISeasonService {
    public ArrayList<Season> getSeasonListByHotelID(int hotelID);
    public boolean addSeason(int hotelID, String seasonName, String startDate, String endDate);
}
