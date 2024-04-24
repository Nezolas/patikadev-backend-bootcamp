package com.touristagencysystem.business.concretes;
import com.touristagencysystem.business.abstracts.ILoginService;
import com.touristagencysystem.dataAccess.abstracts.ILoginRepository;
import com.touristagencysystem.dataAccess.abstracts.IUserRepository;
import com.touristagencysystem.entities.concretes.User;
import com.touristagencysystem.presentation.gui.AdminGUI;
import com.touristagencysystem.presentation.gui.EmployeeGUI;

public class LoginManager implements ILoginService {
    private ILoginRepository loginRepository;
    public LoginManager(ILoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public boolean login(String userName_tcNo, String password) {
        int id;
        if((id = loginRepository.login(userName_tcNo,password)) != -1){
            // Yönetici veya çalışan olma durumuna göre Giriş İşlemi
            User user = loginRepository.getUserByID(id);
            switch (user.getUserType()){
                case "admin":
                    AdminGUI admin = new AdminGUI(user);
                    break;
                case "employee":
                    EmployeeGUI e = new EmployeeGUI(user);
                    break;
            }
            return true;
        }
        return false;
    }
}
