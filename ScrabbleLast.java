package frequentNwords;

import java.util.ArrayList;
import java.util.*;
import java.io.*;

public class ScrabbleInit{
		
		static String largestWord = null;
		static int maxScore = 0;
		static char[] letters = {' ','b','c', 'd' , 'e', 'f','g'};
		static int[] scores = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};
//		static int[] scores = {0,3,3,2,1,4,2};
		static ArrayList<String> poss = new ArrayList<String>();
		
		public static void checkMax(String checkString){
			
			int newWordScore = 0;		
			for(int i=0; i<checkString.length();i++) {
				if(checkString.charAt(i)!=' ')
					newWordScore += scores[(int)checkString.charAt(i)-(int)'a'];
			}
			if(newWordScore > maxScore) {
				maxScore = newWordScore;
				largestWord = checkString;
			}
		}
		public static void checkMax(String checkString, String newChar,int pos){

			int newWordScore = 0;
			int backPos = 8 - pos + 1;
			if(backPos >= checkString.length() || (checkString.indexOf(newChar) >= checkString.length() - backPos)) {
	public static boolean searchWord(String[] words,String value,String newChar,int pos)
	{
		  if(value.contains(newChar) && linearSearch(words,value)){
			  checkMax(value,newChar,pos);
			  return true;
	        } else{
	        return false;
	        }
	}
    private static boolean linearSearch(String[] words, String value) {
//    	System.out.println("hi");
    	for(int i=0 ; i<words.length;i++) {
    		if(words[i]!=null && scrabbleEquals(value,words[i])) {
    			return true;
    		}
    	}
		return false;
	}

	private static boolean scrabbleEquals(String str1, String str2) {
		
		if(str1.length()!=str2.length())
			return false;
		for(int i=0;i<str1.length();i++) {
			if(str1.charAt(i) != str2.charAt(i) && str1.charAt(i)!= ' ')
				return false;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		
		String str = String.valueOf(letters);
//		permutation(str);
//		String[] sowpodsWords = readFile(267752);
//		for(int i = 0; i< poss.size();i++) {
//			searchWord(sowpodsWords,poss.get(i));
//		}
		
		String newChar = "k";
		int newCharPos = 3;
		permutation(str+newChar);
		String[] sowpodsWords = readFile(267752);
		for(int i = 0; i< poss.size();i++) {
			searchWord(sowpodsWords,poss.get(i),newChar,newCharPos);
		}
		System.out.println(maxScore);
		System.out.println("LARGEST:"+largestWord);
		
	}
}