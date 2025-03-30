import java.util.Arrays;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] numbers = {10, 22, 10, 20, 11, 22};
        int length = numbers.length;

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (numbers[i] == numbers[j]) {
                    for (int k = j; k < length - 1; k++) {
                        numbers[k] = numbers[k + 1];
                    }
                    length--; 
                    j--; 
                }
            }
        }

        // Print
        for (int i = 0; i < length; i++) {
            System.out.print(numbers[i]);
            if (i < length - 1) {
                System.out.print(", ");
            }
        }
    }
}
