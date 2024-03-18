public class SafeHouse extends NormalLocation{
    public SafeHouse(Player player) {
        super(player, " Güvenli Ev ");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Güvenli eve giriş yapıldı.");
        System.out.println("Sağlık tazelendi.");
        return true;
    }
}
