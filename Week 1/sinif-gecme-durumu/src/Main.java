import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        /*The names of the courses are kept within an array.
        An empty grade array is created, whose length depends on the number of courses.*/
        String[] classes = {"Matematik","Fizik","Türkçe","Kimya","Müzik"};
        int[] grades = new int[classes.length];
        int total = 0;

        Scanner input = new Scanner(System.in);
        //While looping, grades are recorded into the array. During this process, the validity of each grade is tested. Valid grades are summed up.
        for(int i = 0; i < classes.length; i++){
            System.out.print(classes[i] + " notunuz: ");
            grades[i] = input.nextInt();
            if(0 < grades[i] && grades[i] < 100 ){
                total += grades[i];
            }
        }
        //The average is calculated, and the pass/fail status is printed on the screen.
        double avarage = (total) / 5;
        System.out.println("Hesaplanana Ortalamaniz: " + avarage);
        if(avarage <= 55){
            System.out.println("Sinif Tekrari");
        }
        else{
            System.out.println("Tebrikler sinifi gectiniz.");
        }
    }
}