import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Fibonacci serisinin kaç elemanını görmek istiyorsunuz: ");
        int n = scanner.nextInt();

        int a = 0, b = 1;

        System.out.print(n + " Elemanlı Fibonacci serisi: ");

        if (n >= 1)
            System.out.print(a + " ");
        if (n >= 2)
            System.out.print(b + " ");

        for (int i = 3; i <= n; i++) {
            int c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
    }
}
