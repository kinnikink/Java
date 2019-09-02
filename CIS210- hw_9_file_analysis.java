/* ========================================================================== */

/*  PROGRAM File Analysis
    AUTHOR: <Kelli Kinnikin>
    COURSE NUMBER: <CIS 210>
    COURSE SECTION NUMBER: <01>
    INSTRUCTOR NAME: <Guanyu Tian>
    PROJECT NUMBER: <9>
    DUE DATE: 11/16/2017
    
SUMMARY:
> You are required to write a program to read the content of an input file named input.txt and 
thenwrite the following statistics into an output file named output.txt:
~The content of the input file
~The number of lines
~The number of words
    Note: the character ’ is one word. For example, the phrase “that’s” contains two words.
~The number of sentences
    Every sentence ends with either a period or semicolon.
~The number of punctuation characters
   Punctuation is anything that neither an alphabet nor a digit
~The number of alphabet characters
~The number of digit characters
~The number of whitespace characters
~The number of words that start with uppercase letter
~The frequency of words (case insensitive). Please display and write the frequency of
 words as a list.
    Frequency of a word shows the number of occurrences of a word in the input file.
~For example, this sentence “The sun is so nice in the morning” has the following
frequency of words (case insensitive):
        the: 2
        sun: 1
        is: 1
        so: 1
        in: 1
        morning: 1

INPUT:
> This program requires that you read in data from an input file input.txt. You must ask the user
to enter this file name. If the file doesn’t exist, then display a warning message and quit the
program.

OUTPUT:
> Your program should display the following on the console and write it to an output
file named output.txt: (Please ask the user to enter an output file name)
    The content of the file.
    The number of words.
    The number of sentences.
    The number of alphabet characters.
    The number of punctuation characters.
    The number of digit characters.
    The number of whitespaces.
    The number of words that start with uppercase letter.
    The frequency of words.
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.*;

public class File_analysis {
    public static void main(String[] args) throws IOException {
        //this initializes an inputFileName String
        String inputFileName;
        //this initiates a scanner object for reading in the text file
        Scanner input = new Scanner(System.in);
	System.out.print("Please type the name of the input file: ");
	inputFileName = input.nextLine();
	//destroys the scanner object after file import
	input.close();
	
        //creates a string array for the ReadInputFile Method
	String stringArray[] = ReadInputFile(inputFileName);
	ArrayList<String> stringArrayList = ConvertToArrayList(stringArray);
	//initializes the upper-case letters that are inside of the stringArray
	
        int uppercase_counter = CountWordStartingWithUpperCase(stringArray);
	//stores the word frequency inside of the stringArray to the doubleArray variable
	String wordFreqArray[][] = CountWordFrequency(stringArrayList);//calls CountWordFrequency method
	//stores the word count inside of the stringArray to the word_counter variable and calls CountWords method
	int word_counter = CountWords(stringArray);	
	//stores the digits inside of the stringArray to the digit_counter variable and calls CountDigit method
	int digit_counter = CountDigits(stringArray);	
	//stores all of the letters inside of the stringArray to the alphabet_counter variable
	int alphabet_counter = CountAlphabet(stringArray);//calls CountAlphabet method	
	//stores the number of sentences inside of the stringArray to the sentenceCounter var
	int sentence_counter = CountSentences(stringArray);//calls CountSentences method	
	//stores the punctuation count inside of the stringArray to the punctuation_counter variable
	int punctuation_counter = CountPunctuation(stringArray);//calls CountPunctuation method	
	//stores the number of white-spaces inside of the stringArray to the whitespace_counter variable
	int whitespace_counter = Whitespace(stringArray);//calls Whitespace method	
	//stores the number of lines inside of the stringArray to the line_counter variable
	int line_counter = CountLines(stringArray, inputFileName);//calls CountLines method	
	
        //stores all of the data that was stored into the previous variables, into a single variable with those exact parameters
        OutputData(uppercase_counter, wordFreqArray, stringArray, word_counter, digit_counter, alphabet_counter, sentence_counter, punctuation_counter, whitespace_counter, line_counter);
	}//calls OutputData method
	/**
	 * Converts the string array into an array list that contains each word
	 * in each element.
	 * @param stringArray
	 * @return
	 */
	public static ArrayList<String> ConvertToArrayList(String stringArray[]) {
            ArrayList<String> stringArrayList = new ArrayList<String>();//Creates a String Array List
            //the wordArray String Array counts the amount of words used in program
            //splits the words based on : certain punctuations and (white-space)
            //splits contractions into two words each.
            for(int i=0; i<stringArray.length; i++) {
                //splits the stringArray element into sub strings of string array based on the given characters
                String [] wordArray = stringArray[i].toLowerCase().split("[!?\\/*+=:,.;\\s]+");
                for(int j=0; j<wordArray.length; j++) {//j is set to 0 and incremented
                    //if the word array contains "'t", then it splits it into two words:
                    //first part of word and "not" and adds it to the array list
                    if(wordArray[j].contains("'t")){
                        String contractionWords [] = wordArray[j].split("[']");
                        stringArrayList.add(contractionWords[0]);
                        stringArrayList.add("not");
                    }
                    //if the word array contains "'s", then it splits it into two words:
                    //first part of word and "is" and adds it to the array list
                    else if(wordArray[j].contains("'s")) {
                        String contractionWords [] = wordArray[j].split("[']");
                        stringArrayList.add(contractionWords[0]);
                        stringArrayList.add("is");
                    }
                    //if the word array contains "'re", then it splits it into two words:
                    //first part of word and "are" and adds it to the array list
                    else if(wordArray[j].contains("'re")) {
                        String contractionWords [] = wordArray[j].split("[']");
                        stringArrayList.add(contractionWords[0]);
                        stringArrayList.add("are");
                    }
                    //if the word array contains "'m", then it splits it into two words:
                    //first part of word and "am" and adds it to the array list
                    else if(wordArray[j].contains("'m")) {
                        String contractionWords [] = wordArray[j].split("[']");
                        stringArrayList.add(contractionWords[0]);
                        stringArrayList.add("am");
                    }
                    //if the word array contains "'ll", then it splits it into two words:
                    //first part of word and "will" and adds it to the array list
                    else if(wordArray[j].contains("'ll")) {
                        String contractionWords [] = wordArray[j].split("[']");
                        stringArrayList.add(contractionWords[0]);
                        stringArrayList.add("will");
                    }
                    //if the word array contains "'d", then it splits it into two words:
                    //first part of word and "would" and adds it to the array list
                    else if(wordArray[j].contains("'d")) {
                        String contractionWords [] = wordArray[j].split("[']");
                        stringArrayList.add(contractionWords[0]);
                        stringArrayList.add("would");
                    }
                    //if the word array contains "'ve", then it splits it into two words:
                    //first part of word and "have" and adds it to the array list
                    else if(wordArray[j].contains("'ve")) {
                        String contractionWords [] = wordArray[j].split("[']");
                        stringArrayList.add(contractionWords[0]);
                        stringArrayList.add("have");
                    }
                    //if all other conditions fail, just add the word to the array list
                    else {
                        stringArrayList.add(wordArray[j]);
                    }
                }
            }
            return stringArrayList;
	}
	/**
	 * This outputData method is used to print all 
	 * of the information gathered, to the console
	 * @param doubleArray
	 * @param stringArray
         * @param line_counter
         * @param digit_counter
         * @param whitespace_counter
         * @param sentence_counter
         * @param uppercase_counter
	 * @param alphabet_counter
	 * @param punctuation_counter
         * @param word_counter
	 */
	public static void OutputData(int uppercase_counter,  String word_freqArray[][], String [] stringArray,
        int word_counter,int digit_counter, int alphabet_counter, int sentence_counter, 
	int punctuation_counter, int whitespace_counter, int line_counter) throws IOException {
            //creates an output.txt file for the data to be stored into
            PrintWriter output = new PrintWriter("output.txt");
            //this for loop makes sure that while the counter is less than the length of the stringArray, to print the length of what is in the input file 
            for(int i=0; i < stringArray.length; i++){
                output.print(stringArray[i]+"\r\n");//prints out to the console
            }	
            System.out.println("---------------------------------------------------------------------");
            output.println("---------------------------------------------------------------------");
            System.out.println("The total number of lines in the files: "+ line_counter );
            output.println("The total number of lines in the files: "+ line_counter );
            System.out.println("The total number of digits in the files: "+ digit_counter);
            output.println("The total number of digits in the files: "+ digit_counter);
            System.out.println("The total number of whitespaces in the files: "+ whitespace_counter);
            output.println("The total number of whitespaces in the files: "+ whitespace_counter);
            System.out.println("The total number of sentences in the files: "+ sentence_counter);
            output.println("The total number of sentences in the files: "+ sentence_counter);
            System.out.println("The total number of uppercase in the files: "+ uppercase_counter);
            output.println("The total number of uppercase in the files: "+ uppercase_counter);
            System.out.println("The total number of alphabets in the files: "+ alphabet_counter);
            output.println("The total number of alphabets in the files: "+ alphabet_counter);
            System.out.println("The total number of punctuation in the files: "+ punctuation_counter);
            output.println("The total number of punctuation in the files: "+ punctuation_counter);
            System.out.println("The total number of words in the files: "+ word_counter);
            output.println("The total number of words in the files: "+ word_counter);
            System.out.println("---------------------------------------------------------------------");
            output.println("---------------------------------------------------------------------"); 
            //this for loop will print out the frequency of words to the console
            //while the counter is less than the length of the doubleArray
            for(int i=0; i < word_freqArray.length; i++){
                if(word_freqArray[i][0] != null) {//if the element of the array is empty or null
                    output.println(word_freqArray[i][0]+": "+word_freqArray[i][1]+"\r\n");
		}
            }
            output.close();
	}
        /**
	 * CountLines method counts the amount of lines that were 
	 * in the file (that were stored into num_of_lines)
	 * @param stringArray
	 * @param inputFileName
	 * @return
	 * @throws IOException
	 */
	public static int CountLines(String [] stringArray, String inputFileName) throws IOException{
            //declares and initializes to zero the integer variable representing the number of lines
            int num_of_lines = 0;		
            File f = new File(inputFileName);//creates the input file to be used for counting the lines
            Scanner fileCount = new Scanner(f);
            while(fileCount.hasNextLine()) {//counts the number of lines in a file while there is a next line
                fileCount.nextLine();//read next line of file
                num_of_lines++;//increment line counter
            }
            fileCount.close();		
            return num_of_lines;
	}	
	/**
	 * ReadInputFile is designed to only read 
	 * in the information from the file that is imported
	 * @param inputFileName
	 * @return
	 * @throws IOException
	 */
	public static String[] ReadInputFile (String inputFileName) throws IOException {
            //declares and initializes the integer variable representing the number of lines
            int num_of_lines = 0;	
            File f = new File(inputFileName);//creates scanner to read in the data from the file
            Scanner fileCount = new Scanner(f);	
            while(fileCount.hasNextLine()) {//while there's a next line of text,count that towards the total number of lines in file
                fileCount.nextLine();
		num_of_lines++;
            }
            fileCount.close();	
            Scanner fileInput = new Scanner(f); //scanner reads in the num_of_lines from fileCount and stores it into a string array
            String [] stringArray = new String[num_of_lines];
            int i = 0;//declares and initializes to zero the integer variable representing the counter
            while(fileInput.hasNextLine()) {  //increments the String Array while it has more lines of data that need to be read
                stringArray[i] = fileInput.nextLine();
		i++;
            }
            fileInput.close();
            return stringArray;
	}	
	/**
	 * CountDigits is designed to count the number 
	 * of digits that were inside the imported file
	 * @param stringArray
	 * @return
	 */
	public static int CountDigits(String [] stringArray) {
            int digitCount = 0;//declares and initializes to zero the integer variable that counts the digits
            //counts the number of digits while i is less than the stringArray's length
            for(int i =0; i<stringArray.length; i++) {//i starts at zero and increments
                //while j is less than string array
		for(int j =0; j<stringArray[i].length(); j++) {	//j starts at zero and increments
                    if(Character.isDigit(stringArray[i].charAt(j))) { //if the character at the current element is a digit, increment the digit counte
                        digitCount++;
                    }
		}
            }
            return digitCount;
	}
        /**
	 * This method is used to count the white-spaces in between words
	 * @param stringArray
	 * @return
	 */
	public static int Whitespace(String [] stringArray) {
            int whitespaceCount = 0;
            for(int i=0; i<stringArray.length; i++) {
                for(int j=0; j<stringArray[i].length(); j++) {
                    if(stringArray[i].charAt(j) == ' ') {
                        whitespaceCount++;
                    }
		}
            }
            return whitespaceCount;
	}
        /**
	 * CountSentences method is used to calculate the amount of sentences
 	 * that are in the imported file. Number of sentences
 	 * will be determined by the ending punctuation
	 * @param stringArray
	 * @return
	 */
	public static int CountSentences(String [] stringArray) {
            int sentenceCount = 0;
            for(int i=0; i<stringArray.length; i++) {
                for(int j=0; j<stringArray[i].length(); j++) {
                    if(stringArray[i].charAt(j) == '.') {
                    sentenceCount++;
                    }
                }
            }
	return sentenceCount++;
	}
        /**
	 * This method is used to count the amount of upper case letters
	 * @param stringArray
	 * @return
	 */
	public static int CountWordStartingWithUpperCase(String [] stringArray) {
            int uppercaseCount = 0;
            for(int i = 0; i<stringArray.length; i++) {
                for(int j =0; j<stringArray[i].length(); j++) {
                    if(Character.isUpperCase(stringArray[i].charAt(j))) {
                        uppercaseCount++;
                    }
		}
            }
            return uppercaseCount;
	}
	public static int CountAlphabet(String [] stringArray) {
            int letterCount = 0;
            for(int i=0; i<stringArray.length; i++) {
                for(int j=0; j<stringArray[i].length(); j++) {
                    if(Character.isLetter(stringArray[i].charAt(j))) {
                        letterCount++;
                    }
                }
            }
            return letterCount;
	}
	/**
  	 * CountPunctuation method will be used to calculate the number of punctuation
  	 * based on given criteria for what is punctuation.
  	 * @param stringArray
  	 * @return
  	 */
	public static int CountPunctuation(String [] stringArray) {
            String punctuation = new String(",;.'\"*()&^%$#@!|\\/:+=-_`~?");
            int punctuationCount = 0;
            for(int i=0; i<stringArray.length; i++) {		
                for(int j=0; j<stringArray[i].length(); j++) {
                    String punctHolder = Character.toString(stringArray[i].charAt(j));
                    if(punctuation.contains(punctHolder)) {
                        punctuationCount++;
                    }
		}
            }
            return punctuationCount++;
	}
        /**
	 * CountWords method is used to count the amount of words in the the file
	 * words are separated by the comma, period, semi-colon, and whitespace
	 * @param stringArray
	 * @return
	 */
	public static int CountWords(String [] stringArray) {
            int wordCount =0;
            for(int i=0; i<stringArray.length; i++) {
                String [] wordArray = stringArray[i].split("[!?\\/*+=:,.;'\\s]+");
                wordCount +=wordArray.length;
            }
            return wordCount;
	}
	/**
	 * This final method is used to count the frequency of the words 
	 * that are inside of the imported file
	 * @param stringArrayList
	 * @return
	 */
	public static  String [][] CountWordFrequency(ArrayList<String>stringArrayList) {
            Collections.sort(stringArrayList);
            String wordFreqArray[][] = new String [stringArrayList.size()][2];
            int frequencyCount = 0;
            int place=0;
            //while i is greater than the size of the stringArray 
            for(int i=0; i<stringArrayList.size(); i++) {//i equals zero and increments
                //if the last element does not equal the current element or current element
		//location is equal to zero, then add to the word frequency array
		if((i-1 >= 0 && !(stringArrayList.get(i-1).equals(stringArrayList.get(i))) || i==0)) {
		wordFreqArray[place][0] = stringArrayList.get(i);
		//increment placeholder for array
		place++;
		}
            }	
            //while i is greater than the size of the stringArray 
            for(int i=0; i<stringArrayList.size(); i++) {//i equals zero and increments
                //while j is greater than the size of the wordFreqArray
		for(int j=0; j<wordFreqArray.length; j++) {//j equals zero and increments
                    //if the element of the wordFreqArray is not empty or null
                    //and the current wordFreqArray element equals the string array list element,
                    //increment the frequency count
                    if(wordFreqArray[i][0] != null && wordFreqArray[i][0].equals(stringArrayList.get(j))) {
                        frequencyCount++;
                    }
		}
		//add the frequency count to second dimension of the wordFreqArray & reset to 0
		wordFreqArray[i][1] = Integer.toString(frequencyCount++);
		frequencyCount =0;
            }		
            return wordFreqArray;
	}
}