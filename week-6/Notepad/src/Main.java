import java.io.*;
import java.util.Scanner;
public class Main {
    private static File file = new File("src/notepad.txt");;
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        //If the notepad.txt file has not been created previously, it is being created here
        try {
            if(file.createNewFile()){
                System.out.println("'"  +file.getName() + "'"  + " file has been created.");
            }else{
                System.out.println("'"  + file.getName() + "'" + " file exist");
                System.out.println("-------------------------------------");
                System.out.print("previous content: ");
                txtRead();
                System.out.println("-------------------------------------");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        //The inputs are being received here.
        System.out.print("Enter your notes here: ");
        String text = input.nextLine();
        FileWriter fileWriter = null;

        //New data is being added to the notepad without deleting the previous entries.
        try {
            fileWriter = new FileWriter(file,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.newLine();
            bufferedWriter.write(text);
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("-------------------------------------");
        System.out.print("Current state of the file: ");
        txtRead();

    }
    //The data inside the file is being read and printed to the console.
    private static void txtRead() {
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String textsRead;
            while((textsRead  = bufferedReader.readLine()) != null){
                System.out.println(textsRead);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}