import java.util.Scanner;

public class Formation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter how many numbers: ");
        int n = scanner.nextInt();

        if (n < 2 || n % 2 != 0) {
            System.out.println("Please enter an even number of numbers greater than or equal to 2.");
            return;
        }

        int[] inputNumbers = new int[n];
        System.out.println("Enter the numbers one by one:");

        for (int i = 0; i < n; i++) {
            inputNumbers[i] = scanner.nextInt();
        }

        System.out.println("Formation 1:");
        for (int i = 0; i < n / 2; i++) {
            System.out.println(inputNumbers[i] + " " + inputNumbers[i + n / 2]);
        }

        System.out.println("\nFormation 2:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                System.out.print(inputNumbers[i * (n / 2) + j] + " ");
            }
            System.out.println();
        }
    }
}


