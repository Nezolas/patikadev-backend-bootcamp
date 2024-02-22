import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String uname, pw, request, npw;
        Scanner inp = new Scanner(System.in);

        System.out.print("Kullanici Adiniz: ");
        uname = inp.nextLine();

        System.out.print("Sifreniz: ");
        pw = inp.nextLine();
        //password check
        if(uname.equals("patika") && pw.equals("java123")){
            System.out.print("Giris Yaptiniz!");
        }
        else{
        //regenerating password
            System.out.println("Bilgileriniz Yanlis!");
            System.out.print("Sifreyi Sifirlamak ister misin (Y/N)? ");
            request = inp.nextLine();
            if( request.equals("Y")){
        //if users choose old password program looping until users input a different password
                do {
                    System.out.print("Yeni sifrenizi girin: ");
                    npw = inp.nextLine();
        //This if statement is used to prevent unnecessary printing of error message.
                    if(npw.equals("java123")) {
                        System.out.println("Yeni şifre eski şifre ile aynı olamaz. Lütfen başka bir şifre deneyin.");
                    }
                }
                while (npw.equals("java123"));
                System.out.println("Sifre olusturuldu.");
            }
            else if(request.equals("N")){
                System.out.println("Cikis yapiliyor.");
            }
            else
                System.out.println("Gecersiz istek.");
        }
    }
}