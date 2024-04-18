import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n, sum = 0;
        Scanner inp = new Scanner(System.in);
        do {
            System.out.println("Sayı Giriniz!");
            n = inp.nextInt();
            if(n % 4 == 0){
                sum += n;
            }
        }
        while(n % 2 == 0);
        System.out.println("Toplam: " + sum );
    }
}