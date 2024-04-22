package com.touristagencysystem.core;

import javax.swing.*;

public class Notify {

    public static void showMsg(String title, String message){
        UIManager.put("OptionPane.okButtonText","Tamam");
        UIManager.put("OptionPane.yesButtonText","Evet");
        UIManager.put("OptionPane.noButtonText","Hayır");
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);

    }
    public static boolean isFieldEmpty(JTextField field){
        return field.getText().isEmpty();
    }

    public static boolean confirm(String str){
        String msg;
        switch (str){
            case "sure":
                msg = "Bu işlemi gerçekleştirmek istediginizden emin misiniz?";
                break;
            default:
                msg=str;
                break;
        }
        return JOptionPane.showConfirmDialog(null,msg,"İşlemi yapmak istediginize emin misiniz?",JOptionPane.YES_NO_OPTION)==0;
    }
}
