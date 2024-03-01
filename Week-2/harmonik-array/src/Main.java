import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.printf("N sayısını giriniz: ");
        int number = input.nextInt();

        int[] numbers = new int[number];
        for(int i = 0; i < number; i++ ){
            numbers[i] = i + 1;
        }
        //calculation
        double sum = 0.0;
        for (int j = 0; j < numbers.length; j++) {
            sum += (1.0 / numbers[j]);
        }
        System.out.println(sum);
    }
}