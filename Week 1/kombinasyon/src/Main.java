import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n, r, rFact = 1, nFact = 1, nrFact = 1, comb;
        System.out.println("Kombinasyon gösterimi: C(n,r)");
        Scanner c = new Scanner(System.in);
        do {
            System.out.print("n değerini giriniz: ");
            n = c.nextInt();
            System.out.print("r değerini giriniz: ");
            r = c.nextInt();
        }while(n < r);
        //Combination calculation C(n,r) = n! / (r! * (n-r)!)

        //all for loops are different with each other so we do not need chane the i variable
        for(int i = n; 0 < i; i--){
            nFact *= i;
        }
        for(int i = r; 0 < i; i--){
            rFact *= i;
        }
        for(int i = (n - r); 0 < i; i--){
            nrFact *= i;
        }
        comb = nFact / (rFact * nrFact);
        System.out.println("C(" + n + "," + r + ")" + " = " + comb);

    }
}