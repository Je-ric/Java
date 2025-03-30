import java.util.Scanner;

public class Calculator2{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float total;
        float num1, num2;
        int choice;
        int result, a, b;

        System.out.println("[Calculator using Conditional Operator]\n");
        System.out.println("Menu");
        System.out.println("[1] Addition");
        System.out.println("[2] Multiplication");
        System.out.println("[3] Subtraction");
        System.out.println("[4] Division");
        System.out.println("[5] Modulus");
        System.out.print("Enter choice: ");
        choice = scanner.nextInt();

        if (choice == 1) {
            System.out.println("[1] Addition");
            System.out.print("Enter a number: ");
            num1 = scanner.nextFloat();
            System.out.print("Enter a number: ");
            num2 = scanner.nextFloat();
            total = num1 + num2;
            System.out.println("Sum = " + String.format("%.2f", total));
        } else if (choice == 2) {
            System.out.println("[2] Multiplication");
            System.out.print("Enter a number: ");
            num1 = scanner.nextFloat();
            System.out.print("Enter a number: ");
            num2 = scanner.nextFloat();
            total = num1 * num2;
            System.out.println("Product = " + String.format("%.2f", total));
        } else if (choice == 3) {
            System.out.println("[3] Subtraction");
            System.out.print("Enter a number: ");
            num1 = scanner.nextFloat();
            System.out.print("Enter a number: ");
            num2 = scanner.nextFloat();
            total = num1 - num2;
            System.out.println("Minus = " + String.format("%.2f", total));
        } else if (choice == 4) {
            System.out.println("[4] Division");
            System.out.print("Enter a number: ");
            num1 = scanner.nextFloat();
            System.out.print("Enter a number: ");
            num2 = scanner.nextFloat();
            total = num1 / num2;
            System.out.println("Divide = " + String.format("%.2f", total));
        } else if (choice == 5) {
            System.out.println("[5] Modulus");
            System.out.print("Enter a number: ");
            a = scanner.nextInt();
            System.out.print("Enter a number: ");
            b = scanner.nextInt();
            result = a / b;
            result = a % b;
            System.out.println("Division of " + a + " and " + b + " = " + result);
            System.out.println("Modulo = " + result);
        } else {
            System.out.println("ERROR");
        }
    }
}
