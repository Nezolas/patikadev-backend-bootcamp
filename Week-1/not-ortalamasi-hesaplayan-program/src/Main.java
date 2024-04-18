import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        /*
        kodlari tekrara dusurmemek icin ders isimleri bir string arrayinin icerisinde tutuluyor,
        karsilik gelecek notlar ise classes arrayinin uzunlugu referans alinarak olusturulan notes arrayinin icerisinde tutuluyor.
        NOT: Program, kullanici girdilerinin hepsinin 0-100 arasi olacagi dusunulerek tasarlanmistir.
        */

        String[] classes = {"Matematik", "Fizik", "Kimya", "Turkce", "Tarih", "Muzik"};
        int[] notes = new int[classes.length];
        int sum = 0;
        double avarage;
        // Kullanici ders notlarini girebilmesi icin bir input olusturuluyor
        Scanner input = new Scanner(System.in);
        // for dongusu yardimiyla ders notlari sira ile notes arrayinin icerisine kaydediliyor
        for( int i = 0; i < classes.length; i++){
            System.out.print("Notunuzu giriniz"+ " (" + classes[i] + "):\t");
            notes[i] = Integer.parseInt(input.nextLine());
        }
        // Bir baska for dongusu ile notlar toplaniyor
        for( int j = 0; j < classes.length; j++){
            sum += notes[j];
        }
        // toplam, array icerisine yazilan derslerin sayisina bolunerek ortalama aliniyor.
        avarage = (double) sum / classes.length;
        System.out.println("Derslerinizin ortalamasi: " + avarage);
        var pass = (60 < avarage) ? "Sınıfı Geçti" : "Sınıfta Kaldı";
        System.out.print("***** " + pass + " *****");
    }
}