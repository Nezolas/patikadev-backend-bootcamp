import java.util.Scanner;
public class Main {
    static boolean prime(int numb, int divider){
        divider -= 1;
        if(divider == 1)
            return true;
        if(numb % divider == 0)
            return false;
        return prime(numb, divider);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Sayı Giriniz: ");
        int n = input.nextInt();
        System.out.println(prime(n, n));

}
}