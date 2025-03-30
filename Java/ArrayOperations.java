import java.util.Scanner;

public class ArrayOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of integers you want to store in the array: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int option, val, pos, count;
        do {
            System.out.println("\nSelect an option:");
            System.out.println("1. Delete a specified integer");
            System.out.println("2. Remove duplicate integers");
            System.out.println("3. Search for an integer");
            System.out.println("4. Insert a new integer");
            System.out.println("5. View the numbers in the array");
            System.out.println("6. View the numbers in ascending order");
            System.out.println("7. View the numbers in descending order");
            System.out.println("8. Calculate the sum and average of the numbers in the array");
            System.out.println("9. Find the Highest and Lowest numbers in the array");
            System.out.println("10. Find and display odd and even numbers in the array");
            System.out.println("0. Exit");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter the integer you want to delete: ");
                    val = scanner.nextInt();

                    count = 0;
                    for (int i = 0; i < n; i++) {
                        if (arr[i] == val) {
                            count++;
                            for (int j = i; j < n - 1; j++) {
                                arr[j] = arr[j + 1];
                            }
                            n--;
                            i--; // Check the same index again as elements have shifted.
                        }
                    }

                    if (count == 0) {
                        System.out.println(val + " is not present in the array.");
                    } else {
                        System.out.println(count + " occurrences of " + val + " have been deleted from the array.");
                    }
                    break;

                case 2:
                    count = 0;
                    for (int i = 0; i < n; i++) {
                        for (int j = i + 1; j < n; j++) {
                            if (arr[i] == arr[j]) {
                                count++;
                                for (int k = j; k < n - 1; k++) {
                                    arr[k] = arr[k + 1];
                                }
                                n--;
                                j--; // Check the same index again as elements have shifted.
                            }
                        }
                    }

                    if (count == 0) {
                        System.out.println("There are no duplicate integers in the array.");
                    } else {
                        System.out.println(count + " duplicate integers have been removed from the array.");
                    }
                    break;

                    case 3:
                    System.out.print("Enter the integer you want to search for: ");
                    val = scanner.nextInt();
                    boolean found = false;

                    for (int i = 0; i < n; i++) {
                        if (arr[i] == val) {
                            System.out.println(val + " is present in the array at index " + i + ".");
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println(val + " is not present in the array.");
                    }
                    break;

                case 4:
                    System.out.print("Enter the position where you want to insert the new integer (1-" + (n + 1) + "): ");
                    pos = scanner.nextInt();

                    if (n == arr.length) {
                        System.out.println("Array is full! No more elements can be inserted.");
                    } else if (pos < 1 || pos > n + 1) {
                        System.out.println("Invalid position. Please try again.");
                    } else {
                        System.out.print("Enter the new integer: ");
                        val = scanner.nextInt();

                        for (int i = n - 1; i >= pos - 1; i--) {
                            arr[i + 1] = arr[i];
                        }
                        arr[pos - 1] = val;
                        n++;
                        System.out.println(val + " has been inserted at position " + pos + ".");
                    }
                    break;

                case 5:
                    // View the numbers in the array
                    System.out.println("Numbers in the array:");
                    for (int i = 0; i < n; i++) {
                        System.out.print(arr[i] + " ");
                    }
                    System.out.println(); // Print a new line for formatting
                    break;

               case 6:
                    // View the numbers in ascending order
                    if (n == 0) {
                    System.out.println("Array is empty.");
                    } else {
                    for (int i = 0; i < n - 1; i++) {
                        for (int j = 0; j < n - i - 1; j++) {
                            if (arr[j] > arr[j + 1]) {
                                int temp = arr[j];
                                arr[j] = arr[j + 1];
                                arr[j + 1] = temp;
                            }
                        }
                    }
                    System.out.println("Numbers in ascending order:");
                    for (int i = 0; i < n; i++) {
                        System.out.print(arr[i] + " ");
                    }
                    System.out.println(); // Print a new line for formatting
                    }
                    break;

                case 7:
                // View the numbers in descending order
                if (n == 0) {
                System.out.println("Array is empty.");
                } 
                else {
                    for (int i = 0; i < n - 1; i++) {
                        for (int j = 0; j < n - i - 1; j++) {
                            if (arr[j] < arr[j + 1]) {
                                int temp = arr[j];
                                    arr[j] = arr[j + 1];
                                    arr[j + 1] = temp;
                            }
                        }
                    }
                System.out.println("Numbers in descending order:");
                for (int i = 0; i < n; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println(); // Print a new line for formatting
                }
                break;

                case 8:
                // Calculate the sum and average of the numbers in the array
                if (n == 0) {
                System.out.println("Array is empty.");
                } 
                else {
                    int sum = 0;
                    for (int i = 0; i < n; i++) {
                        sum += arr[i];
                    }
                double average = (double) sum / n;
                System.out.println("Sum of the numbers in the array: " + sum);
                System.out.println("Average of the numbers in the array: " + average);
                }
                break;

                case 9:
                //Find the Highest and Lowest numbers in the array
                if (n == 0) {
                System.out.println("Array is empty.");
                } 
                else {
                    int high = arr[0]; 
                    int low = arr[0]; 

                for (int i = 1; i < n; i++) {
                    if (arr[i] > high) {
                        high = arr[i]; 
                    }
                    if (arr[i] < low) {
                        low = arr[i]; 
                    }
                }

                System.out.println("Highest in the array: " + high);
                System.out.println("Lowest value in the array: " + low);
                }
                break;

                case 10:
                // Find and display odd and even numbers in the array
                int odd = 0;
                int even = 0;
                if (n == 0) {
                    System.out.println("Array is empty.");
                } 
                else {
                    System.out.println("Odd numbers:");
                
                for (int i = 0; i < n; i++) {
                        if (arr[i] % 2 != 0) {
                            System.out.print(arr[i] + " ");
                            odd++;
                        }
                }
                System.out.println(); 

                System.out.println("Even numbers:");
                for (int i = 0; i < n; i++) {
                    if (arr[i] % 2 == 0) {
                        System.out.print(arr[i] + " ");
                        even++;
                    }
                }
                System.out.println(); 
                System.out.println("Total odd numbers: " + odd);
                System.out.println("Total even numbers: " + even);
                }
                break;


                case 0:
                    System.out.println("Exiting the program...");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while (option != 0);

        scanner.close();
    }
}
