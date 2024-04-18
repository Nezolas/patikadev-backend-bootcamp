import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int numb;
        Scanner input = new Scanner(System.in);
        System.out.print("Sayıyı Giriniz: ");
        numb = input.nextInt();

        System.out.println("0 ile " + numb + " arasında" + " 3 ve 4 tam bölünenbilen sayılar:");

        for(int i = 0; i <= numb; i++) {
            if((i % 3 == 0) && (i % 4 == 0)) {

                System.out.print(i + " ");
            }
        }
    }
}