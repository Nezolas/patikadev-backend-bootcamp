package com.touristagencysystem.presentation.gui;

import com.touristagencysystem.business.concretes.EmployeeManager;
import com.touristagencysystem.business.concretes.LoginManager;
import com.touristagencysystem.core.Notify;
import com.touristagencysystem.entities.concretes.Reservation;
import com.touristagencysystem.dataAccess.concretes.MysqlLoginRepository;
import com.touristagencysystem.entities.concretes.*;
import com.touristagencysystem.presentation.gui.abstracts.Layout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;

public class EmployeeGUI extends Layout {
    private final EmployeeManager employeeManager = new EmployeeManager();
    private JPanel wrapper;
    private JTabbedPane tabbedPane1;
    private User employee;

    // Hotel Panel - START
    private JPanel pnl_hotel;
    private JTable tbl_hotel;
    private JTextField txt_hotel_name;
    private JTextField txt_hotel_email;
    private JTextField txt_hotel_phoneNumber;
    private JButton btn_addHotel;
    private JComboBox cmb_hotel_star;
    private JPanel pnl_bottom;
    private JTextField txt_city;
    private JTextField txt_startDate;
    private JTextField txt_endDate;
    private JComboBox cmb_childNumber;
    private JComboBox cmb_adultNumber;
    private JButton btn_search;
    DefaultTableModel mdl_hotel_list;
    private Object[] row_hotel_list;
    private JPopupMenu tbl_hotel_PopupMenu;
    // Hotel Panel - END
    private JTable tbl_search;
    private JTextArea txtA_hotelFeatures;
    private JTextArea txtA_roomFeatures;
    DefaultTableModel mdl_search;
    private Object[] row_search;

    private JTable tbl_rezervations;
    private JTextField txt_addcity;
    private JTextField txt_region;
    private JTextField txt_address;
    DefaultTableModel mdl_rezervations;
    private Object[] row_rezervations;


    public EmployeeGUI(User employee) {
        this.employee = employee;
        add(wrapper);
        setGUILayout(1300,500);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                LoginGUI backToLogin = new LoginGUI(new LoginManager(new MysqlLoginRepository()));
            }
        });
        // Hotel Table - START
        mdl_hotel_list = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                if(column == 0){return false;}
                return super.isCellEditable(row, column);
            }
        };
        Object[] col_hotel_list = {"ID","Otel İsmi","Şehir","İlçe","Adres","Email","Telefon Numarası","Yıldız"};
        mdl_hotel_list.setColumnIdentifiers(col_hotel_list);
        row_hotel_list = new Object[col_hotel_list.length];
        tbl_hotel.setModel(mdl_hotel_list);
        //tbl_hotel.getTableHeader().setReorderingAllowed(false);

        tbl_hotel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                tbl_hotel.setRowSelectionInterval(tbl_hotel.rowAtPoint(e.getPoint()),tbl_hotel.rowAtPoint(e.getPoint()));
            }
        });
        tbl_hotel_PopupMenu = new JPopupMenu();
        tbl_hotel_PopupMenu.add("Yönet").addActionListener(e -> {
            int selectedHotelID = Integer.parseInt(tbl_hotel.getValueAt(tbl_hotel.getSelectedRow(),0).toString());
            EmployeeHotelDetailGUI detailGUI = new EmployeeHotelDetailGUI(employeeManager.getHotelByID(selectedHotelID));
            // Otel detayları (Tesis özelliği,pansiyon tipi ekleme/silme işlemleri) ve Oda işlemleri gibi şeyler bu gui de
        });
        tbl_hotel_PopupMenu.add("Güncelle").addActionListener(e -> {
            // Otel bilgilerini güncelle
            if(tbl_hotel.getCellEditor() != null){
                tbl_hotel.getCellEditor().stopCellEditing();
                if(employeeManager.updateHotel(
                        Integer.parseInt(tbl_hotel.getValueAt(tbl_hotel.getSelectedRow(),0).toString()),
                        (String) tbl_hotel.getValueAt(tbl_hotel.getSelectedRow(),1),
                        (String) tbl_hotel.getValueAt(tbl_hotel.getSelectedRow(),2),
                        (String) tbl_hotel.getValueAt(tbl_hotel.getSelectedRow(),3),
                        (String) tbl_hotel.getValueAt(tbl_hotel.getSelectedRow(),4),
                        (String) tbl_hotel.getValueAt(tbl_hotel.getSelectedRow(),5),
                        (String) tbl_hotel.getValueAt(tbl_hotel.getSelectedRow(),6),
                        Integer.parseInt(tbl_hotel.getValueAt(tbl_hotel.getSelectedRow(),7).toString())
                )){
                    loadHotelTable();
                    Notify.showMsg("Başarılı","Otel GÜncellendi");
                }else{
                    Notify.showMsg("Hata","Bir hata oluştu");
                }

            }
        });
        tbl_hotel_PopupMenu.add("Sil").addActionListener(e -> {
            if(employeeManager.deleteHotel(Integer.parseInt(tbl_hotel.getValueAt(tbl_hotel.getSelectedRow(),0).toString()))){
                loadHotelTable();
                Notify.showMsg("Başarılı","Otel silindi");
            }
        });
        tbl_hotel.setComponentPopupMenu(tbl_hotel_PopupMenu);
        loadHotelTable();
        // Hotel Table - END

        // Değerlendirme Formu 18
        // tbl_rezervations - START
        mdl_rezervations = new DefaultTableModel();
        mdl_rezervations.setColumnIdentifiers(new Object[]{"Rezervasyon ID","Otel ID","Otel","Room ID","İsim Soyisim","TC","Telefon","Email","Çocuk","Yetişkin"});
        row_rezervations = new Object[10];
        tbl_rezervations.setModel(mdl_rezervations);
        tbl_rezervations.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                tbl_rezervations.setRowSelectionInterval(tbl_rezervations.rowAtPoint(e.getPoint()), tbl_rezervations.rowAtPoint(e.getPoint()));
            }
        });

        JPopupMenu tbl_rezervations_popup = new JPopupMenu();
        tbl_rezervations_popup.add("Güncelle").addActionListener(e ->{
            tbl_rezervations.getCellEditor().stopCellEditing();
            if(employeeManager.updateReservation(
                    Integer.parseInt(tbl_rezervations.getValueAt(tbl_rezervations.getSelectedRow(),0).toString()),
                    (String) tbl_rezervations.getValueAt(tbl_rezervations.getSelectedRow(),4),
                    (String) tbl_rezervations.getValueAt(tbl_rezervations.getSelectedRow(),5),
                    (String) tbl_rezervations.getValueAt(tbl_rezervations.getSelectedRow(),6),
                    (String) tbl_rezervations.getValueAt(tbl_rezervations.getSelectedRow(),7),
                    Integer.parseInt(tbl_rezervations.getValueAt(tbl_rezervations.getSelectedRow(),8).toString()),
                    Integer.parseInt(tbl_rezervations.getValueAt(tbl_rezervations.getSelectedRow(),9).toString())
            )){
                loadRezervationList();
                Notify.showMsg("Başarılı","Rezervasyon GÜncellendi");
            }
        });
        tbl_rezervations_popup.add("Sil").addActionListener(e ->{
            if(employeeManager.deleteReservation(Integer.parseInt(tbl_rezervations.getValueAt(tbl_rezervations.getSelectedRow(),0).toString()))){
                employeeManager.increaseStock(Integer.parseInt(tbl_rezervations.getValueAt(tbl_rezervations.getSelectedRow(),3).toString()));
                loadRezervationList();
                Notify.showMsg("Başarılı","Rezervasyon Silindi");
            }
        });
        tbl_rezervations.setComponentPopupMenu(tbl_rezervations_popup);
        loadRezervationList();
        // tbl_rezervations - END



        // Search Table - Start
        mdl_search = new DefaultTableModel();
        mdl_search.setColumnIdentifiers(new Object[]{"Sezon","Sezon Başlangıç","Sezon Bitiş","Otel","Şehir","İlçe","Adres","Email","Telefon Numarası","Yıldız","Pansiyon","Oda Tipi","Yatak Sayısı","Kalan Oda","Çocuk Fiyatı","Yetişkin Fiyatı","Otel ID","Oda ID"});
        row_search = new Object[18];
        tbl_search.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tbl_search.setRowSelectionInterval(tbl_search.rowAtPoint(e.getPoint()), tbl_search.rowAtPoint(e.getPoint()));
                int hotelID = Integer.parseInt(tbl_search.getValueAt(tbl_search.getSelectedRow(),16).toString());
                int roomID = Integer.parseInt(tbl_search.getValueAt(tbl_search.getSelectedRow(),17).toString());
                loadHotelFeatures(txtA_hotelFeatures,employeeManager.getHotelFeatures(hotelID));
                loadRoomFeatures(txtA_roomFeatures,employeeManager.getRoomFeatures(roomID));
            }
            @Override
            public void mousePressed(MouseEvent e) {
                tbl_search.setRowSelectionInterval(tbl_search.rowAtPoint(e.getPoint()), tbl_search.rowAtPoint(e.getPoint()));
            }
        });
        tbl_search.setModel(mdl_search);
        tbl_search.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tbl_search.getColumnModel().getColumn(16).setPreferredWidth(0);
        tbl_search.getColumnModel().getColumn(17).setPreferredWidth(0);


        JPopupMenu reservation = new JPopupMenu();
        reservation.add("Rezervasyon").addActionListener(e -> {
            // Değerlendirme Formu 15
            if(txt_startDate.getText().isEmpty() || txt_endDate.getText().isEmpty()){
                Notify.showMsg("Uyarı","Rezervasyon yaptırmak için tarih aralıkları giriniz");
                return;
            }
            int days = employeeManager.calculateDay(txt_startDate.getText(),txt_endDate.getText());
            int totalPrice = (Integer.parseInt(tbl_search.getValueAt(tbl_search.getSelectedRow(),14).toString())*days)
                           + (Integer.parseInt(tbl_search.getValueAt(tbl_search.getSelectedRow(),15).toString())*days);
            ReservationGUI res = new ReservationGUI(
                    this,
                    employeeManager,
                    Integer.parseInt(tbl_search.getValueAt(tbl_search.getSelectedRow(),16).toString()),
                    Integer.parseInt(tbl_search.getValueAt(tbl_search.getSelectedRow(),17).toString()),
                    Integer.parseInt(cmb_childNumber.getSelectedItem().toString()),
                    Integer.parseInt(cmb_adultNumber.getSelectedItem().toString()),
                    totalPrice
            );
        });

        tbl_search.setComponentPopupMenu(reservation);
        loadSearchTable();
        // Search Table - END



        // Değerlendirme Formu 9
        btn_addHotel.addActionListener(e -> {
            if(Notify.isFieldEmpty(txt_hotel_name) || Notify.isFieldEmpty(txt_hotel_email) || Notify.isFieldEmpty(txt_hotel_phoneNumber)){
                Notify.showMsg("Uyarı","Lütfen Alanları Eksiksiz Doldurunuz");
            }else{
                if(employeeManager.addHotel(
                        txt_hotel_name.getText(),
                        txt_addcity.getText(),
                        txt_region.getText(),
                        txt_address.getText(),
                        txt_hotel_email.getText(),
                        txt_hotel_phoneNumber.getText(),
                        Integer.parseInt((String) cmb_hotel_star.getSelectedItem()))){
                    loadHotelTable();
                    Notify.showMsg("Başarılı","Ekleme işlemi başarılı");
                }
            }
        });

        // Değerlendirme Formu 13
        btn_search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!employeeManager.isValidDates(txt_startDate.getText(), txt_endDate.getText())){
                    Notify.showMsg("Uyarı","Geçerli Formatta Tarih Giriniz (GÜN/AY/YIL)");
                }else {
                    ArrayList<SearchResult> result =employeeManager.search(
                            employeeManager.searchQuery(
                                    txt_city.getText(),
                                    txt_city.getText(),
                                    txt_city.getText(),
                                    txt_startDate.getText(),
                                    txt_endDate.getText(),
                                    Integer.parseInt(cmb_childNumber.getSelectedItem().toString())+Integer.parseInt(cmb_adultNumber.getSelectedItem().toString())
                            )
                    );
                    loadSearchTable(result);
                }
            }
        });
    }
    public void loadRezervationList(){
        DefaultTableModel db = (DefaultTableModel) tbl_rezervations.getModel();
        db.setRowCount(0);
        for(Reservation r : employeeManager.getReservationList()){
            row_rezervations[0] = r.getId();
            row_rezervations[1] = r.getHotelID();
            row_rezervations[2] = employeeManager.getHotelByID(r.getHotelID()).getHotelName();
            row_rezervations[3] = r.getRoomID();
            row_rezervations[4] = r.getCustomerName();
            row_rezervations[5] = r.getCustomerTcNo();
            row_rezervations[6] = r.getCustomerPhone();
            row_rezervations[7] = r.getCustomerEmail();
            row_rezervations[8] = r.getChildNumber();
            row_rezervations[9] = r.getAdultNumber();
            mdl_rezervations.addRow(row_rezervations);
        }
    }
    private void loadHotelFeatures(JTextArea area,ArrayList<HotelFeature> list){
        area.setText("");
        for(HotelFeature f : list){
            area.append(f.getFeatureName()+"\n");
        }
    }
    private void loadRoomFeatures(JTextArea area,ArrayList<RoomFeature> list){
        area.setText("");
        for(RoomFeature r : list){
            area.append(r.getFeatureName()+"\n");
        }
    }

    // Değerlendirme Formu 14
    private void loadSearchTable(ArrayList<SearchResult> result){
        DefaultTableModel db = (DefaultTableModel) tbl_search.getModel();
        db.setRowCount(0);
        for(SearchResult r : result){
            row_search[0] = r.getSeasonName();
            row_search[1] = employeeManager.formatDateBack(r.getSeasonStartDate());
            row_search[2] = employeeManager.formatDateBack(r.getSeasonEndDate());
            row_search[3] = r.getHotelName();
            row_search[4] = r.getHotelCity();
            row_search[5] = r.getHotelRegion();
            row_search[6] = r.getHotelAdress();
            row_search[7] = r.getHotelEmail();
            row_search[8] = r.getHotelPhoneNumber();
            row_search[9] = r.getHotelStars();
            row_search[10] = employeeManager.getPensionNameByID(r.getPensionID());
            row_search[11] = r.getRoomType();
            row_search[12] = r.getRoomBedNumber();
            row_search[13] = r.getRoomStock();
            row_search[14] = r.getRoomPriceChildren();
            row_search[15] = r.getRoomPriceAdult();
            row_search[16] = r.getHotelID();
            row_search[17] = r.getRoomID();
            mdl_search.addRow(row_search);
        }
    }
    private void loadSearchTable(){
        DefaultTableModel db = (DefaultTableModel) tbl_search.getModel();
        db.setRowCount(0);
        for(SearchResult r : employeeManager.search()){
            row_search[0] = r.getSeasonName();
            row_search[1] = employeeManager.formatDateBack(r.getSeasonStartDate());
            row_search[2] = employeeManager.formatDateBack(r.getSeasonEndDate());
            row_search[3] = r.getHotelName();
            row_search[4] = r.getHotelCity();
            row_search[5] = r.getHotelRegion();
            row_search[6] = r.getHotelAdress();
            row_search[7] = r.getHotelEmail();
            row_search[8] = r.getHotelPhoneNumber();
            row_search[9] = r.getHotelStars();
            row_search[10] = employeeManager.getPensionNameByID(r.getPensionID());
            row_search[11] = r.getRoomType();
            row_search[12] = r.getRoomBedNumber();
            row_search[13] = r.getRoomStock();
            row_search[14] = r.getRoomPriceChildren();
            row_search[15] = r.getRoomPriceAdult();
            row_search[16] = r.getHotelID();
            row_search[17] = r.getRoomID();
            mdl_search.addRow(row_search);
        }
    }

    private void loadHotelTable(){
        DefaultTableModel db = (DefaultTableModel) tbl_hotel.getModel();
        db.setRowCount(0);
        for(Hotel hotel : employeeManager.getHotelList()){
            row_hotel_list[0] = hotel.getHotelID();
            row_hotel_list[1] = hotel.getHotelName();
            row_hotel_list[2] = hotel.getCity();
            row_hotel_list[3] = hotel.getRegion();
            row_hotel_list[4] = hotel.getAddress();
            row_hotel_list[5] = hotel.getHotelEmail();
            row_hotel_list[6] = hotel.getHotelPhoneNumber();
            row_hotel_list[7] = hotel.getHotelStars();
            mdl_hotel_list.addRow(row_hotel_list);
        }
    }

    public static void main(String[] args) {
        EmployeeGUI employeeGUI = new EmployeeGUI(new User(1,"64565465412","bttoy","a4","Batuhan","Toy","employee"));
    }

}
