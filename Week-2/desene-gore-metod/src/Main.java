import java.util.Scanner;
public class Main {
    public static void pattern(int numb){
        if(numb <= 0){
            System.out.print(numb + " ");
            return;
        }
        System.out.print(numb + " ");
        pattern(numb - 5);
        System.out.print(numb + " ");
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Sayi giriniz: ");
        int n = input.nextInt();
        pattern(n);
    }
}