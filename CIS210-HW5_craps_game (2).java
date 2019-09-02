/* ========================================================================== */
/* PROGRAM: Craps Game
    AUTHOR: <Kelli Kinnikin>
    COURSE NUMBER: <CIS 210>
    COURSE SECTION NUMBER: <01>
    INSTRUCTOR NAME: <Guanyu Tian>
    PROJECT NUMBER: <5>
    DUE DATE: 09/28/2017
SUMMARY:

>Write a program simulates the dice game called Craps. For this project, assume that the game is being played between two players, 
and that the rules are as follows:
1. One of the players goes first. That player announces the size of the bet, and rolls the dice. If the player rolls a
a. 7 or 11, it is called a natural. The player who rolled the dice wins.
b. 2, 3 or 12, it is called craps. The player who rolled the dice loses.
c. If the player’s first roll is any other number (4, 5, 6, 8, 9, or 10), the bet is not 
   immediately decided. Instead, the number that the player rolled becomes the point and he continues to roll the dice until either
   he rolls the point a 2nd time, in which case he wins, or he rolls a 7, in which case he loses. For example, suppose a players
    1st roll is a 6.Then 6 becomes the point. He must roll again. If his next roll were a 3, he would have to roll a 3rd time.
    The point remains 6. He continues to roll the dice until he either gets a 6 (a win) or a 7 (a loss).

2. When a player wins, he collects the bet, and gets to keep the dice and take another turn. Then the play begins again with rule (1)

3. When a player loses, his opponent collects the money that was bet and it becomes the opponent’s turn to roll the dice. The opponent
   starts play again with rule (1)

INPUT:
>No input

OUTPUT:
A roll-by-roll description of what happens as the game is played should be print out on the console and should be written to a file as well.
/* MAIN FUNCTION */
import java.util.Random;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;
public class HW5_craps_game{
    static int whos_turn  = 1;// variable name for which player is currently playing
    static int whos_last = 0; // player who previously played  
    public static void main(String [] args) throws IOException {
        int MAX_NUMBER_OF_WAGERS = 20;
        int Player_1_Money = 1000;// starting wage for player 1
	int Player_2_Money = 1000;// starting wage for player 2
	int wagers = 1;
	PrintWriter outFile =new PrintWriter("game.txt");// print outputs to output file
	System.out.println("Welcome to the game of Craps!");// Welcome message
	System.out.println("Please press \"S\" to start!");
	String start = new String();
	Scanner keyboard = new Scanner(System.in);
	start = keyboard.nextLine();
	while (!(start.equals("S"))) {
            System.out.println("Invalid input: Please press \"S\" to begin!");// Error handling for invalid user input
	    start = keyboard.nextLine();
	}
	while (true) {
            int Player1Roll = RollDice();// Player 1's dice roll
            int Player2Roll = RollDice();// Player 2's dice roll
	    if (whos_turn == 1) {
                Player_1_Money = Player_1_Money - 100;
	    	System.out.println("Player 1 bet $100. Current Balance: " + Player_1_Money);// prints out bet amount as well as player 1's current balance
	    }
	    if (whos_turn == 2) {
                int locked = 0;
	    	if (Player_2_Money < 1000) {// player 2's starting bet has to be less than 100
                                          // bc they only start with $1000
                    Player_2_Money = Player_2_Money - 50;// player 2's money minus $50
                    locked = 1;
                    System.out.println("Player 2 bet $50. Current Balance: " + Player_2_Money);// prints out bet amount as well as player 2's current balance
	    	}
	    	if (Player_2_Money >= 1000 && locked != 1) {
	    	Player_2_Money = Player_2_Money - 150;// player 2's money minus the betting amount($150)
	    	System.out.println("Player 2 bet $150. Current Balance: " + Player_2_Money);
	    	}
	    }
	    String winner = DecideWhoWin(Player1Roll,Player2Roll,outFile);// this function determines which player is the winner
	    System.out.println(winner + " won this round");// prints out who won
	    if (winner.equals("Player 1")) {// this is for when player 1 wins
                if (whos_last == 1) {
                    Player_1_Money = Player_1_Money + 200;// player 1's money plus earnings
	    	}
	    	if (whos_last == 2) {
                    int locked = 0;
                    int tempComp = Player_1_Money + 150;// player 2's money plus $150 they won that round
                    if (tempComp < 1000) {
                        Player_1_Money = Player_1_Money + 50;// player 1's money plus $50
		    	locked = 1;
		    }
		    if (tempComp >= 1000 && locked != 1) {
                        Player_1_Money = Player_1_Money + 150;// Player 1 recieves their money back plus $150
		    }
	    	}
	    	  			
	    }
	    if (winner.equals("Player 2")) {// when player 2 wins
                if (whos_last == 1) {
                    Player_2_Money = Player_2_Money + 100;// player 2 wins an additional $100
	    	}
	    	if (whos_last == 2) {
                    int locked = 0;
                    int tempComp = Player_2_Money + 150;// player 2 wins an additional $150
                    if (tempComp < 1000) {
                        Player_2_Money = Player_2_Money + 100;// player 2 wins an additional $100
		    	locked = 1;
		    }
		    if (tempComp >= 1000 && locked != 1) {
                        Player_2_Money = Player_2_Money + 300;// player 2 wins an additional $300
		    }
	    	}
	    }
	    System.out.println("Player1Money: " + Player_1_Money + "\nPlayer2Money: " + Player_2_Money);
	    if (wagers == MAX_NUMBER_OF_WAGERS  || Player_1_Money <= 0 || Player_2_Money <= 0) {
                break;
	    }
            wagers++;
	}
	AnnounceFinalWinner(Player_1_Money,Player_2_Money,outFile);// prints which player won the game
	System.out.println("Thank you for playing the game of Craps!");//prints closure statement to console
	WriteToFile(outFile,"Thank you for playing the game of Craps!");//prints closure statement to file
	keyboard.close();
	outFile.close();
    }
    /**
   *@param  rand_num
   *@param rolls
   *@return rolls which will be between 1&6
   */
    public static int GenerateRandomNumber() {// Generates the random dice roll of player 1 and player 2
        Random rand_num=new Random();
	int rolls= rand_num.nextInt(6)+1;
	return rolls;
    }
    /**
	 * @param  roll_sum // which returns the dice values added together
	 */
    public static int RollDice() {
        int roll_sum = GenerateRandomNumber() + GenerateRandomNumber();
	return roll_sum;
    }
    /**
	 * @param dice_player1// what player 1 rolls
	 * @param dice_player2// what player 2 rolls
	 * @param pw //to write to the file
	 * @return answer// will determine who plays next
	 * @throws IOException
	 */
    public static String DecideWhoWin(int dice_player1,int dice_player2,PrintWriter pw) throws IOException {
        if ((dice_player1 == 7 || dice_player1 == 11) && whos_turn == 1) {// if a player rolls a 7 or 11, it is called natural and they automatically win
        System.out.println("Player 1 rolled a natural: " + dice_player1);
	System.out.println("That is a natural! Player 1 Wins!");// prints output to console
	WriteToFile(pw,"That is a natural! Player 1 Wins!");// prints output to file
	whos_last = 1;
	whos_turn = 1;
	return "Player 1";
    }
    if ((dice_player1 == 2 || dice_player1 == 3 || dice_player1 == 12) && whos_turn == 1) {// if a player rolls 2,3,12, it is called craps and
        //the player automatically loses
        System.out.println("Player 1 rolled craps: " + dice_player1);
        System.out.println("That is craps! Player 2 Wins!");// prints output to console
	WriteToFile(pw,"That is craps! Player 2 Wins!");//prints output to file
	whos_turn = 2;
	return "Player 2";
    }
    if ((dice_player1 == 4 || dice_player1 == 5 || dice_player1 == 6 || dice_player1 == 8 || dice_player1 == 9 || dice_player1 == 10) && whos_turn == 1) {//becomes the point
        int DicePoint = dice_player1;
	whos_last = 1;
	while (true) {
	int ReRoll = RollDice();
	if (ReRoll == DicePoint) {
            System.out.println("Player 1 rolled point " + ReRoll + " and won!");//prints output to console
            WriteToFile(pw,"Player 1 rolled point " + ReRoll + " and won!");//prints output to file
            whos_turn = 1;
            return "Player 1";
	}
        if (ReRoll == 7) {
            System.out.println("Player 1 rolled point " + ReRoll + " and lost!");//prints output to console
            WriteToFile(pw,"Player 1 rolled point " + ReRoll + " and lost!");//prints output to file
            whos_turn = 2;
            return "Player 2";
            }
	}
    }
    if ((dice_player2 == 7 || dice_player2 == 11) && whos_turn == 2) {// if a player rolls 7 or 11, it is called natural
        System.out.println("That is a natural! Player 2 Wins!");//prints output to console
	WriteToFile(pw,"That is a natural! Player 2 Wins!");//prints output to file
	whos_last = 2;
	whos_turn = 2;
	return "Player 2";
    }
    if ((dice_player2 == 2 || dice_player2 == 3 || dice_player2 == 12) && whos_turn == 2) {// if a player rolls 2,3,12 it is called craps
        System.out.println("That is craps! Player 1 Wins!");//prints output to console
	WriteToFile(pw,"That is craps! Player 1 Wins!");//prints output to file
	whos_last = 2;
	whos_turn = 1;
	return "Player 1";
    }
    if ((dice_player2 == 4 || dice_player2 == 5 || dice_player2 == 6 || dice_player2 == 8 || dice_player2 == 9 || dice_player2 == 10) && whos_turn == 2) {
        // if a player rolls 4,5,6,8,9,or 10, that number becomes a point for current player
        whos_last = 2;
        int DicePoint = dice_player2;
        while (true) {
            int ReRoll = RollDice();
            if (ReRoll == DicePoint) {
                System.out.println("Point win for Player 2!");//prints output to console
                WriteToFile(pw,"Point win for Player 2!");//prints output file
                whos_turn = 2;
                return "Player 2";
            }
            if (ReRoll == 7) {
                System.out.println("Point loss for Player 2!");// prints output to console
                WriteToFile(pw,"Point win loss Player 2!");//prints output to file
                whos_turn = 1;
                return "Player 1";
            }
        }
    }
    return "Error";
    }
    /**
	 * @param money_player1// the total money player 1 has
	 * @param money_player2// the total money player 2 has
	 * @param pw// to output to file
	 * @throws IOException
	 */
    public static void AnnounceFinalWinner(int money_player1, int money_player2, PrintWriter pw) throws IOException {// decides who is the overall winnner
        if(money_player1>money_player2) {
            System.out.println("Player 1 Wins!");// prints output to console
            WriteToFile(pw,"Player 1 Wins!");//print output to file
	}
	else if(money_player1==money_player2) {
            System.out.println("Its a Draw!");//print output to console
            WriteToFile(pw,"Its a Draw!");//print output to file
	}
	else if(money_player1<money_player2) {
            System.out.println("Player 2 Wins!");//print output to console
            WriteToFile(pw,"Player 2 Wins!");//print output to file
	}
    }
    /**
	 * @param pw
	 * @param data
	 * @throws IOException
	 */
    public static void WriteToFile(PrintWriter pw,String data) throws IOException{
        pw.println(data);// prints game info to file
    }
}