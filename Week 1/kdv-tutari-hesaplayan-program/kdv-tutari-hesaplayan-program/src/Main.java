import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        double price;
        double total, tax_rate, tax = 0.18;

       Scanner input = new Scanner(System.in);
        System.out.print("Fiyati girin: ");

        price = Integer.parseInt(input.nextLine());
        total = price * (1 + tax);
        tax_rate = price * tax;

        System.out.println("KDV'siz fiyat: " + price);
        System.out.println("KDV'li fiyat: " + total);
        System.out.println("KDV degeri: " + tax_rate);
    }
}