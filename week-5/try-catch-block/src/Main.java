import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //array generating here 1 to maximum number (maxNum)
        int maxNum = 10;
        int list[] =new int[maxNum];
        for(int i = 0; i < maxNum; i++){
            list[i] = i + 1;
        }
        System.out.print("Yazdırmak istediğiniz indeksi giriniz: ");
        try{
            int index = input.nextInt();
            int value = fromList(list, index);
            System.out.println("Indeksinizin içerisindeki değer: " + value);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Liste dışında değer girildi. ");
        }catch (InputMismatchException e){
            System.out.println("Sayı dışında değer girildi.");
        }
    }
    public static int fromList(int list[], int index){
        return(list[index]);
    }
}