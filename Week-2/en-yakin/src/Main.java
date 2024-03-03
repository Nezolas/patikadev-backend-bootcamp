
public class Main {
    public static void main(String[] args) {
        int[] list = {15, 12, 788, 1, -1, -778, 2, 0};
        int num = 5;
        int min = list[0];
        int max = list[0];

        for (int i : list) {
            if (i < min) {
                min = i;
            }
            if (i > max) {
                max = i;
            }
        }

        for (int i = 0; i < list.length; i++) {
            if (list[i] < num && min < list[i]) {
                min = list[i];
            }
            if (num < list[i] && list[i] < max) {
                max = list[i];
            }
        }
        System.out.println("Girilen sayıdan küçük en yakın sayı\t: " + min);
        System.out.print("Girilen sayıdan büyük en yakın sayı\t: " + max);
    }
}