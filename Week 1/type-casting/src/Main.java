import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int int1, int2;
        double double1, double2;

        Scanner inp = new Scanner(System.in);
        System.out.print("Bir tam sayı giriniz: ");
        int1 = inp.nextInt();

        System.out.print("Bir ondalıklı sayı giriniz: ");
        double1 = inp.nextDouble();

        double2 = (double) int1 ;
        System.out.println("Tam sayıyı ondalıklı sayıya dönüştürüldü: " + double2);

        int2 = (int) double1;
        System.out.println("Ondalıklı sayı tam sayıya dönüştürüldü: " + int2);
    }
}