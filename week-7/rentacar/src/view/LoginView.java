package view;

import business.UserManager;
import core.Helper;
import entity.User;

import javax.swing.*;

public class LoginView extends Layout {
    private JPanel container;
    private JPanel w_top;
    private JLabel label_welcome;
    private JLabel label_welcome2;
    private JTextField field_username;
    private JPasswordField field_password;
    private JButton button_login;
    private JLabel label_username;
    private JLabel label_password;
    private final UserManager userManager;

    public LoginView() {
        this.userManager = new UserManager();

        this.add(container);
        this.guiInitialize(400,400);

        button_login.addActionListener(e -> {
            if (Helper.isFieldEmpty(this.field_username) || Helper.isFieldEmpty(this.field_password)) {
                Helper.showMsg("Lütfen tüm alanları doldurunuz.");
            } else {
                User loginUser = this.userManager.findByLogin(this.field_username.getText(), this.field_password.getText());
                if (loginUser == null) {
                    Helper.showMsg("Kullanıcı bulunamadı.");
                } else {
                    AdminView adminView = new AdminView(loginUser);
                    dispose();
                }
            }
        });
    }
}
