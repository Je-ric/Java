import java.util.Scanner;

public class ArrayHighLow{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter how many elements you want to store: ");
        int n = scanner.nextInt();
        int[] a = new int[n];

        System.out.print("Enter " + n + " numbers: ");
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int min = a[0];
        int max = a[0];

        for (int j = 1; j < n; j++) {
            if (min > a[j]) {
                min = a[j];
            }
            if (max < a[j]) {
                max = a[j];
            }
        }

        System.out.println("Minimum value: " + min);
        System.out.println("Maximum value: " + max);

        scanner.close();
    }
}
