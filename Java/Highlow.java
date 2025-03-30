import java.util.Scanner;

class Highlow{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number: ");
        int number = scanner.nextInt();

        int highest = 0;
        int lowest = 0;
        int input;

        System.out.println("Enter " + number + " numbers: ");
        for (int i = 0; i < number; i++) {
            System.out.print("Enter number [" + (i + 1) + "]: ");
            input = scanner.nextInt();
            //if(i == 0)
                //highest = input;
                if (input > highest)
                    highest = input;
                
               // lowest = input;    
                if (input < lowest) 
                    lowest = input;
          
        }
        System.out.println("Highest: " + highest);
        System.out.println("Lowest: " + lowest);
    }
}


