import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //body mass index (bmi), weight (w), hight (h)
        double bmi;
        System.out.print("Boyunuzu Metre Cinsinden Giriniz: ");
        Scanner input = new Scanner(System.in);
        double h = input.nextDouble();
        System.out.print("Kilonuzu Giriniz: ");
        double w = input.nextDouble();
        bmi = w / (h * h);
        System.out.println("Vücut Kitle Indeksiniz: " + bmi);
    }
}