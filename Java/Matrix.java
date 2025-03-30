import java.util.Scanner;

public class Matrix{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many rows: ");
        int numRows = scanner.nextInt();
        System.out.print("How many columns: ");
        int numCols = scanner.nextInt();

        int[][] matrix = new int[numRows][numCols];

        // Input
        System.out.println("Enter the matrix elements:");
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                System.out.print("Enter element at row " + (i + 1) + ", column " + (j + 1) + ": ");
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Print 
        System.out.println("\nMatrix:");
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
