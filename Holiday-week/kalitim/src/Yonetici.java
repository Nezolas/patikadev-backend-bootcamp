public class Yonetici extends Worker{
    private int sorumlu_sayi;

    public Yonetici(String name, int age, int id, int sorumlu_sayi) {
        super(name, age, id);
        this.sorumlu_sayi = sorumlu_sayi;
    }

    @Override
    public void show() {
        super.show();
        System.out.println(sorumlu_sayi);

    }
    public void zam(int zamMik){
        System.out.println(getName() + " zam orani " + zamMik);
    }
}