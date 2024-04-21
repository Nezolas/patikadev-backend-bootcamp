package com.touristagencysystem.presentation.gui;

import com.touristagencysystem.business.abstracts.ILoginService;
import com.touristagencysystem.core.Config;
import com.touristagencysystem.core.Notify;
import com.touristagencysystem.presentation.gui.abstracts.Layout;

import javax.swing.*;

public class LoginGUI extends Layout {
    private JPanel wrapper;
    private JTextField txt_username_tcno;
    private JPasswordField txt_password;
    private JButton btn_login;

    //Businessdaki işlemleri mesela ekleme,silme vb buradan çağıracağız
    private ILoginService loginService;

    public LoginGUI(ILoginService loginService){
        this.loginService = loginService;
        add(wrapper);
        setGUILayout(400,400);

        // Değerlendirme Formu 8
        btn_login.addActionListener(e -> {
            if(Notify.isFieldEmpty(txt_username_tcno) || Notify.isFieldEmpty(txt_password)){
                Notify.showMsg("Hata","Lütfen alanları eksiksiz doldurunuz");
            }else {
                if(loginService.login(txt_username_tcno.getText(),txt_password.getText())){
                    dispose();
                }else{
                    Notify.showMsg("Uyarı","Kullanıcı adı/TC No veya Şifre yanlış!!!");
                }
            }
        });

    }
}
