import java.util.Scanner;

public class Banken {
    public static void main(String[] args) throws Exception {  //Start running scanner, initiate exterior loop to always return to the menu unless leaving program, initiate int to hold users bank balance.

        Scanner userInput = new Scanner(System.in);
        Boolean run = true;
        int balance = 0;

        while (run) { //Welcome user to the bank and show them menu. Only numbers (input as string) 1 - 4 will give valid menu choice, otherwise return to menu.
            System.out.println("\t-------------------------------------\n\t*** WELCOME TO THE BANK OF DAVID! ***\n\t-------------------------------------\n\t Please choose from the options below \n\n\t [1] Check balance\n\t [2] Make a deposit\n\t [3] Make a withdrawal\n\t [4] Exit bank");
            String menuChoice = userInput.nextLine();

            switch (menuChoice) {
                case "1":  //Show the user their balance (Janne; Att lägga det här i egen metod kändes onödigt krångligt men hade kunnat gör det med menuChoice som parameter)
                    System.out.print("\033[H\033[2J");  
                    System.out.flush(); 
                    System.out.println(showBalance(balance)); //Current balance sent to method and returns string to present to user. 
                    userInput.nextLine();
                    System.out.print("\033[H\033[2J");  
                    System.out.flush(); 
                    break;

                case "2":
                    Boolean runDeposit = true;
                    System.out.print("\033[H\033[2J");  
                    System.out.flush(); 

                    while (runDeposit) {
                        System.out.println("\n\t We now offer a choice of 3 currencies for deposits, choose from:\n\n\t [1] SEK Swedish Kronor\n\t [2] £ UK Sterling\n\t [3] € Euro\n\t [4] Return to main menu\n\n\t *My soul crushing exchange rates apply");
                        menuChoice = userInput.nextLine();

                        switch (menuChoice) {
                            case "1":
                                System.out.print("\033[H\033[2J");  
                                System.out.flush(); 
                            break;

                            case "2":
                                System.out.print("\033[H\033[2J");  
                                System.out.flush(); 
                            break;

                            case "3":
                                System.out.print("\033[H\033[2J");  
                                System.out.flush(); 
                            break;

                            case "4":
                                runDeposit = exitMenu(menuChoice);
                                System.out.print("\033[H\033[2J");  
                                System.out.flush(); 
                                break;

                            default:
                                System.out.print("\033[H\033[2J");  
                                System.out.flush(); 
                                System.out.println("\t That is not a valid choice! Try again...\n");
                                break;
                        }
                    }

                case "3": 

                    break;

                case "4":
                    System.out.print("\033[H\033[2J");  
                    System.out.flush(); 
                    run = exitMenu(menuChoice);
                    System.out.println(goodbyeMessage(run));
                    break;

                default:
                    System.out.print("\033[H\033[2J");  
                    System.out.flush(); 
                    System.out.println("\t That is not a valid choice! Try again...\n");
                    break;
            }
        
        }

        userInput.close();
    }

    public static Boolean isNumber(Scanner input) {
        if (input.hasNextInt())
            return true;      
        else 
            return false;
    }

    public static String showBalance(int balance) {
        return "\n\t Your current balance is SEK" + balance + ".\n\n\t Press enter to return to the menu...";
    }

    public static Boolean exitMenu(String menuChoice) {
        if(menuChoice.equals("4"))   
            return false;
        else
            return true;
    }

    public static String goodbyeMessage (Boolean run) {
        if (run == false)
            return "\n\t Thank you for visiting! Please return with more funding for my New World Order soon!\n\n";
        else 
            return "This response is impossible!";
    }
}