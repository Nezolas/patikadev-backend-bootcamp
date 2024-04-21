package com.touristagencysystem.dataAccess.abstracts;

import com.touristagencysystem.entities.concretes.HotelFeature;
import com.touristagencysystem.entities.concretes.Room;
import com.touristagencysystem.entities.concretes.RoomFeature;

import java.util.ArrayList;

public interface IEmployeeDetailRepository extends ISeasonRepository,IPensionRepository{
    public ArrayList<HotelFeature> getHotelFeaturesList();
    public boolean addHotelFeature(int hotelID,int featureID ,String featuretoAdd);
    public boolean addHotelRoom(int hotelID, int seasonID, int pensionID, String roomType, int bedNumber, int stock, int priceChildren,int priceAdult);
    public ArrayList<HotelFeature> getHotelFeatureListByID(int hotelID);
    public ArrayList<Room> getHotelRoomListByID(int hotelID);
    public String getSeasonNameByID(int seasonID);
    public String getPensionNameByID(int pensionID);
    public boolean addHotelRoomProperty(int roomID,String roomProperty);
    public ArrayList<RoomFeature> getRoomFeatureList(int roomID);
    public boolean updateRoomInfo(String roomType,int bedNumber,int stock,int priceChild,int priceAdult);
    public boolean deleteRoom(int roomID);
    public boolean deleteSeason(int seasonID);
    public boolean deleteHotelFeature(int hotelID,String featureName);
    public boolean deleteHotelPension(int pensionID);
    public boolean deleteRoomProperty(int roomID,String property);

}
