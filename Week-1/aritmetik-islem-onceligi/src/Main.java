import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // kullanıcan istenecek değişkenler tanımlanıyor.
        int a, b, c, calc;
        System.out.println("a+b*c-b işleminin yapılması için:");
        // Scanner sınıfı ile kullanıcıdan veriler isteniyor
        Scanner number = new Scanner(System.in);
        System.out.print("Birinci sayıyı girin: ");
        a = number.nextInt();
        System.out.print("İkinci sayıyı girin: ");
        b = number.nextInt();
        System.out.print("Üçüncü sayıyı girin: ");
        c = number.nextInt();
        // işlem sırasına göre hesaplamayapılıyor.
        calc = a + b * c - b;
        // yapılan işlemin sonucu ekrana yazdırılıyor.
        System.out.print("İşlem Sonucu: " + calc);
    }
}