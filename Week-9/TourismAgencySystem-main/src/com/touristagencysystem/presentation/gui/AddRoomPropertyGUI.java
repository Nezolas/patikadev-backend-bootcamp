package com.touristagencysystem.presentation.gui;

import com.touristagencysystem.business.concretes.EmployeeHotelDetailManager;
import com.touristagencysystem.core.Notify;
import com.touristagencysystem.entities.concretes.Room;
import com.touristagencysystem.entities.concretes.RoomFeature;
import com.touristagencysystem.presentation.gui.abstracts.Layout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddRoomPropertyGUI extends Layout {
    private JPanel wrapper;
    private JTextField txt_room_property;
    private JButton btn_addRoomFeature;
    private EmployeeHotelDetailManager detailManager;
    private JTable tbl_room_property;
    private DefaultTableModel mdl_room_property;
    private Object[] row_room_property;
    int roomID;
    public AddRoomPropertyGUI(EmployeeHotelDetailManager detailManager, int roomID){
        this.detailManager = detailManager;
        this.roomID = roomID;
        add(wrapper);
        setGUILayout(400,400);

        mdl_room_property = new DefaultTableModel();
        mdl_room_property.setColumnIdentifiers(new Object[]{"Özellik"});
        row_room_property = new Object[1];
        tbl_room_property.setModel(mdl_room_property);
        tbl_room_property.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                tbl_room_property.setRowSelectionInterval(tbl_room_property.rowAtPoint(e.getPoint()), tbl_room_property.rowAtPoint(e.getPoint()));
            }
        });
        JPopupMenu popup = new JPopupMenu();
        popup.add("Sil").addActionListener(e ->{
            detailManager.deleteRoomProperty(
                    roomID,
                    tbl_room_property.getValueAt(tbl_room_property.getSelectedRow(),0).toString());
            loadRoomPropertyList();
        });
        tbl_room_property.setComponentPopupMenu(popup);
        loadRoomPropertyList();


        btn_addRoomFeature.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Notify.isFieldEmpty(txt_room_property)){
                    Notify.showMsg("Uyarı","Eksik doldurdunuz!");
                }else{
                    if(detailManager.addHotelRoomProperty(roomID,txt_room_property.getText())){
                        loadRoomPropertyList();
                        Notify.showMsg("Başarılı","Ekleme işlemi başarılı");
                    }
                }
            }
        });
    }

    private void loadRoomPropertyList(){
        DefaultTableModel db = (DefaultTableModel) tbl_room_property.getModel();
        db.setRowCount(0);
        for(RoomFeature feature : detailManager.getRoomFeatureList(roomID)){
            row_room_property[0] =feature.getFeatureName();
            mdl_room_property.addRow(row_room_property);
        }
    }
}
