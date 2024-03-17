import java.util.Scanner;
import static java.lang.System.out;

public class Game {
    private Scanner input = new Scanner(System.in);
    public void start(){
        out.println("Macera oyununa Hosgeldiniz! ");
        out.print("Lutfen bir isim giriniz: ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        out.println(player.getName() + " Karakterini sec!");
        player.selectChar();
    }
}

