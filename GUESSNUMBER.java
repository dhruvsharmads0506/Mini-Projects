import java.util.Scanner;
public class GUESSNUMBER {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
    
        int myNumber = (int)(Math.random()*100);
        int usernumber=0;
        do {
            System.out.println("Guess my number (1-100) :");
            usernumber = input.nextInt();
            if(usernumber==myNumber) {
                System.out.println("WOOHOO...CORRECT NUMBER !!!!");
                break;
            }

            else if( usernumber>myNumber) {
                System.out.println("Your number is too large");
            }
            else {
                System.out.println("Your number is too small");
            }

        
        } while(usernumber>=0);

        System.out.print("My number was :");
        System.out.println(myNumber);
        input.close();
        
        
    }
}
