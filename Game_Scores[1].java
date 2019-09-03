public class Game_Scores{

    public static void main(String[] args) {
        //creates an instance of the class scoreList
        Score_List list1 = new Score_List();

        //I added more than 10 game scores to make sure it only took the top ten scores
        list1.insert("Shelby", 100);
        list1.insert("Kelli", 110);
        list1.insert("Sam", 60);
        list1.insert("Sydnee", 35);
        list1.insert("Taylor", 80);
        list1.insert("Casey", 100);
        list1.insert("Kacie", 55);
        list1.insert("Mackenzie", 10);
        list1.insert("Maddie",40);
        list1.insert("Anna", 50);
        list1.insert("Tyler", 20);
        list1.insert("Ryan", 5);
        list1.insert("Megan", 30);
        list1.insert("Chris", 75);
        list1.insert("Mia", 90);

        //prints out the list from highest score to lowest score
        System.out.println("Top 10 Scores: ");
        list1.printList();
    }//closes main
}//closes Game_Scores
