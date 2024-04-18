import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int count, min, max, number;
        Scanner inp = new Scanner(System.in);
        System.out.print("Kaç adet sayı gireceksiniz? : ");
        count = inp.nextInt();
        int[] array = new array(count);
        
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }









      /*
        for(int i = 1; i <= count; i++){
            System.out.print(i + ". sayıyı giriniz: ");
            number = inp.nextInt();
            if(number < min ||)
                min = number;
            else if(number > max)
                max = number;
        }
        System.out.println("Minimun değer: " + min);
        System.out.println("Maximum değer: " + max);
*/

    }
}