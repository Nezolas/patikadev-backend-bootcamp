public class Yazilimci extends Worker{
    private String lang;

    public Yazilimci(String name, int age, int id, String lang) {
        super(name, age, id);
        this.lang = lang;
    }
    public void formatAt(String isletim_sistemi){
        System.out.println(getName()+ " "+ isletim_sistemi + "Yukuyor");
    }

    @Override
    public void show() {
        super.show();
        System.out.println("Bildigi diller" + lang);
    }
}
