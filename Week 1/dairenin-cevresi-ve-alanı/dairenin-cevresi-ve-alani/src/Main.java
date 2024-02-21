import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int radius, angle;
        double areaofSlice, pi = 3.14;
        Scanner input = new Scanner(System.in);
        System.out.print("Yarı Çapı Giriniz: ");
        radius = input.nextInt();
        System.out.print("Merkez Açısını Giriniz: ");
        angle = input.nextInt();
        areaofSlice = (pi * radius * radius * angle) / 360;
        System.out.println("Daire Diliminin Alanı: " + areaofSlice);



    }
}