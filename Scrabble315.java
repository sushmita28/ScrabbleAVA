package wordsFreq;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by vedsharma on 05-Aug-16.
 */
public class Scrabble315 {
    //get all words from sowpods.txt
	static ArrayList<String> poss = new ArrayList<String>();
	static int[] primals = {67, 71, 11, 7, 2, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 5, 3, 73, 79, 83, 89, 97, 101};
	static String largestWord;
	static int maxScore;
	static char[] letters = {'A','b','c','f'};
	static int[] scores = {4,2,9,1};
	static String[] words;
	
    
    public static void permutation(String str) { 
	    permutation("", str); 
	    
	}

	private static void permutation(String prefix, String str) {
	    int n = str.length();
	    if(prefix.length()!=0)
	    poss.add(prefix);
	    if (n == 0) System.out.println(prefix);
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}
	public static void checkMax(String checkString){

		int newWordScore = 0;
		
		int index = -1;
		
		for(int i=0; i<checkString.length(); i++){
		char alphabet = checkString.charAt(i);
		for (int j = 0; j < letters.length; i++) {
			  if (letters[j] == alphabet) {
			    index = j;
			    break;
			  }
			}
		{
		newWordScore += scores[index];
		}
		if(newWordScore > maxScore)
		{
		largestWord = checkString;
		maxScore = newWordScore;
		}
		}
	}
	
	
	
	private static void blankscrabble() {
		for(int i =0;i<poss.size();i++)
		{
			long primevalue = getPrimeValues(poss.get(i));
			
				for(int j = 0;j<26;j++)
				{		
					
				long maxprimepossible = primevalue * primals[j];
				checkInSowpods(maxprimepossible);
				//change largest word in that function before return true				
				}
			
			
		}
		
	}
	
	public static String[] readFile(String filename,int size)
	{
		File file = new File(filename);
		
		 words = new String[size];
		  Scanner input;
		try {
			input = new Scanner(file);
			for (int i = 0; i < size; i++) {
		            words[i] = input.next();
		       }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
		return words;
	      
	}
	
	private static void checkInSowpods(long maxprimepossible) {
		
		for(int i =0; i<words.length;i++)
		{
			if(maxprimepossible == getPrimeValues(words[i])){
				checkMax(words[i]);
				
			}
		}
		
	}

	public static long getPrimeValues(String genWord)
	{
	long primeValue = 1;
	
	for(int i = 0; i <genWord.length();i++)
	{
	int index = ((int) genWord.charAt(i))-65;
	primeValue *= primals[index];
	}
	return primeValue;
	}
	
	
    //Generate all words
    //getPrimeValaues(generated words)
    //loop and find all possible prime products possible but dont do it for words of length = 7
    //check whether this product is possible in sowpods
    
    public static void main(String[] args) {
        System.out.print("Enter rack: # for blank");
        Scanner sc = new Scanner(System.in);
        String rack = sc.nextLine();
        permutation(rack);        
        readFile("C:\\FindAnagrams\\sowpods.txt",267750);
        blankscrabble();
        //permutation(sc.nextLine().toUpperCase());
    }
}


       