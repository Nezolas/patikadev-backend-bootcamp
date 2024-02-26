import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Getting distance, age, and trip type information from the user
        double totalCost = 0;
        double normalFare;
        int distance, age, flightType;

        System.out.print("EMesafeyi km türünden giriniz: ");
        distance = scanner.nextInt();
        System.out.print("Yaşınızı giriniz: ");
        age = scanner.nextInt();
        System.out.print("Yolculuk tipini giriniz (1 => Tek Yön, 2 => Gidiş-Dönüş): ");
        flightType = scanner.nextInt();

        // Checking the validity of the entered data
        if (distance > 0 && age > 0 && (flightType == 1 || flightType == 2)) {
            // Calculating the normal ticket fare
            normalFare = distance * 0.10;

            // Applying age discounts
            if (age < 12)
                normalFare *= 0.5;
            else if (age >= 12 && age <= 24)
                normalFare *= 0.9;
            else if (age >= 65)
                normalFare *= 0.7;

            // Applying discounts based on the trip type
            if (flightType == 2)
                normalFare *= 0.8;

            // Calculating the total fare
            totalCost = flightType == 2 ? normalFare * 2 : normalFare;

            // Displaying the result
            System.out.println("Total Cost = " + totalCost + " TL");
        } else {
            // Displaying a warning message in case of invalid input
            System.out.println("Hatalı Veri Girildi.");
        }
        scanner.close();
    }
}