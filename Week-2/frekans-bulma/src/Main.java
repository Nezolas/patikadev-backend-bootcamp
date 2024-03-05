import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Dizinin boyutu:\t");
        int len = inp.nextInt();
        int arr[] = new int[len];
        System.out.println("Dizinin elemanlarini giriniz:\t");
        for(int i = 1; i <= arr.length; i++){
            System.out.print(i + ". Elamani:\t");
            int userInp = inp.nextInt();
            arr[i - 1] = userInp;
        }
        System.out.print("dizi: ");
        for(int i = 0; i < arr.length; i++){
            System.out.print (arr[i] + " ");
        }
        System.out.println("\n");
        int[] frequencies = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            boolean counted = false;
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    counted = true;
                    break;
                }
            }
            if (!counted) {
                int count = 1;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i] == arr[j]) {
                        count++;
                    }
                }
                System.out.println(arr[i] + " sayısı " + count + " kere tekrar edildi.");
            }
        }
    }
}