package imparte;

import java.text.Collator;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		String[] words = null;
		String phrase;
		int optiune = 0;
		
		Scanner input = new Scanner(System.in);
		optiune = input.nextInt();
		phrase = input.nextLine();
		input.close();
		
		switch(optiune){
		case 11:
		{
			words = Algorithm.wScanner(phrase);
			Algorithm.wSort(words);
			
		}break;
		
		case 12:
		{
			words = Algorithm.wScanner(phrase);
			Arrays.sort(words, Collator.getInstance());
			
		}break;
		
		case 21:
		{
			words = Algorithm.wString(phrase);
			Algorithm.wSort(words);
			
		}break;
		
		case 22:
		{
			words = Algorithm.wString(phrase);
			Arrays.sort(words);
			
		}break;
		
		}
		
		for(int i = 0; i < words.length; i++)
			System.out.println(words[i]);
	}
}
