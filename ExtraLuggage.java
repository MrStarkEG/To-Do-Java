import java.util.Scanner;

public class FlightBaggageCharge {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numberOfGroups;

        System.out.println("Please enter the number of groups: ");
        numberOfGroups = input.nextInt();

        for (int group = 1; group <= numberOfGroups; group++) {
            System.out.println("Group " + group + ":");
            calculateBaggageCharge(input);
        }
    }

    public static void calculateBaggageCharge(Scanner input) {
        double charge = 0;

        System.out.println("Enter the number of passengers: ");
        int numberOfPassengers = input.nextInt();

        for (int passenger = 1; passenger <= numberOfPassengers; passenger++) {
            System.out.println("Passenger " + passenger + ":");
            System.out.println("Please enter the passenger class (F/B/E): ");
            char passClass = input.next().charAt(0);
            System.out.println("Enter bag weight: ");
            double bagWeight = input.nextDouble();

            switch (passClass) {
                case 'F':
                case 'f':
                    if (bagWeight > 30) {
                        double excessWeight = bagWeight - 30;
                        charge = excessWeight * 10;
                    }
                    break;
                case 'B':
                case 'b':
                    if (bagWeight > 25) {
                        double excessWeight = bagWeight - 25;
                        charge = excessWeight * 10;
                    }
                    break;
                case 'E':
                case 'e':
                    if (bagWeight > 20) {
                        double excessWeight = bagWeight - 20;
                        charge = excessWeight * 10;
                    }
                    break;
                default:
                    System.out.println("Error: Invalid passenger class.");
            }

            System.out.println("Extra charge for this passenger: $" + charge);
        }
    }
}
