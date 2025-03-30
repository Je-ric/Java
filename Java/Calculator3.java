import java.util.Scanner;

public class Calculator3 {
    public static double computeSum(double a, double b) {
        return a + b;
    }

    public static double computeDifference(double a, double b) {
        return a - b;
    }

    public static double computeProduct(double a, double b) {
        return a * b;
    }

    public static double computeQuotient(double a, double b) {
        return a / b;
    }

    public static int computeQuotientr(int a, int b) {
        return a / b;
    }

    public static int computeRemainder(int a, int b) {
        return a % b;
    }

    public static void displayTotal(double a, double b, char sign) {
        double result;
        double rmdr;

        switch (sign) {
            case '+':
            case '1':
                result = computeSum(a, b);
                System.out.printf("Sum of %.2f and %.2f is: %.2f%n", a, b, result);
                break;
            case '-':
            case '2':
                result = computeDifference(a, b);
                System.out.printf("Difference of %.2f and %.2f is: %.2f%n", a, b, result);
                break;
            case '*':
            case '3':
                result = computeProduct(a, b);
                System.out.printf("Product of %.2f and %.2f is: %.2f%n", a, b, result);
                break;
            case '/':
            case '4':
                result = computeQuotient(a, b);
                System.out.printf("Quotient of %.2f and %.2f is: %.2f%n", a, b, result);
                rmdr = computeQuotientr((int) a, (int) b);
                System.out.printf("Quotient of %.2f and %.2f is: %.2f%n", a, b, rmdr);
                rmdr = computeRemainder((int) a, (int) b);
                System.out.printf("Remainder of %.2f is: %.2f%n", a, rmdr);
                break;
            default:
                System.out.println("Select from Menu");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a, b;
        double result, rmdr;
        char sign;
        char choice;

        do {
            System.out.println("[Calculator Using Function and Switch Case]");
            System.out.println("\nMenu");
            System.out.println("Select [1] or [+] for Sum");
            System.out.println("Select [2] or [-] for Difference");
            System.out.println("Select [3] or [*] for Product");
            System.out.println("Select [4] or [/] for Quotient");
            System.out.print("Select operator: ");
            sign = scanner.next().charAt(0);

            System.out.print("Enter 1st number: ");
            a = scanner.nextDouble();
            System.out.print("Enter 2nd number: ");
            b = scanner.nextDouble();

            if ((sign == '/' || sign == '4') && a == 0) {
                System.out.println("Zero is not allowed");
                System.out.print("Enter another value for 1st number: ");
                a = scanner.nextDouble();
            }

            if ((sign == '/' || sign == '4') && b == 0) {
                System.out.println("Zero is not allowed");
                System.out.print("Enter another value for 2nd number: ");
                b = scanner.nextDouble();
            }

            displayTotal(a, b, sign);

            System.out.print("\nTry again? [Y/N]: ");
            choice = scanner.next().charAt(0);
        } while (choice == 'Y' || choice == 'y');
    }
}
