package com.touristagencysystem.business.concretes;

import com.touristagencysystem.business.abstracts.ISeasonService;
import com.touristagencysystem.dataAccess.abstracts.IEmployeeDetailRepository;
import com.touristagencysystem.dataAccess.concretes.MysqlEmployeeHotelDetailRepository;
import com.touristagencysystem.entities.concretes.*;

import java.util.ArrayList;

public class EmployeeHotelDetailManager implements ISeasonService,IEmployeeDetailRepository {
    private IEmployeeDetailRepository detailRepository = new MysqlEmployeeHotelDetailRepository();
    @Override
    public ArrayList<Season> getSeasonListByHotelID(int hotelID) {
        return detailRepository.getSeasonListByHotelID(hotelID);
    }

    @Override
    public boolean addSeason(int hotelID, String seasonName, String startDate, String endDate) {
        return detailRepository.addSeason(hotelID,seasonName,startDate,endDate);
    }

    @Override
    public ArrayList<Pension> getPensionList(int hotelID) {
        return detailRepository.getPensionList(hotelID);
    }

    @Override
    public ArrayList<Pension> getPensionTypeList() {
        return detailRepository.getPensionTypeList();
    }

    @Override
    public boolean addPensiontoHotel(int hotelID, int pensionID, String pensionName) {
        return detailRepository.addPensiontoHotel(hotelID,pensionID,pensionName);
    }

    @Override
    public ArrayList<HotelFeature> getHotelFeaturesList() {
        return detailRepository.getHotelFeaturesList();
    }

    @Override
    public boolean addHotelFeature(int hotelID,int featureID ,String featuretoAdd) {
        return detailRepository.addHotelFeature(hotelID,featureID,featuretoAdd);
    }

    @Override
    public boolean addHotelRoom(int hotelID, int seasonID, int pensionID, String roomType, int bedNumber, int stock, int priceChildren,int priceAdult) {
        return detailRepository.addHotelRoom(hotelID,seasonID,pensionID,roomType,bedNumber,stock,priceChildren,priceAdult);
    }

    @Override
    public ArrayList<HotelFeature> getHotelFeatureListByID(int hotelID) {
        return detailRepository.getHotelFeatureListByID(hotelID);
    }

    @Override
    public ArrayList<Room> getHotelRoomListByID(int hotelID) {
        return detailRepository.getHotelRoomListByID(hotelID);
    }

    @Override
    public String getSeasonNameByID(int seasonID) {
        return detailRepository.getSeasonNameByID(seasonID);
    }

    @Override
    public String getPensionNameByID(int pensionID) {
        return detailRepository.getPensionNameByID(pensionID);
    }

    @Override
    public boolean addHotelRoomProperty(int roomID, String roomProperty) {
        return detailRepository.addHotelRoomProperty(roomID,roomProperty);
    }

    @Override
    public ArrayList<RoomFeature> getRoomFeatureList(int roomID) {
        return detailRepository.getRoomFeatureList(roomID);
    }

    @Override
    public boolean updateRoomInfo(String roomType, int bedNumber, int stock, int priceChild, int priceAdult) {
        return detailRepository.updateRoomInfo(roomType,bedNumber,stock,priceChild,priceAdult);
    }

    @Override
    public boolean deleteRoom(int roomID) {
        return detailRepository.deleteRoom(roomID);
    }

    @Override
    public boolean deleteSeason(int seasonID) {
        return detailRepository.deleteSeason(seasonID);
    }

    @Override
    public boolean deleteHotelFeature(int hotelID, String featureName) {
        return detailRepository.deleteHotelFeature(hotelID,featureName);
    }

    @Override
    public boolean deleteHotelPension(int pensionID) {
        return detailRepository.deleteHotelPension(pensionID);
    }

    @Override
    public boolean deleteRoomProperty(int roomID, String property) {
        return detailRepository.deleteRoomProperty(roomID,property);
    }

}
