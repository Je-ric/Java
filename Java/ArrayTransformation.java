import java.util.Scanner;

public class ArrayTransformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of inputs: ");
        int numRows = scanner.nextInt();
        int numCols = 2;

        int[][] originalArray = new int[numRows][numCols];

        System.out.println("Enter the input numbers:");
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                originalArray[i][j] = scanner.nextInt();
            }
        }

        int[][] transformedArray = new int[numCols][numRows];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                transformedArray[j][i] = originalArray[i][j];
            }
        }

        // Print the transformed array
        System.out.println("After:");
        for (int i = 0; i < numCols; i++) {
            for (int j = 0; j < numRows; j++) {
                System.out.print(transformedArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}

/*
    1 3 5 7 9
    2 4 6 8 10
*/