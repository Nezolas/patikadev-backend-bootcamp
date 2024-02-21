import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] gn = {"Armut", "Elma", "Domates", "Muz", "Patlıcan"}; //grocery name holding in this array
        double[] gp = {2.14, 3.67, 1.11, 0.95, 5.00}; //grocery prices list holding in an array with respect to gn order
        double[] gw = new double[gp.length] ; //grocery weights list is going to hold in an array
        double total = 0;
        Scanner price = new Scanner(System.in);
        for( int i = 0; i < gp.length; i++){
            System.out.print(gn[i] + " Kaç kilo? ");
            gw[i] = price.nextDouble();
        }

        for( int j = 0; j < gp.length; j++){
            total += gp[j] * gw[j];
        }
        System.out.println("Toplam Tutar: " + total);
    }
}