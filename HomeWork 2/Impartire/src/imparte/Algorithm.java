package imparte;

import java.util.Scanner;

public class Algorithm {
	static String[] wScanner(String input){
		Scanner phrase = null;
		String[] tempWords = new String[25];
		String[] words = null;
		int length = 0;
	
		phrase = new Scanner(input);
		phrase.useDelimiter("\\W+");
		
		while(phrase.hasNext()){
			tempWords[length++] = phrase.next();
		}
		
		words = new String[length];
		//words = tempWords.clone();
		System.arraycopy(tempWords, 0, words, 0, length);
		
		phrase.close();
		return words;
			
	}
	
	static String[] wString(String phrase){		
		String[] words = phrase.split("[[ ]*|[,]*|[.]*]+");	
		return words;
	}
	
	static void wSort(String[] words){
		String aux;
		for(int i = 0; i < words.length; i++)
			for(int j = 0; j < words.length; j++)
				if(words[i].compareToIgnoreCase(words[j]) < 0){
					aux = words[i];
					words[i] = words[j];
					words[j] = aux;
				}
	}
}
