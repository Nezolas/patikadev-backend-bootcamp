import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Kaç tane sayı gireceksiniz: ");
        int n = scanner.nextInt();

        int min = 0;
        int max = 0;

        for (int i = 1; i <= n; i++) {
            System.out.print(i + ". sayıyı girin: ");
            int sayi = scanner.nextInt();

            if (i == 1) {
                min = sayi;
                max = sayi;
            } else {
                if (sayi < min) {
                    min = sayi;
                }
                if (sayi > max) {
                    max = sayi;
                }
            }
        }

        System.out.println("En büyük sayı: " + max);
        System.out.println("En küçük sayı: " + min);
    }
}