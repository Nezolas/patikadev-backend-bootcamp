import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int a, b, c, calc;
        System.out.println("a+b*c-b işleminin yapılması için:");
        Scanner number = new Scanner(System.in);
        System.out.print("Birinci sayıyı girin: ");
        a = number.nextInt();
        System.out.print("İkinci sayıyı girin: ");
        b = number.nextInt();
        System.out.print("Üçüncü sayıyı girin: ");
        c = number.nextInt();
        calc = a + b * c - b;
        System.out.print("İşlem Sonucu: " + calc);
    }
}