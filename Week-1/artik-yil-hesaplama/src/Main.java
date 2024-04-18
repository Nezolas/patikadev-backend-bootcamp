import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int year;
        //getting input
        System.out.print("Yılı Giriniz: ");
        Scanner inp = new Scanner(System.in);
        year = inp.nextInt();
        // leap year calculating
        boolean test = (year % 100 != 0 && year % 4 == 0)  || year % 400 == 0;
        if (test == false) {
            System.out.println(year + " bir artık yıl değildir.");
        } else if (test == true) {
            System.out.println(year + " bir artık yıldır!");
        }
    }
}