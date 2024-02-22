import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        double n1,n2;
        int select;
        Scanner input = new Scanner(System.in);

        // user choose calculation choise
        System.out.println("1-toplama\n2-cikarma\n3-carpma\n4-bolme");
        System.out.print("seciminiz: ");
        select = input.nextInt();
        if(0 <= select && select <= 4) {
            // getting number from user
            System.out.print("Ilk sayiyi giriniz: ");
            n1 = input.nextInt();
            System.out.print("Ikinci sayiyi giriniz: ");
            n2 = input.nextInt();

            //calculation steps with switch-case
            switch (select) {
                case 1:
                    System.out.println("Toplam: " + (n1 + n2));
                    break;
                case 2:
                    System.out.println("Cikarma: " + (n1 - n2));
                    break;
                case 3:
                    System.out.println("Carpma: " + (n1 * n2));
                    break;
                case 4:
                    // dived by zero control step
                    if (n2 != 0)
                        System.out.println("Bolme: " + (n1 / n2));
                    else
                        System.out.println("Sayi/Sifir Belirsizligi");
                    break;
            }
        }
        else
            System.out.println("Gecersiz islem tercihi.");
    }
}