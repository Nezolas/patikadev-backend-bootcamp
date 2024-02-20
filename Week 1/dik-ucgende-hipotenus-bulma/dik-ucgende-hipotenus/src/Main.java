import java.util.Scanner;
import java.lang.Math;
public class Main {
    public static void main(String[] args) {
        int a, b;
        double c;
        Scanner input = new Scanner(System.in);
        System.out.print("Ilk kenarin degeri: ");
        a = input.nextInt();
        System.out.print("Ikinci kenarin degeri: ");
        b = input.nextInt();

        c = Math.sqrt((a * a) + (b * b));
        System.out.print("Hipotenus degeri: " + c);
    }
}