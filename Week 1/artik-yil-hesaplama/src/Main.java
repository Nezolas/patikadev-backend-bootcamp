import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int year;
        //getting input
        System.out.print("Yılı Giriniz: ");
        Scanner inp = new Scanner(System.in);
        year = inp.nextInt();
        // leap year calculating
        if(year % 100 != 0 && year % 4 == 0  || year % 400 == 0 )
            System.out.println(year + " bir artık yıldır!");
        else
            System.out.println(year + " bir artık yıl değildir.");
    }
}