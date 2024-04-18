import java.util.Scanner;
import java.lang.Math;
public class Main {
    public static void main(String[] args) {
        int a, b;
        double c, u, perimeter, area;
        Scanner input = new Scanner(System.in);
        System.out.print("Ilk kenarin degeri: ");
        a = input.nextInt();
        System.out.print("Ikinci kenarin degeri: ");
        b = input.nextInt();
        c = Math.sqrt((a * a) + (b * b));
        System.out.println("Hipotenus degeri: " + c);
        perimeter = a + b + c;
        u = perimeter / 2;
        area = Math.sqrt(u * (u - a) * (u - b) * (u - c));
        System.out.print("Ucgenin alani: " + area);


    }
}