import java.util.Scanner;

import static java.lang.System.*;

public class Game {
    private Scanner input = new Scanner(System.in);
    public void start(){
        out.println("*********************************************************************");
        out.println("Macera oyununa Hosgeldiniz! ");
        out.print("Lutfen bir isim giriniz: ");
        String playerName = input.nextLine();
        out.println();
        Player player = new Player(playerName);
        out.println(player.getName() + " Karakterini sec!");
        player.selectChar();
        while(true){
            Location location = null;
            out.println();;
            out.println("------------ Bolgeler ------------");
            out.println("1- Güvenli Ev ");
            out.println("2- Mağaza ");
            out.print("Gitmek İstediğiniz Bölgeyi Seçin: ");
            int selectLoc = input.nextInt();
            switch (selectLoc){
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                default:
                    location = new SafeHouse(player);
            }
            if(!location.onLocation()){
                out.println(" GAME OVER! ");
                break;
            }
        }
    }
}

