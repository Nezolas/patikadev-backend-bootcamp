import com.touristagencysystem.business.concretes.LoginManager;
import com.touristagencysystem.dataAccess.concretes.MysqlLoginRepository;
import com.touristagencysystem.presentation.gui.LoginGUI;

public class App {
    public static void main(String[] args) {
        LoginGUI letsRoll = new LoginGUI(new LoginManager(new MysqlLoginRepository()));
    }
}