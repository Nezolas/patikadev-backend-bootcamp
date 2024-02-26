import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("1. sayıyı girin: ");
        int sayi1 = scanner.nextInt();

        System.out.print("2. sayıyı girin: ");
        int sayi2 = scanner.nextInt();

        int ebob = 1;
        int ekok;

        int min = Math.min(sayi1, sayi2);
        int i = 2;

        while (i <= min) {
            if (sayi1 % i == 0 && sayi2 % i == 0) {
                ebob = i;
            }
            i++;
        }

        ekok = (sayi1 * sayi2) / ebob;

        System.out.println("Girilen sayıların EBOB'u: " + ebob);
        System.out.println("Girilen sayıların EKOK'u: " + ekok);
    }
}