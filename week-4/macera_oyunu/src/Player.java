import java.util.Scanner;
import static java.lang.System.out;

public class Player {
    private int damage;
    private int health;
    private int coin;
    private String name;
    private String characterName;
    private Scanner input = new Scanner(System.in);
    private Inventory inventory;

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar(){

        Characters[] charList = {new Samurai(), new Archer(), new Knight()};

        for(Characters characters : charList){
            System.out.println("ID: " +characters.getId() +
                    "\t Karakter: "+ characters.getName() +
                    "\t Hasar:" +characters.getDamage() +
                    "\t Saglik:" + characters.getHealth() +
                    "\t Para:" + characters.getCoin());
        }
        out.print("Şimdi Seçim Zamanı!! ==> ");
        int selectChar = input.nextInt();
        switch (selectChar){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
                break;
        }
        out.println("Seçtiğin karakter: " + this.getCharacterName() +
                " Hasarı: " + this.getDamage() +
                " Sağlığı: " + this.getHealth() +
                " Parası: " + this.getCoin());
    }

    public void initPlayer(Characters characters){
        this.setDamage(characters.getDamage());
        this.setHealth(characters.getHealth());
        this.setCoin(characters.getCoin());
        this.setCharacterName(characters.getName());
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
