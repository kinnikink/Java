package HW4_SlotMachineSimulation;

/* ========================================================================== */
 /*	PROGRAM Slot Machine Simulation
    AUTHOR: <Kelli Kinnikin and Alex Grant>
    COURSE NUMBER: <CIS210>
    COURSE SECTION NUMBER: <01>
    INSTRUCTOR NAME: <Guanyu Tian>
    PROJECT NUMBER: 4
    DUE DATE: 09/21/2017
SUMMARY:
>Create a program that simulates a slot machine. When the program runs, it should do the following:

- Read in the initial amount of money a user wants to enter into the slot.

-Ask the user to enter the amount of money he or she wants to bet. The amount of money
must be a multiple of $10. The minimum is $10 and maximum is the amount of money
the user currently has.

>Display a menu for the user to select a word from the following list:
1.Cherry 2.Orange 3.Apple 4.Peach 5.Melon 6.Pear

>Ask the user to select one word by entering the number between 1 and 6

> Randomly select a word from the above list three times and display all three of the words

>If none of the randomly selected words match, the program will inform the user that he orshe has won $0.
If one of the words match, the program will inform the user that he or she has won one time of the amount
entered. If two of the words match, the program will inform the user that he or she has won two times the
amount entered. If three of the words match, the program will inform the user that he or she has won three
times the amount entered.

>The program will ask whether the user wants to play again. If so, these steps are repeated. If not, the program displays the
total amount of money entered into the slot machine and the total amount won.

INPUT:
This program requires that you read in the following data values:
The amount of money a user owns initially. It is read from a input file named input.txt .Whether or not a user wants to play
The amount of money he wants to bet each time
The word a user selects

OUTPUT:
>The amount of money the user bets
>The word the user selects
>The three words the slot machine randomly selects
>The amount of money the user wins if any
>Whether or not the user wants to continue play
>The amount of money the user wins or lose if he or she quits
>Greeting messages
/* MAIN FUNCTION */
import java.io.*; //Import for input/output data streams/file system
import java.util.Scanner; //Import Scanner Object	
import java.util.Random; //Import Random number Generator Object

public class HW4_SlotMachineSimulation{

    public static void main(String[] args) throws IOException {
        char repeat_game = 'y'; // determines if the user wants to play again or not
        String availableMoneyWord;//Used to read in the starting amount from the file
        double starting_amount;	
        double available_amount;//Variable used to record the amount that is currently available to bet
        double betting_amount;// Used to record amount the user will bet
        double amount_won;// Used to record the amount of money won from the slot machine
        double net_loss;//Records the detuctables of the user
        double net_gain;//Records the earnings of the user
        int match_count = 0;//This is the inital variablr that keeps track of the number of matches
        int rand_num;
        final String[] FRUIT_SELECTION = {"Cherry", "Orange", "Apple", "Peach", "Melon", "Pear"}; ///Names  possible fruit selections
        final int[] FRUIT_NUMBERS = {1, 2, 3, 4, 5, 6};	//Numbers of randomly generated fruit
        final double MINIMAL_AMOUNT = 10;//$10 is the minimum amount the user must bet
        final int SMALLEST_OPTION = 1;//Minimum number the user can pick from
        final int BIGGEST_OPTION = 6;//Maximum number the user can pick from
        int user_fruit_selection;

        File moneyFile = new File("input.txt");
        Scanner available_money = new Scanner(moneyFile);
        //2nd Scanner for the fruits the user picked
        Scanner user_fruit_picked = new Scanner(System.in);
        //3rd Scanner for the fruits the user picked
        Scanner user_betting_amount = new Scanner(System.in);
        //4th Scanner which allows the user to decide if they want to play again
        Scanner char_decision = new Scanner(System.in);
        //Used to input info into String from input file
        availableMoneyWord = available_money.nextLine();
        available_amount = Double.parseDouble(availableMoneyWord);
        starting_amount = available_amount;
        Random fruit_generator = new Random();
        PrintWriter delete_content = new PrintWriter("output.txt");
        delete_content.println("Start:");
        delete_content.close();
        FileWriter appendVar = new FileWriter("output.txt", true);
        PrintWriter outputFile = new PrintWriter(appendVar);
        while (repeat_game != 'n' && repeat_game != 'N' && available_amount > 0) {
            System.out.println("Welcome to Guanyu Tian's Slot Machine!");
            outputFile.println("Welcome to Guanyu Tian's Slot Machine!");
            System.out.printf("You inserted $%.2f\n", starting_amount);
            outputFile.printf("You inserted $%.2f. ", starting_amount);
            
            //This prints out the current available amount
            System.out.printf("You currently have $%.2f, you can bet in multiples of $10\n", available_amount);
            outputFile.printf("You currently have $%.2f, you can bet in multiples of $10.\r\n", available_amount);
            System.out.println("If you enter 1, you will bet $10");
            outputFile.println("If you enter 1, you will bet $10. ");
            System.out.println("If you enter 2, you will bet $20, etc.");
            outputFile.println("If you enter 2, you will bet $20, etc. ");
            System.out.printf("Please enter how much you would like to bet:");
            outputFile.println("Please enter how much you would like to bet: ");

            betting_amount = user_betting_amount.nextDouble();
            while (betting_amount < 1 || betting_amount * 10 > available_amount) {
                if (betting_amount < 1) {
                    System.out.println("This is less than 10. Please enter a number that is 1 or greater.\n");
                    outputFile.println("This is less than 10. Please enter a number that is 1 or greater.\n");
                }
                else if (betting_amount * 10 > available_amount) {
                    System.out.println("This is greater than the availabe amount. Please enter a number that is greater than the available amount.\n");
                    outputFile.println("This is greater than the availabe amount. Please enter a number that is greater than the available amount.\n");
                }
                betting_amount = user_betting_amount.nextDouble();
            }
            betting_amount *= MINIMAL_AMOUNT;
            outputFile.printf("Betting Amount: $%.2f. ", betting_amount);
            System.out.printf("Betting Amount: $%.2f.\n", betting_amount);

            //Asks the user what fruit they would like to bet
            System.out.println("1. Cherry | 2. Orange | 3. Apple | 4. Peach | 5. Melon | 6. Pear");
            System.out.println("Please enter the number associated with which fruit you want to choose: ");
            user_fruit_selection = user_fruit_picked.nextInt();

            //Checks if the user input entered is between 1 and 6
            while (user_fruit_selection < SMALLEST_OPTION || user_fruit_selection > BIGGEST_OPTION) {
                System.out.println("The number you have entered does not exist.");
                System.out.println("Please try again: ");
                outputFile.println("The number you have entered does not exist.");
                outputFile.println("Please try again: ");
                user_fruit_selection = user_fruit_picked.nextInt();
            }
            //Prints out the word that was selected by the user to the file
            outputFile.println("Fruit chosen: " + FRUIT_SELECTION[user_fruit_selection - 1] + " ");	
            System.out.println("Fruit chosen: " + FRUIT_SELECTION[user_fruit_selection - 1] + " ");
            System.out.print("Result: ");
            outputFile.print("Result: ");

            for (int i = 0; i < 3; i++) {
                rand_num = fruit_generator.nextInt(6);
                //This increases the number of matching fruits if the random number is = to the user number
                if (FRUIT_NUMBERS[rand_num] == user_fruit_selection) {
                    match_count += 1;
                }
                System.out.print(" " + FRUIT_SELECTION[rand_num]);
                outputFile.print(" " + FRUIT_SELECTION[rand_num]);
            }
            outputFile.print("\r\n");
            //This assigns the match count times the betting amount to the variable
            amount_won = match_count * betting_amount;
            switch (match_count) {
                //Prints out the number of matches
                case 1:
                    System.out.print("\nOne of the randomly selected words matched yours.");
                    System.out.printf("You won $%.2f\n", amount_won);
                    outputFile.print("\nOne of the randomly selected words matched yours.");
                    outputFile.printf("You won $%.2f\n", amount_won);
                    break;
                case 2:
                    System.out.print("\nTwo of the randomly selected words matched yours.");
                    System.out.printf("You won $%.2f\n", amount_won);
                    outputFile.print("\nTwo of the randomly selected words matched yours.");
                    outputFile.printf("You won $%.2f\n", amount_won);
                    available_amount += amount_won;
                    break;
                case 3:
                    System.out.print("\nAll three of the randomly selected words matched yours.");
                    System.out.printf("You won $%.2f\n", amount_won);
                    outputFile.print("\nAll three of the randomly selected words matched yours.");
                    outputFile.printf("You won $%.2f\n", amount_won);
                    available_amount += amount_won;
                    break;
                    default:
                    System.out.print("\nNone of the randomly selected words matched yours.");
                    System.out.printf("You won $%.2f\n", amount_won);
                    outputFile.print("\nNone of the randomly selected words matched yours.");
                    outputFile.printf("You won $%.2f\n", amount_won);
                    available_amount -= betting_amount;
                    break;
            }
           System.out.printf("\r\nNew available amount: $%.2f\r\n", available_amount);
            outputFile.printf("\r\nNew available amount: $%.2f\r\n", available_amount);
            if (starting_amount - available_amount <= 0) {
                net_gain = available_amount - starting_amount;
                //This outputs to the file the amount won
                outputFile.printf("Earnings if user quits: $%.2f. ", net_gain);
            } //This sets the net loss as the starting amount - available amount and outputs the net loss
            //if the starting amount - the available amount is greater than or equal to 0
            else if (starting_amount - available_amount >= 0) {
                net_loss = starting_amount - available_amount;
                //This outputs to the file the amount lost
                outputFile.printf("Deductables if user quits: $%.2f. ", net_loss);
            }
            // Asks the user if he or she wants to play again
            System.out.print("Do you want to continue playing (y/Y) or quit (n/N): ");
            outputFile.print(" Do you want to continue playing (y/Y) or quit (n/N): ");
            repeat_game = char_decision.nextLine().trim().charAt(0);
            while (repeat_game != 'y' && repeat_game != 'Y' && repeat_game != 'n' && repeat_game != 'N') {
                System.out.println("Invalid character. Please enter y/y or n/N: ");
                repeat_game = char_decision.nextLine().trim().charAt(0);
                outputFile.println("Invalid character. Please enter y/y or n/N:\r\n");
            }
            //This outputs to the file the user's choice
            outputFile.print("User Choice: " + repeat_game + " ." + "\r\n");
            // Resets the fruit matches to 0
            match_count = 0;
        }
        //Closes Scanner Objects and Files
        System.out.println("Your current money balance: $" + available_amount);
        System.out.println("Money gained/lost: $" + (available_amount - starting_amount));
        outputFile.println("Money gained/lost: $" + (available_amount - starting_amount));
        user_fruit_picked.close();
        available_money.close();
        user_betting_amount.close();
        char_decision.close();
        // Prints out the message that the user is out of money
        if (available_amount == 0) {
            System.out.println("Sorry, you ran out of money.\n");
            outputFile.println("Sorry, you ran out of money.\r\n");
        }
        System.out.print("Thank you for choosing Guanyu Tian's Slot Machine!");
        outputFile.println("Thank you for choosing Guanyu Tian's Slot Machine!");
        outputFile.close();
    }
}