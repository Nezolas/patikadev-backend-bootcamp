import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.print("N sayısını giriniz: ");
        Scanner inp = new Scanner(System.in);
        int n = inp.nextInt();
        double result = 0;
        for(double i = 1; i <= n; i++){
            result += (1 / i);
        }
        System.out.print("Result: " + result);
    }
}