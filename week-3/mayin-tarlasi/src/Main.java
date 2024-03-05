import java.util.Scanner;
public class Main{
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Satır Sayısını Giriniz: ");
    int rows = scanner.nextInt();
    System.out.print("Sütun Sayısını Giriniz: ");
    int cols = scanner.nextInt();

    if (rows < 2 || cols < 2) {
        System.out.println("Satır ve sütun sayısı en az 2 olmalıdır.");
        return ;
    }

    MineSweeper game = new MineSweeper(rows, cols);
    game.play();
}
}
