import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int km;
        double total =10.0, fee, kmCost = 2.20;
        Scanner input = new Scanner(System.in);
        System.out.print("Mesafeyi Giriniz: ");
        km = input.nextInt();
        fee = km * kmCost;
        total += fee;
        total = (total < 20) ? 20 : total;
        System.out.println("Toplam Tutar: " + total);
    }
}