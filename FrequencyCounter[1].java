/* Java Exercise 3: Read from a file and count the word frequencies in Java. Output the words
and their corresponding frequencies from the highest frequency to the lowest frequency */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
 
public class FrequencyCounter {
 
    public static void main(String[] args) throws IOException {
       
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));//reads the file "input.txt"
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        
        StringBuffer multiLine = new StringBuffer("");
	    String line = null;
	    if(br.ready()) {
	        while((line = br.readLine()) != null){//reads line by line
	            multiLine.append(line);
	            String[] words = line.replaceAll("[^a-zA-Z]", " ").toLowerCase().split(" ");
	            for(String word : words) {
	                if(!word.isEmpty()) {
	                    Integer freq = map.get(word);
	                    if(freq == null){
	                        map.put(word, 1);//counter initializer
	                    }//closes if statement on line 32
                            else {
	                        map.put(word, freq+1);//increments the frequency counter +1
	                    }//closes else on line 37
	                }//closes if statement on line 32
	            }//closes for loop on line 31
	        }//closes while loop on line 28
	        br.close();//closes BufferedReader
	    }//closes if statement on line 27
        
        Set<Entry<String, Integer>> set = map.entrySet();
        List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);
        Collections.sort( list, new Comparator<Map.Entry<String, Integer>>() {

            public int compare( Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 ) {
                return (o2.getValue()).compareTo( o1.getValue() );
            }//closes compare function on line 50
        } );
        for(Map.Entry<String, Integer> entry:list) {
            System.out.println(entry.getKey()+" ==== "+entry.getValue());//prints each word and its frequency
        }//closes for loop on line 54
    }//closes Collections.sort
}//closes FrequencyCounter
