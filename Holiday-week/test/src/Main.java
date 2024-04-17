import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter numerical value");
        int option = input.nextInt(); // Read numerical value from input

        System.out.print("Enter 1st string");
        String string1 = input.nextLine(); // Read 1st string (this is skipped)

        System.out.print("Enter 2nd string");
        String string2 = input.nextLine();
    }
}