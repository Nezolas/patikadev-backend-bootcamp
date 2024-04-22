package com.touristagencysystem.business.abstracts;

import com.touristagencysystem.entities.concretes.Hotel;

import java.util.ArrayList;

public interface IHotelService {
    public ArrayList<Hotel> getHotelList();
    public Hotel getHotelByID(int hotelID);
    public boolean addHotel(String hotelName,String city,String region,String address, String hotelEmail, String hotelPhone, int star);
    public boolean updateHotel(int hotelID,String hotelName,String city,String region,String address, String hotelEmail, String hotelPhone, int star);
}
