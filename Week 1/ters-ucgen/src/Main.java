import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Satır Sayısını Giriniz: ");
        int n = inp.nextInt();

        for (int i = n; i > 0; i--) {
            for (int j = (2 * i - 1); 0 < j; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}