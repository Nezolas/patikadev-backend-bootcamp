import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Kullanıcıdan bir tam sayı ve bir ondalıklı sayı girmesini iste
        System.out.print("Bir tam sayı girin: ");
        int tamSayi = scanner.nextInt();

        System.out.print("Bir ondalıklı sayı girin: ");
        double ondalikliSayi = scanner.nextDouble();

        // Tam sayıyı ondalıklı sayıya dönüştürerek ve ekrana yazdır
        double tamSayiOndalikli = (double) tamSayi;
        System.out.println("Tam sayıyı ondalıklı sayıya dönüştürüldü: " + tamSayiOndalikli);

        // Ondalıklı sayıyı tam sayıya dönüştürerek ve ekrana yazdır
        int ondalikliSayiTam = (int) ondalikliSayi;
        System.out.println("Ondalıklı sayıyı tam sayıya dönüştürüldü: " + ondalikliSayiTam);

        scanner.close();
    }
}