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
                    System.out.println("\n\n\t Press enter to return to the menu...");
                    userInput.nextLine();
                    System.out.print("\033[H\033[2J");  
                    System.out.flush(); 
                    break;

                case "2":
                    Boolean runDeposit = true;
                    int depositMenuChoice;
                    System.out.print("\033[H\033[2J");  
                    System.out.flush(); 

                    while (runDeposit) {
                        System.out.println("\n\t We now offer a choice of 3 currencies for transactions, choose from:\n\n\t [1] Swedish Kronor\n\t [2] Great British Pounds\n\t [3] Euro\n\t [4] Return to main menu\n\n\t *Whole units only please, we don't do coins! \n\n\t**My soul crushing exchange rates apply");
                        if (isNumber(userInput)) {
                            depositMenuChoice = userInput.nextInt();

                            if (depositMenuChoice == 1){
                                System.out.print("\033[H\033[2J");  
                                System.out.flush(); 
                                System.out.print(choiceOfCurrency("Swedish Kronor")); 

                                if (isNumber(userInput))
                                    balance = balanceUpdate(1, userInput.nextInt(), balance);
                                else {
                                    System.out.println(incorrectInput());
                                    continue;
                                }
                                
                                System.out.print("\033[H\033[2J");  
                                System.out.flush(); 
                                System.out.println(successfulTransaction("SEK"));
                                System.out.println("Please press enter to return to the main menu...");
                                userInput.nextLine();
                                runDeposit = false;
                            }

                            else if (depositMenuChoice == 2) {
                                System.out.print("\033[H\033[2J");  
                                System.out.flush(); 
                                System.out.print(choiceOfCurrency("Great British Pounds"));

                                if (isNumber(userInput)) {
                                    int depositAmount = userInput.nextInt() * 12;
                                    balance = balanceUpdate(1, depositAmount, balance);
                                }
                                else {
                                    System.out.println(incorrectInput());
                                    continue;
                                }
                                
                                System.out.print("\033[H\033[2J");  
                                System.out.flush(); 
                                System.out.println(successfulTransaction("GBP"));
                                System.out.println("Please press enter to return to the main menu...");
                                userInput.nextLine();
                                runDeposit = false;
                            }
                            
                            else if (depositMenuChoice == 3) {
                                System.out.print("\033[H\033[2J");  
                                System.out.flush(); 
                                System.out.print(choiceOfCurrency("Euros"));
                                
                                if (isNumber(userInput)) {
                                    int depositAmount = userInput.nextInt() * 11;
                                    balance = balanceUpdate(1, depositAmount, balance);
                                }
                                else {
                                    System.out.println(incorrectInput());
                                    continue;
                                }
                                
                                System.out.print("\033[H\033[2J");  
                                System.out.flush(); 
                                System.out.println(successfulTransaction("EUR"));
                                System.out.println("Please press enter to return to the main menu...");
                                userInput.nextLine();
                                runDeposit = false;
                            }

                            else if (depositMenuChoice == 4) {
                                runDeposit = false;
                                System.out.print("\033[H\033[2J");  
                                System.out.flush(); 
                            }

                            else {
                                System.out.print("\033[H\033[2J");  
                                System.out.flush(); 
                                System.out.println(incorrectInput());
                                continue;
                            }
                        }
                        else {
                            System.out.print("\033[H\033[2J");  
                            System.out.flush(); 
                            System.out.println(incorrectInput());
                        }
                    }
                    break;

                case "3": 
                    Boolean runWithdrawal = true;
                    int withdrawalMenuChoice;
                    System.out.print("\033[H\033[2J");  
                    System.out.flush(); 

                    while (runWithdrawal) {
                        System.out.println("\n\t We now offer a choice of 3 currencies for transactions, choose from:\n\n\t [1] Swedish Kronor\n\t [2] Great British Pounds\n\t [3] Euro\n\t [4] Return to main menu\n\n\t *Whole units only please, we don't do coins! \n\n\t**My soul crushing exchange rates apply");
                        if (isNumber(userInput)) {
                            withdrawalMenuChoice = userInput.nextInt();

                            if (withdrawalMenuChoice == 1){
                                System.out.print("\033[H\033[2J");  
                                System.out.flush(); 
                                System.out.print(choiceOfCurrency("Swedish Kronor")); 

                                if (isNumber(userInput))
                                    balance = balanceUpdate(1, userInput.nextInt(), balance);
                                else {
                                    System.out.println(incorrectInput());
                                    continue;
                                }
                                
                                System.out.print("\033[H\033[2J");  
                                System.out.flush(); 
                                System.out.println(successfulTransaction("SEK"));
                                System.out.println("Please press enter to return to the main menu...");
                                userInput.nextLine();
                                runDeposit = false;
                            }

                            else if (withdrawalMenuChoice == 2) {
                                System.out.print("\033[H\033[2J");  
                                System.out.flush(); 
                                System.out.print(choiceOfCurrency("Great British Pounds"));

                                if (isNumber(userInput)) {
                                    int depositAmount = userInput.nextInt() * 12;
                                    balance = balanceUpdate(1, depositAmount, balance);
                                }
                                else {
                                    System.out.println(incorrectInput());
                                    continue;
                                }
                                
                                System.out.print("\033[H\033[2J");  
                                System.out.flush(); 
                                System.out.println(successfulTransaction("GBP"));
                                System.out.println("Please press enter to return to the main menu...");
                                userInput.nextLine();
                                runDeposit = false;
                            }
                            
                            else if (withdrawalMenuChoice == 3) {
                                System.out.print("\033[H\033[2J");  
                                System.out.flush(); 
                                System.out.print(choiceOfCurrency("Euros"));
                                
                                if (isNumber(userInput)) {
                                    int depositAmount = userInput.nextInt() * 11;
                                    balance = balanceUpdate(1, depositAmount, balance);
                                }
                                else {
                                    System.out.println(incorrectInput());
                                    continue;
                                }
                                
                                System.out.print("\033[H\033[2J");  
                                System.out.flush(); 
                                System.out.println(successfulTransaction("EUR"));
                                System.out.println("Please press enter to return to the main menu...");
                                userInput.nextLine();
                                runDeposit = false;
                            }

                            else if (withdrawalMenuChoice == 4) {
                                runDeposit = false;
                                System.out.print("\033[H\033[2J");  
                                System.out.flush();
                            }

                            else {
                                System.out.print("\033[H\033[2J");  
                                System.out.flush(); 
                                System.out.println(incorrectInput());
                            }
                        }
                        else {
                            System.out.print("\033[H\033[2J");  
                            System.out.flush(); 
                            System.out.println(incorrectInput());
                        }
                    }
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
                    System.out.println(incorrectInput());
                    break;
            }
        
        }

        userInput.close();
    }

    public static Boolean isNumber(Scanner userInput) {
        if (userInput.hasNextInt())
            return true;      
        else 
            return false;
    }

    public static String incorrectInput() {
        return "\t That is not a valid choice! Try again...\n";
    }

    public static String showBalance(int balance) {
        return "\n\t Your current balance is SEK" + balance + ".";
    }

    public static String choiceOfCurrency(String currency) {
        System.out.print("\033[H\033[2J");  
        System.out.flush();

        if (currency.equals("Swedish Kronor") || currency.equals("Great British Pounds") || currency.equals("Euros"))
            return "\n\tYou have chosen " + currency + "!\n\n\t Please enter the amount you would like to deposit/withdraw: ";
        else 
            return incorrectInput();
    }

    public static int balanceUpdate(int depositOrWithdrawal, int amount, int balance) {
        if (depositOrWithdrawal == 1)
            balance += amount;
        else if (depositOrWithdrawal == 2) {
            if (checkNegativeBalance(balance, amount))
                balance -= amount;
        }           
        return balance;
    }

    public static Boolean checkNegativeBalance (int balance, int amount){
        if (balance - amount > 0)
            return true;
        else    
            return false;
    }

    public static String successfulTransaction (String currency) {
        System.out.print("\033[H\033[2J");  
        System.out.flush();

        if (currency.equals("GBP") || currency.equals("EUR"))
            return "\n\tAfter a generous donation your balance has been updated!\n";
        else 
            return "\n\tThank you! Your balance has been updated!\n";
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