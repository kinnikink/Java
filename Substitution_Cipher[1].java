public class Substitution_Cipher {

    //variables
    public char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    public char[] cipher = new char[26];

    //constructor of the cipher with no input parameters
    public Substitution_Cipher(char [] alphabet){
        this.cipher = alphabet;
    }//closes Substitution_Cipher constructor with no parameters

    //prints out the alphabet and cipher/decryptor next to each other to see the mapping
    public void Compare() {
        for(int i = 0; i<alphabet.length; i++) {
            System.out.print(alphabet[i] + " ");
	}//closes for loop on line 14
	System.out.println("\n");
	for(int i = 0; i<cipher.length; i++) {
            System.out.print(cipher[i] + " ");
	}//closes for loop on line 18
    }//closes Compare()

    //accepts an input string, sends it to a char array, and then translates each entry in the array into the cipher using a switch case.
    //if the input contains spaces or punctuation, it leaves those the same.
    public String Encode(String input) {
        char[] inputArray = input.toUpperCase().toCharArray();//sends input into char array
	char[] outputArray = new char[inputArray.length];//create output array to fill with mapping from cipher/decryptor
	//for each character in the input, builds output array with proper mapping from cipher/decryptor
	for (int i=0; i<inputArray.length; i++) {
            char C = inputArray[i];
            switch (C) {
                case('A'):
		outputArray[i]=cipher[0];
		break;

                case('B'):
		outputArray[i]=cipher[1];
		break;

                case('C'):
		outputArray[i]=cipher[2];
		break;

                case('D'):
		outputArray[i]=cipher[3];
		break;

                case('E'):
		outputArray[i]=cipher[4];
		break;

                case('F'):
		outputArray[i]=cipher[5];
		break;

                case('G'):
		outputArray[i]=cipher[6];
		break;

                case('H'):
		outputArray[i]=cipher[7];
		break;

                case('I'):
		outputArray[i]=cipher[8];
		break;

                case('J'):
                outputArray[i]=cipher[9];
		break;

                case('K'):
		outputArray[i]=cipher[10];
		break;

                case('L'):
		outputArray[i]=cipher[11];
		break;

                case('M'):
		outputArray[i]=cipher[12];
		break;

                case('N'):
		outputArray[i]=cipher[13];
		break;

                case('O'):
		outputArray[i]=cipher[14];
		break;

                case('P'):
		outputArray[i]=cipher[15];
		break;

                case('Q'):
		outputArray[i]=cipher[16];
		break;

                case('R'):
		outputArray[i]=cipher[17];
		break;

                case('S'):
		outputArray[i]=cipher[18];
		break;

                case('T'):
		outputArray[i]=cipher[19];
		break;

                case('U'):
                outputArray[i]=cipher[20];
                break;

                case('V'):
		outputArray[i]=cipher[21];
		break;

                case('W'):
		outputArray[i]=cipher[22];
		break;

                case('X'):
		outputArray[i]=cipher[23];
		break;

                case('Y'):
		outputArray[i]=cipher[24];
		break;

                case('Z'):
		outputArray[i]=cipher[25];
		break;
		default:
		outputArray[i] = inputArray[i];
		}
            }

            //build string "output" from output array
            String output = "";
            for(int j = 0; j<outputArray.length; j++) {
                output +=(outputArray[j]);
            }//closes for loop on line 142
            return output;
    }//closes Encode()

    //This method accepts an input string, sends it to a char array, and translates each entry in the array
    //If the array contains spaces or punctuation, it leaves those the same.
    public String Decode(String input) {
        char[] inputArray = input.toUpperCase().toCharArray();//send input into char array
	char[] outputArray = new char[inputArray.length];//creates output array to return
	//for each character in input, build output array with proper translation from cipher
	for (int i=0; i<inputArray.length; i++) {
            char C = inputArray[i];
            if(C == cipher[0]) {
                outputArray[i]='A';
            }//closes if statement on line 156
            else if (C== cipher[1]) {
                outputArray[i]='B';
            }//closes else if statement on line 159
            else if (C== cipher[2]) {
                outputArray[i]='C';
            }//closes else if statement on line 162
            else if (C== cipher[3]) {
                outputArray[i]='D';
            }//closes else if statement on line 165
            else if (C== cipher[4]) {
                outputArray[i]='E';
            }//closes else if statement on line 168
            else if (C== cipher[5]) {
                outputArray[i]='F';
            }//closes else if statement on line 171
            else if (C== cipher[6]) {
                outputArray[i]='G';
            }//closes else if statement on line 174
            else if (C== cipher[7]) {
                outputArray[i]='H';
            }//closes else if statement on line 177
            else if (C== cipher[8]) {
                outputArray[i]='I';
            }//closes else if statement on line 180
            else if (C== cipher[9]) {
                outputArray[i]='J';
            }//closes else if statement on line 183
            else if (C== cipher[10]) {
                outputArray[i]='K';
            }//closes else if statement on line 186
            else if (C== cipher[11]) {
                outputArray[i]='L';
            }//closes else if statement on line 189
            else if (C== cipher[12]) {
                outputArray[i]='M';
            }//closes else if statement on line 192
            else if (C== cipher[13]) {
                outputArray[i]='N';
            }//closes else if statement on line 195
            else if (C== cipher[14]) {
                outputArray[i]='O';
            }//closes else if statement on 198
            else if (C== cipher[15]) {
                outputArray[i]='P';
            }//closes else if statement on 201
            else if (C== cipher[16]) {
                outputArray[i]='Q';
            }//closes else if statement on line 204
            else if (C== cipher[17]) {
                outputArray[i]='R';
            }//closes else if statement on line 207
            else if (C== cipher[18]) {
                outputArray[i]='S';
            }//closes else if statement on line 210
            else if (C== cipher[19]) {
                outputArray[i]='T';
            }//closes else if statement on line 213
            else if (C== cipher[20]) {
                outputArray[i]='U';
            }//closes else if statement on line 216
            else if (C== cipher[21]) {
                outputArray[i]='V';
            }//closes else if statement on line 219
            else if (C== cipher[22]) {
                outputArray[i]='W';
            }//closes else if statement on line 222
            else if (C== cipher[23]) {
                outputArray[i]='X';
            }//closes else if statement on line 225
            else if (C== cipher[24]) {
                outputArray[i]='Y';
            }//closes else if statement on line 228
            else if (C== cipher[25]) {
                outputArray[i]='Z';
            }//closes else if statement on line 231
            else {
                outputArray[i] = inputArray[i];
            }//closes else on line 234
	}//closes for loop on line 154

        //build string "output" from outputArray
        String output = "";
	for(int j = 0; j<outputArray.length; j++) {
            output +=(outputArray[j]);
        }//closes for loop on line 241
	return output;
    }//closes Decode()

}//closes the main Substitution_Cipher class
