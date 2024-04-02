import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Read {
    public static void main(String[] args) {


        try {
            FileReader path = new FileReader("C:\\Users\\...\\num_file.txt"); //Please copy your file path here
            BufferedReader input = new BufferedReader(path);
            String line;
            int sum = 0;

            while ((line = input.readLine()) != null) {
                int num = Integer.parseInt(line);
                sum+= num;
            }

            System.out.println("Dosyadaki sayılar toplamı: " + sum);
        } catch (IOException e) {
            System.err.println("Oluşan Hata: " + e.getMessage());
        }
    }
}
