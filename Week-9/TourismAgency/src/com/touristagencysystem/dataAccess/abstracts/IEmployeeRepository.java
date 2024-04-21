package com.touristagencysystem.dataAccess.abstracts;

import com.touristagencysystem.entities.concretes.Reservation;
import com.touristagencysystem.entities.concretes.Hotel;
import com.touristagencysystem.entities.concretes.HotelFeature;
import com.touristagencysystem.entities.concretes.RoomFeature;
import com.touristagencysystem.entities.concretes.SearchResult;

import java.util.ArrayList;

public interface IEmployeeRepository{
    public ArrayList<Hotel> getHotelList();
    public Hotel getHotelByID(int hotelID);
    public boolean addHotel(String hotelName,String city,String region,String address, String hotelEmail, String hotelPhone, int star);
    public boolean updateHotel(int hotelID,String hotelName,String city,String region,String address, String hotelEmail, String hotelPhone, int star);
    public boolean deleteHotel(int hotelID);
    public String searchQuery(String city,String region,String hotelName,String startDate,String endDate,int bedCount);
    public ArrayList<SearchResult> search(String query);
    public ArrayList<HotelFeature> getHotelFeatures(int hotelID);
    public ArrayList<RoomFeature> getRoomFeatures(int roomID);
    public boolean addReservation(int hotelID,int roomID,String customerName,String customerTc,String customerPhone,String customerEmail,int childNumber,int adultNumber);
    public boolean decreaseStock(int roomID);
    public boolean increaseStock(int roomID);
    public ArrayList<Reservation> getReservationList();
    public boolean updateReservation(int reservationID,String customerName,String customerTc,String customerPhone,String customerEmail,int childNumber,int adultNumber);
    public boolean deleteReservation(int reservationID);

    public void deleteRoomByHotelID(int hotelID);
    public void deleteSeasonByHotelID(int hotelID);
}
