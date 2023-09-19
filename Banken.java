import java.util.Scanner;

public class Banken {
    public static void main(String[] args) throws Exception {  //Start running scanner, initiate exterior loop to always return to the menu unless leaving program, initiate int to hold users bank balance.

        Scanner input = new Scanner(System.in);
        Boolean run = true;
        int balance = 0;

        while (run) { //Welcome user to the bank and show them menu. Only numbers (input as string) 1 - 4 will give valid menu choice, otherwise return to menu.
            System.out.println("\t-------------------------------------\n\t*** WELCOME TO THE BANK OF DAVID! ***\n\t-------------------------------------\n\t Please choose the the options below \n\n\t [1] Check balance\n\t [2] Make a deposit\n\t [3] Make a withdrawal\n\t [4] Exit bank");
            String menuChoice = input.nextLine();

            switch (menuChoice) {
                case "1":  //Show the user their balance
                    System.out.print("\033[H\033[2J");  
                    System.out.flush(); 
                    System.out.println("\n\t Your current balance is SEK" + balance + ".\n\t Press enter to return to the menu...");
                    input.nextLine();
                    System.out.print("\033[H\033[2J");  
                    System.out.flush(); 
                    break;

                case "2":

                    break;

                case "3": 

                    break;

                case "4":
                    System.out.print("\033[H\033[2J");  
                    System.out.flush(); 
                    System.out.println("\n\tThank you for visiting! Please return with more funding for my New World Order soon!");
                    run = false;
                    break;

                default:
                    System.out.print("\033[H\033[2J");  
                    System.out.flush(); 
                    System.out.println("\tThat is not a valid choice! Try again...\n");
                    continue;
            }
        
        }

        input.close();
    }

    public static Boolean isNumber(Scanner input) {
        if (input.hasNextInt())
            return true;      
        else 
            return false;
    }
}