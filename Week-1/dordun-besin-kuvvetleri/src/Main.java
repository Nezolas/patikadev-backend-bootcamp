import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n;
        Scanner input = new Scanner(System.in);
        System.out.printf("Sayı Giriniz: ");
        n = input.nextInt();
        System.out.print("Dördün kuvvetleri:\t ");
        for(int i = 0; i <= n; i += 4) {
            System.out.print(i + " " );
        }
        System.out.print("\nBeşin kuvvetleri:\t ");
        for(int j = 0; j <= n; j += 5){
            System.out.print(j + " " );
        }
        }
    }