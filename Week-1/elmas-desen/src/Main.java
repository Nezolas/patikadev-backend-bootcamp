import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner klavye = new Scanner(System.in);
        System.out.print("Bir Sayı Giriniz :");
        int n = klavye.nextInt();

        for (int i = 0; i <= n ; i++) {
            for (int j = 0; j < (n - i); j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= (2 * i -1); k++) {
                System.out.print("*");
            }
            System.out.println(" ");
        }
       for (int m = n - 1; m > 0; m--) {
           for (int t = 1; t <= n - m; t++) {
               System.out.print(" ");
           }

        for (int l = 1; l <= m * 2 - 1; l++) {
            System.out.print("*");
        }
        System.out.println();
    }
    }
}



