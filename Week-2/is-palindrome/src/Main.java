import java.util.Scanner;

public class Main {
    static boolean isPalindro(int number){
        int base = number, lastDigit, reverseNumber = 0;
        while(base != 0){
            lastDigit = base % 10;
            reverseNumber = reverseNumber * 10 + lastDigit;
            base /= 10;
        }
        if(number == reverseNumber)
            return true;
        else
            return  false;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Sayı Giriniz: ");
        int n = input.nextInt();
        System.out.println(isPalindro(n));
    }
}