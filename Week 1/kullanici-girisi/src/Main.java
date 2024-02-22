import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String uname, pw, request, npw;
        Scanner inp = new Scanner(System.in);

        System.out.print("Kullanici Adiniz: ");
        uname = inp.nextLine();

        System.out.print("Sifreniz: ");
        pw = inp.nextLine();

        if(uname.equals("patika") && pw.equals("java123")){
            System.out.print("Giris Yaptiniz!");
        }
        else{
            System.out.println("Bilgileriniz Yanlis!");
            System.out.print("Sifreyi Sifirlamak ister misin (Y/N)? ");
            request = inp.nextLine();
            if( request.equals("Y")){
               System.out.print("Yeni sifrenizi girin: ");
                npw = inp.nextLine();
                if(npw.equals("java123")){
                    System.out.println("Şifre oluşturulamadı, lütfen başka şifre giriniz.");
                }
                else
                    System.out.println("Sifre Olusturuldu.");
            }
            else if(request.equals("N")){
                System.out.println("Cikis yapiliyor.");
            }
            else
                System.out.println("Gecersiz istek.");
        }

    }
}