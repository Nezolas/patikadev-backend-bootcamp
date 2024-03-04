import java.util.Scanner;
public class Main {
    void sort(int array[])
    {
        int n = array.length;
        for (int i = 0; i < n-1; i++)
        {
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (array[j] < array[min_idx])
                    min_idx = j;
            int temp = array[min_idx];
            array[min_idx] = array[i];
            array[i] = temp;
        }
    }
    void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void main(String args[])
    {
        Scanner inp = new Scanner(System.in);
        Main process = new Main();
        System.out.print("Dizinin boyutu:\t");
        int len = inp.nextInt();
        int arr[] = new int[len];
        System.out.println("Dizinin elemanlarini giriniz:\t");
        for(int i = 1; i <= arr.length; i++){
            System.out.print(i + ". Elamani:\t");
            int userInp = inp.nextInt();
            arr[i - 1] = userInp;
        }
        process.sort(arr);
        System.out.print("Sıralama:\t");
        process.printArray(arr);
    }
}
