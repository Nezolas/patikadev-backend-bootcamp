import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int sum = 0, number;
        Scanner inp = new Scanner(System.in);

        System.out.print("Sayı Giriniz: ");
        number = inp.nextInt();


        while (number != 0) {
            sum += number % 10; // Son basamağı alıp toplama ekler
            number /= 10; // Sayıyı bir basamak sağa kaydırır
        }

        System.out.print("Basamaklar toplamı: " + sum);
    }
}