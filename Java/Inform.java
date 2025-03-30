import java.util.Scanner;
        
class Inform{
     public static void main(String[] args){
         Scanner myInput = new Scanner(System.in);
         
         System.out.println("Enter ID Number: ");
         String id = myInput.nextLine();
         
         System.out.println("Enter Name: ");
         String name = myInput.nextLine();
         
         System.out.println("Enter Age: ");
         int age = myInput.nextInt();
        
         myInput.nextLine();
         System.out.println("Enter Birtday: ");
         String birthday = myInput.nextLine();
         
         System.out.println("ID Number: " + id);
         System.out.println("Name: " + name);
         System.out.println("Age: " + age + " (Birthday: " + birthday + ")");
         if (age < 18){           
              System.out.println("Minor: True "); 
         }
         else 
              System.out.println("Minor: False ");    
    }   
}