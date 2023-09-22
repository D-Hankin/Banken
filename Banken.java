import java.util.Scanner;

public class Banken {
    public static void main(String[] args) throws Exception {  //Start running scanner, initiate exterior loop to always return to the menu unless leaving program, initiate int to hold users bank balance.

        Scanner userInput = new Scanner(System.in);
        Boolean run = true;
        int balance = 0;

        while (run) { //Welcome user to the bank and show them menu. Only numbers (input as string) 1 - 4 will give valid menu choice, otherwise return to menu.
            System.out.println("\t-------------------------------------\n\t*** WELCOME TO THE BANK OF DAVID! ***\n\t-------------------------------------\n\tPlease choose from the options below \n\n\t [1] Check balance\n\t [2] Make a deposit\n\t [3] Make a withdrawal\n\t [4] Exit bank");
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

                case "2": //User id offered a choce of 3 currencies to make a deposit with. Exchange rates are calculated and the resulting balance is updated (in SEK).
                          //In depositMenu stage users are unable to input letters or any number outside the possible choices. When entering amount to deposit users cannot enter
                          //letters or negative values.
                          //User is kept within deposit menu until choosing to leave. With a successful deposit user is returned to main menu.
                    Boolean runDeposit = true;
                    int depositMenuChoice;
                    System.out.print("\033[H\033[2J");  
                    System.out.flush(); 

                    while (runDeposit) {
                        System.out.println("\n\t We now offer a choice of 3 currencies for transactions, choose from:\n\n\t [1] Swedish Kronor\n\t [2] Great British Pounds\n\t [3] Euro\n\t [4] Return to main menu\n\n\t *Whole units only please, we don't do coins! \n\n\t**My soul crushing exchange rates apply");
                        
                        if (isNumber(userInput)) {
                            depositMenuChoice = userInput.nextInt();

                            if (depositMenuChoice == 1) {
                                System.out.print("\033[H\033[2J");  
                                System.out.flush(); 
                                System.out.print(choiceOfCurrency("deposit Swedish Kronor")); 

                                if (isNumber(userInput)){
                                    int depositAmount = userInput.nextInt();
                                    if (depositAmount > 0)
                                        balance = balanceUpdate(1, depositAmount, balance);
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
                                    continue;
                                }
                                
                                System.out.print("\033[H\033[2J");  
                                System.out.flush(); 
                                System.out.println(successfulTransaction("SEK"));
                                userInput.nextLine();
                                runDeposit = false;
                            }
                            else if (depositMenuChoice == 2) {
                                System.out.print("\033[H\033[2J");  
                                System.out.flush(); 
                                System.out.print(choiceOfCurrency("deposit Great British Pounds"));

                                if (isNumber(userInput)) {
                                    int depositAmount = userInput.nextInt() * 12;
                                    if (depositAmount > 0) {
                                        balance = balanceUpdate(1, depositAmount, balance);
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
                                    continue;
                                }
                                
                                System.out.print("\033[H\033[2J");  
                                System.out.flush(); 
                                System.out.println(successfulTransaction("GBP"));
                                userInput.nextLine();
                                runDeposit = false;
                            }
                            
                            else if (depositMenuChoice == 3) {
                                System.out.print("\033[H\033[2J");  
                                System.out.flush(); 
                                System.out.print(choiceOfCurrency("deposit Euros"));
                                
                                if (isNumber(userInput)) {
                                    int depositAmount = userInput.nextInt() * 11;
                                    if (depositAmount > 0) {
                                        balance = balanceUpdate(1, depositAmount, balance);
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
                                    continue;
                                }
                                
                                System.out.print("\033[H\033[2J");  
                                System.out.flush(); 
                                System.out.println(successfulTransaction("EUR"));
                                userInput.nextLine();
                                runDeposit = false;
                            }
                            else if (depositMenuChoice == 4) {
                                runDeposit = false;
                                System.out.print("\033[H\033[2J");  
                                System.out.flush(); 
                                break;
                            }
                            else {
                                System.out.print("\033[H\033[2J");  
                                System.out.flush(); 
                                System.out.println(incorrectInput());
                                userInput.nextLine();
                            }
                        }
                        else {
                            System.out.print("\033[H\033[2J");  
                            System.out.flush(); 
                            System.out.println(incorrectInput());
                            userInput.nextLine();
                        }
                    }
                    break;

                case "3": //User id offered a choce of 3 currencies to make a deposit with. Exchange rates are calculated and the resulting balance is updated (in SEK).
                          //In withdrawalMenu stage users are unable to input letters or any number outside the possible choices. When entering amount to withdraw users cannot enter
                          //letters or negative integers.
                          //User is kept in withdrawal menu (i.e. in  the case of invalid inputs) until choosing to leave. After a successful withdrawal user returns to main menu.
                    Boolean runWithdrawal = true;
                    int withdrawalMenuChoice;
                    System.out.print("\033[H\033[2J");  
                    System.out.flush(); 

                    while (runWithdrawal) {
                        System.out.println("\n\t We now offer a choice of 3 currencies for transactions, choose from:\n\n\t [1] Swedish Kronor\n\t [2] Great British Pounds\n\t [3] Euro\n\t [4] Return to main menu\n\n\t *Whole units only please, we don't do coins! \n\n\t**My soul crushing exchange rates apply");
                        if (isNumber(userInput)) {
                            withdrawalMenuChoice = userInput.nextInt();
                            int checkIfBalanceHasChanged = balance;

                            if (withdrawalMenuChoice == 1){
                                System.out.print("\033[H\033[2J");  
                                System.out.flush(); 
                                System.out.print(choiceOfCurrency("withdraw Swedish Kronor")); 

                                if (isNumber(userInput)) {
                                    int withdrawalAmount = userInput.nextInt();
                                    if (withdrawalAmount > 0) {
                                        if (withdrawalAmount != 0)
                                            balance = balanceUpdate(2, withdrawalAmount, balance);
                                    }
                                    else {
                                        System.out.print("\033[H\033[2J");  
                                        System.out.flush(); 
                                        System.out.println(incorrectInput());
                                        continue;
                                    }
                                }
                                else {
                                    System.out.println(incorrectInput());
                                    continue;
                                }
                                
                                System.out.print("\033[H\033[2J");  
                                System.out.flush(); 

                                if (checkIfBalanceHasChanged != balance) {
                                    System.out.println(successfulTransaction("SEK"));
                                    userInput.nextLine();
                                    runWithdrawal = false;
                                }
                                else {
                                    System.out.println(attemptAtNegativeBalance());
                                    continue;
                                } 
                            }

                            else if (withdrawalMenuChoice == 2) {
                                System.out.print("\033[H\033[2J");  
                                System.out.flush(); 
                                System.out.print(choiceOfCurrency("withdraw Great British Pounds"));

                                if (isNumber(userInput)) {
                                    int withdrawalAmount = userInput.nextInt() * 12;
                                    if (withdrawalAmount > 0) {
                                        if (withdrawalAmount != 0)
                                            balance = balanceUpdate(2, withdrawalAmount, balance);
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
                                    continue;
                                }
                                
                                System.out.print("\033[H\033[2J");  
                                System.out.flush(); 

                                if (checkIfBalanceHasChanged != balance) {
                                    System.out.println(successfulTransaction("GBP"));
                                    userInput.nextLine();
                                    runWithdrawal = false;
                                }
                                else {
                                    System.out.println(attemptAtNegativeBalance());
                                    continue;
                                } 
                            }                            
                            else if (withdrawalMenuChoice == 3) {
                                System.out.print("\033[H\033[2J");  
                                System.out.flush(); 
                                System.out.print(choiceOfCurrency("withdraw Euros"));

                                if (isNumber(userInput)) {
                                    int withdrawalAmount = userInput.nextInt() * 11;
                                    if (withdrawalAmount > 0) {
                                        if (withdrawalAmount != 0)
                                            balance = balanceUpdate(2, withdrawalAmount, balance);
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
                                    continue;
                                }
                                
                                System.out.print("\033[H\033[2J");  
                                System.out.flush(); 

                                if (checkIfBalanceHasChanged != balance) {
                                    System.out.println(successfulTransaction("EUR"));
                                    userInput.nextLine();
                                    runWithdrawal = false;
                                }
                                else {
                                    System.out.println(attemptAtNegativeBalance());
                                    continue;
                                }                              
                            }
                            else if (withdrawalMenuChoice == 4) {
                                runWithdrawal = false;
                                System.out.print("\033[H\033[2J");  
                                System.out.flush();
                            }
                            else {
                                System.out.print("\033[H\033[2J");  
                                System.out.flush(); 
                                System.out.println(incorrectInput());
                                userInput.nextLine();
                            }
                        }
                        else {
                            System.out.print("\033[H\033[2J");  
                            System.out.flush(); 
                            System.out.println(incorrectInput());
                            userInput.nextLine();
                        }
                    }
                    break;

                case "4": //User exits program.
                    System.out.print("\033[H\033[2J");  
                    System.out.flush(); 
                    run = exitMenu(menuChoice);
                    System.out.println(goodbyeMessage(run));
                    break;

                default: //Main menu is shown with all invalid inputs when in main menu.
                    System.out.print("\033[H\033[2J");  
                    System.out.flush(); 
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
        return "\tThat is not a valid choice! Try again...\n";
    }

    public static String showBalance(int balance) {
        return "\n\t Your current balance is SEK" + balance + ".";
    }

    public static String choiceOfCurrency(String currency) {
        System.out.print("\033[H\033[2J");  
        System.out.flush();

        if (currency.equals("deposit Swedish Kronor") || currency.equals("deposit Great British Pounds") || currency.equals("deposit Euros") || currency.equals("withdraw Swedish Kronor") || currency.equals("withdraw Great British Pounds") || currency.equals("withdraw Euros"))
            return "\n\tYou have chosen to " + currency + "!\n\n\t Please enter the amount you would like to deposit/withdraw: ";
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
        if (balance - amount >= 0)
            return true;
        else    
            return false;
    }

    public static String attemptAtNegativeBalance() {
        return "\n\tTrying to withdraw money you don't have?? This isn't a charity you know!";
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
            return "\n\tThank you for visiting! Please return with more funding for my New World Order soon!\n\n";
        else 
            return "How did you get here Janne? This response should be impossible!";
    }
}