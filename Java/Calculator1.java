import java.util.Scanner;

public class Calculator1{
    public static void main(String[] args) {
        int a, b, n, sum, sub, mul, div;
        Scanner scanner = new Scanner(System.in);

        System.out.println("[Calculator using switch]\n");
        System.out.print("Enter a number: ");
        a = scanner.nextInt();
        System.out.print("Enter a number: ");
        b = scanner.nextInt();

        System.out.println();
        System.out.println("Enter 1 for sum");
        System.out.println("Enter 2 for subtraction");
        System.out.println("Enter 3 for multiplication");
        System.out.println("Enter 4 for division");
        n = scanner.nextInt();

        switch (n) {
            case 1:
                sum = a + b;
                System.out.println("Sum = " + sum);
                break;
            case 2:
                sub = a - b;
                System.out.println("Subtraction = " + sub);
                break;
            case 3:
                mul = a * b;
                System.out.println("Multiplication = " + mul);
                break;
            case 4:
                div = a / b;
                System.out.println("Division = " + div);
                break;
            default:
                System.out.println("Invalid Input");
        }
    }
}
