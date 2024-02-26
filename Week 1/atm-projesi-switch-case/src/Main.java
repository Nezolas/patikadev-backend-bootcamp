import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String userName, password;
        Scanner input = new Scanner(System.in);
        int right = 3;
        int balance = 1500;
        int select;
        while (right > 0) {
            System.out.print("Kullanıcı Adınız :");
            userName = input.nextLine();
            System.out.print("Parolanız : ");
            password = input.nextLine();

            // Kullanıcı adı ve şifre kontrolü
            if (userName.equals("patika") && password.equals("dev123")) {
                System.out.println("Merhaba, Kodluyoruz Bankasına Hoşgeldiniz!");
                // Kullanıcının işlem seçenekleri
                do {
                    System.out.println("1-Para yatırma\n" +
                            "2-Para Çekme\n" +
                            "3-Bakiye Sorgula\n" +
                            "4-Çıkış Yap");
                    System.out.print("Lütfen yapmak istediğiniz işlemi seçiniz : ");
                    select = input.nextInt();

                    // Kullanıcının seçimi
                    switch (select) {
                        case 1:
                            // Para yatırma işlemi
                            System.out.print("Para miktarı : ");
                            int price = input.nextInt();
                            balance += price;
                            break;
                        case 2:
                            // Para çekme işlemi
                            System.out.print("Para miktarı : ");
                            price = input.nextInt();
                            if (price > balance) {
                                System.out.println("Bakiye yetersiz.");
                            } else {
                                balance -= price;
                            }
                            break;
                        case 3:
                            // Bakiye sorgulama işlemi
                            System.out.println("Bakiyeniz : " + balance);
                            break;
                        case 4:
                            // Çıkış yapma işlemi
                            System.out.println("Tekrar görüşmek üzere.");
                            break;
                        default:
                            // Geçersiz seçenek durumu
                            System.out.println("Geçersiz bir seçim yaptınız. Lütfen tekrar deneyiniz.");
                    }
                } while (select != 4);
                break;
            } else {
                // Hatalı giriş durumu
                right--;
                System.out.println("Hatalı kullanıcı adı veya şifre. Tekrar deneyiniz.");
                if (right == 0) {
                    // Hesap bloke olursa
                    System.out.println("Hesabınız bloke olmuştur lütfen banka ile iletişime geçiniz.");
                } else {
                    // Kalan deneme hakkı
                    System.out.println("Kalan Hakkınız : " + right);
                }
            }
        }
    }
}