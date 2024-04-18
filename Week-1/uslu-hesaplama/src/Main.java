import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int pow, base;
        long result = 1;

        Scanner inp = new Scanner(System.in);

        System.out.print("Üs olacak sayı: ");
        pow = inp.nextInt();

        System.out.print("Üssü alınacak sayı: ");
        base = inp.nextInt();

        for(int i = 0; i < pow; i++){
            result *= base;
        }
        System.out.print("Sonuç: " + result);
    }
}