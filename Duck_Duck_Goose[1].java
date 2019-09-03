public class Duck_Duck_Goose {
    private String name;
    private int identity;

    //constructor
    public Duck_Duck_Goose(String n, int i) {
        name = n;
        identity = i;
    }//closes Duck_Duck_Goose
        
    //gets the name of the player
    public String getName() {
        return name;
    }//closes getName

    //returns if the person is a duck or a goose
    public int getIdentity() {
        return identity;
    }//closes getIdentity

    //puts the the identity and the name of the player to a string
    public String toString() {
        return identity + ": " + name; 
    }//closes toString
}//closes public class Duck_Duck_Goose