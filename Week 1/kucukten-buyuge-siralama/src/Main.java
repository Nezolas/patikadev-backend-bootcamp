import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //The numbers to be sorted are being taken.
        System.out.println("Sıralamak istediğiniz sayıyı giriniz:");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();
        //Sorting make with temporary number holders. A temporary variable (temp) allows us to change the order of numbers.
        if (num1 > num2) {
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }
        if (num2 > num3) {
            int temp = num2;
            num2 = num3;
            num3 = temp;
        }
        if (num1 > num2) {
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }

        System.out.println("Sayıların küçükten büyüğe sıralaması: " + num1 + " " + num2 + " " + num3);
    }
}