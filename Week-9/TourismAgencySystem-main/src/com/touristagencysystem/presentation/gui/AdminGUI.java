package com.touristagencysystem.presentation.gui;

import com.touristagencysystem.business.concretes.AdminManager;
import com.touristagencysystem.business.concretes.LoginManager;
import com.touristagencysystem.core.Notify;
import com.touristagencysystem.dataAccess.concretes.MysqlLoginRepository;
import com.touristagencysystem.entities.concretes.Hotel;
import com.touristagencysystem.entities.concretes.User;
import com.touristagencysystem.presentation.gui.abstracts.Layout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class AdminGUI extends Layout {
    private AdminManager adminManager = new AdminManager();
    private JPanel wrapper;
    private JTabbedPane tabbedPane1;
    private JTable tbl_personel;
    private DefaultTableModel mdl_personel;
    private Object[] row_personel;
    private JTextField txt_tc;
    private JTextField txt_userName;
    private JTextField txt_name;
    private JTextField txt_surname;
    private JComboBox cmb_userType;
    private JButton btn_addUser;
    private JTextField txt_password;
    private User admin;
    public AdminGUI(User admin){
        this.admin = admin;
        add(wrapper);
        setGUILayout(800,500);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                LoginGUI backToLogin = new LoginGUI(new LoginManager(new MysqlLoginRepository()));
            }
        });
        mdl_personel = new DefaultTableModel();
        mdl_personel.setColumnIdentifiers(new Object[]{"User ID","TC","Kullanıcı Adı","Şifre","İsim","Soyisim","Kullanıcı Tipi"});
        row_personel = new Object[7];
        tbl_personel.setModel(mdl_personel);
        tbl_personel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                tbl_personel.setRowSelectionInterval(tbl_personel.rowAtPoint(e.getPoint()), tbl_personel.rowAtPoint(e.getPoint()));
            }
        });
        loadPersonelTable();
        JPopupMenu tbl_personel_popup = new JPopupMenu();
        tbl_personel_popup.add("Güncelle").addActionListener(e ->{
            if(adminManager.updateUser(
                    Integer.parseInt(tbl_personel.getValueAt(tbl_personel.getSelectedRow(),0).toString()),
                    tbl_personel.getValueAt(tbl_personel.getSelectedRow(),1).toString(),
                    tbl_personel.getValueAt(tbl_personel.getSelectedRow(),2).toString(),
                    tbl_personel.getValueAt(tbl_personel.getSelectedRow(),3).toString(),
                    tbl_personel.getValueAt(tbl_personel.getSelectedRow(),4).toString(),
                    tbl_personel.getValueAt(tbl_personel.getSelectedRow(),5).toString(),
                    cmb_userType.getSelectedItem().toString()
            )){
                loadPersonelTable();
                Notify.showMsg("Başarılı","Kullanıcı bilgileri güncellendi");
            }else {Notify.showMsg("Hata","Kullanıcı bilgileri güncellenirken bir hata oluştu");}
        });
        tbl_personel_popup.add("Sil").addActionListener(e ->{
            if(adminManager.deleteUser(Integer.parseInt(tbl_personel.getValueAt(tbl_personel.getSelectedRow(),0).toString()))){
                loadPersonelTable();
                Notify.showMsg("Başarılı","Kullanıcı silindi");
            }else {Notify.showMsg("Hata","Kullanıcı silinirken bir hata oluştu");}
        });
        tbl_personel.setComponentPopupMenu(tbl_personel_popup);


        btn_addUser.addActionListener(e -> {
            if(Notify.isFieldEmpty(txt_tc) || Notify.isFieldEmpty(txt_userName) || Notify.isFieldEmpty(txt_password)|| Notify.isFieldEmpty(txt_name)||Notify.isFieldEmpty(txt_surname)){
                Notify.showMsg("Uyarı","Alanları eksiksiz doldurunuz");
            }else{
                if(adminManager.addUser(
                        txt_tc.getText(),
                        txt_userName.getText(),
                        txt_password.getText(),
                        txt_name.getText(),
                        txt_surname.getText(),
                        cmb_userType.getSelectedItem().toString()
                )){
                    loadPersonelTable();
                    Notify.showMsg("Başarılı","Kullanıcı eklendi");
                }
            }
        });
    }

    private void loadPersonelTable(){
        DefaultTableModel db = (DefaultTableModel) tbl_personel.getModel();
        db.setRowCount(0);
        for(User user : adminManager.getUserList()){
            row_personel[0] = user.getUserID();
            row_personel[1] = user.getTcNo();
            row_personel[2] = user.getUsername();
            row_personel[3] = user.getPassword();
            row_personel[4] = user.getName();
            row_personel[5] = user.getSurname();
            row_personel[6] = user.getUserType();
            mdl_personel.addRow(row_personel);
        }
    }
}
