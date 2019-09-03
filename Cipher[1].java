import java.util.*;

public class Cipher {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
	char[] cipher = {'Q','W','E','R','T','Y','U','I','O','P','A','S','D','F','G','H','J','K','L','Z','X','C','V','B','N','M'};

	//constructs the cipher
	Substitution_Cipher cipher1 = new Substitution_Cipher(cipher);
	System.out.println("Enter a sentence.");//asks the user to input the sentence they want to encrypt
	String input = keyboard.nextLine();
	System.out.print("\n");

        //calls the encoding process
	String Encoded =cipher1.Encode(input);
	System.out.println(Encoded);
	System.out.print("\n");

        //calls the decoding process
	String Decoded =cipher1.Decode(Encoded);
	System.out.println(Decoded);
	System.out.print("\n");

        //compares the decrypt call to the encrypt call and vice versa
	cipher1.Compare();
	keyboard.close();
	}//closes main class
}//closes Cipher class
