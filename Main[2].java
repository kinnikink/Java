/*
 * Lab 2: Page 148: Problem P-3.43: In the children’s game, Duck, Duck, Goose, a group of children sit in a circle.
One of them is elected “it” and that person walks around the outside of the circle.
The person who is “it” pats each child on the head, saying “Duck” each time,
until randomly reaching a child that the “it” person identifies as “Goose.” At this
point there is a mad scramble, as the “Goose” and the “it” person race around the
circle. Whoever returns to the Goose’s former place first gets to remain in the
circle. The loser of this race is the “it” person for the next round of play. The
game continues like this until the children get bored or an adult tells them it’s
snack time. Write software that simulates a game of Duck, Duck, Goose.

*This program also runs an experimental study in milliseconds depending on the number of players
*Time Complexity: O(n)
*/
import java.util.Arrays;
import java.util.Random;

public class Main {
    
    public static void main(String[] args) {
        //tracks when the simulation/round starts
        long startTime = System.currentTimeMillis();        
        Random r = new Random();
        int numRound = 1; //number of iterations/rounds that the duck duck goose game will have
        
        //this is an array of the children that are playing the game
        String[] names   = {"Alex","Tejash","Abduslam","Trevor","Kevin","Tom","Lucas","Joey","Kelli"};        
        Duck_Duck_Goose[] players = new Duck_Duck_Goose[names.length - 1];
        Duck_Duck_Goose it = null;//player who is "it"
        Duck_Duck_Goose goose;//the goose
        int rand;
                
        //adds the players to the array
        for(int i = 0; i < players.length; i++) {
            do {
            //takes the number of names left in the list and setting it equal to random
            rand = r.nextInt(names.length);
            }//closes do loop on line 35 
            while (Main.contains(players, names[rand]));
            players[i] = new Duck_Duck_Goose(names[rand], i + 1);
        }//closes for loop on line 34
        System.out.println(Arrays.toString(players));
        
        //this for loop checks which child is 'it' during the game
        for(String name : names) {
            if(!Main.contains(players, name)) {
                it = new Duck_Duck_Goose(name, names.length);
                System.out.println(it.toString());
            }//closes if statement on line 46
        }//closes for loop on line 45

        //loop for when the game of duck duck goose starts
        for(int i = 0; i < numRound; i++) {//plays the game for the set number of rounds
            System.out.println("ROUND: " + (i + 1));
            Duck_Duck_Goose pointer = null;
            int count = 0;
            boolean check1, check2;

            do {//circulates around the player circle
                check1 = r.nextBoolean();
                check2 = r.nextBoolean();
                if(count == players.length)
                count = 0; //resets i if it reaches end of array
                pointer = players[count];
                if(check1 || check2)
                System.out.println(pointer.getName() + " is a duck...");
                count++;
            }//closes do loop on line 59
                    
            while(check1 || check2);
            //prints out who is the goose for that round
	    goose = pointer;
	    System.out.println(goose.getName() + " is the GOOSE");

            if(r.nextBoolean()) {//this loop will only run if the goose wins
                System.out.println("The GOOSE won!");
                System.out.println(Arrays.toString(players));     
            }//closes if statment on line 75 
            
            else {//runs if the goose loses
                System.out.println("The GOOSE lost...");
                players[count - 1] = it; //current person that was "it" is now the goose
                it = goose; //goose becomes new "it" 
                System.out.println(Arrays.toString(players) + "\n" + "It: " + it.getName());       
            }//closes else statement on line 79
        }//closes for loop on line 53
            
        //round is over
        System.out.println("GAME OVER!");
                
        //this keeps track of what time the game ended
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Duration:" + duration + " ms");
    }//closes main on line 20
    
    //this makes sure that the array is not empty
    public static boolean contains(Duck_Duck_Goose[] array, String string) {
        for (Duck_Duck_Goose array1 : array) {
            if (array1 != null && array1.getName().equals(string)) {
                return true;
            }//closes if statement on line 98
        }//closes for loop on line 97
        return false;
    }//closes boolean contains on line 96    
}//closes Main class