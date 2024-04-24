package com.touristagencysystem.presentation.gui;

import com.touristagencysystem.core.Notify;
import com.touristagencysystem.dataAccess.abstracts.IEmployeeRepository;
import com.touristagencysystem.presentation.gui.abstracts.Layout;

import javax.swing.*;

public class ReservationGUI extends Layout {
    private IEmployeeRepository repository;
    private JPanel wrapper;
    private JTextField txt_customerName;
    private JTextField txt_customerTcNo;
    private JTextField txt_customerPhone;
    private JTextField txt_customerEmail;
    private JButton btn_reservation;
    private JLabel txt_totalPrice;

    public ReservationGUI(EmployeeGUI gui,IEmployeeRepository repository, int hotelID, int roomID, int childNumber, int adultNumber,int totalPrice) {
        add(wrapper);
        setGUILayout(500,500);
        this.repository = repository;
        txt_totalPrice.setText(String.valueOf(totalPrice));

        // Değerlendirme Formu 18
        btn_reservation.addActionListener(e -> {
            if(Notify.isFieldEmpty(txt_customerName) || Notify.isFieldEmpty(txt_customerTcNo) || Notify.isFieldEmpty(txt_customerPhone) || Notify.isFieldEmpty(txt_customerEmail)){
                Notify.showMsg("Uyarı","Lütfen Bilgilerinizi Eksiksiz Doldurunuz");
            }else{
                if(repository.addReservation(
                        hotelID,
                        roomID,
                        txt_customerName.getText(),
                        txt_customerTcNo.getText(),
                        txt_customerPhone.getText(),
                        txt_customerEmail.getText(),
                        childNumber,
                        adultNumber)){
                    // Değerlendirme Formu 19
                    repository.decreaseStock(roomID);
                    gui.loadRezervationList();
                    Notify.showMsg("Başarılı","Rezervasyon Yapıldı");
                }
            }
        });
    }
}
