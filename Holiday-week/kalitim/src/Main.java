import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("PROGRAM BASLANGIC");

        String islemler ="1, 2, 3, 4, Q";
        System.out.println(islemler);

        while(true){
            System.out.println("SEC");
            String islem = sc.nextLine();
            if(islem.equals("Q")){
                System.out.println("Cikiliyor");
                break;
            } else if (islem.equals("1")){
                Yazilimci y1 = new Yazilimci("Samet", 43, 123123, "JAVA, C");
                y1.formatAt("Linux");
                y1.show();

            }else if(islem.equals("2")){
                Yonetici yo1 = new Yonetici("Mudur", 21, 21231, 255);

                while(true){
                    System.out.println("SEcimini YAPS");
                    String yeni = sc.nextLine();
                    if(yeni.equals("Q")){
                        System.out.println("Cikiliyor");
                        break;
                    } else if (yeni.equals("1")){
                        yo1.show();
                    }else if(yeni.equals("2")){
                        yo1.zam(23);
                    }else{
                        System.out.println("hatali");
                    }
                }
            }else if(islem.equals("3")){

            }else if(islem.equals("4")){

            }else{
                System.out.println("GECERSIZ");
            }
        }

    }
}