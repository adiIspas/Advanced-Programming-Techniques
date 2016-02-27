package defaultPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("F:\\Java WorkSpace\\PD - Problema2\\in.txt");
		Scanner input = new Scanner(file);
		
		int numarCuvinte = 0, index;
		String cuvant = null, fraza = null;
		ArrayList<String> dictionar = new ArrayList<String>();
		ArrayList<String> cuvinteFraza = new ArrayList<String>();
		
		numarCuvinte = input.nextInt();
		
		// Adaugam in dictionar cuvintele
		dictionar.add("0");
		dictionar.add("1");
		for(int i = 0; i < numarCuvinte; i++){
			cuvant = input.next();
			dictionar.add(cuvant);
		}
		
		// Citim fraza
		fraza = input.next();	
		input.close();
		
		// Incepem sa parcurgem fraza caracter cu caracter si sa cautam impartirea minima care se poate face pana la pasul i
		String[] cuvinte = new String[fraza.length()];
		int[] impartire = new int[fraza.length()];
		for(int i = 1; i < fraza.length() + 1; i++){
			
			// testam daca exita in dictionar cuvantul de la 0 la i
			if(dictionar.contains(fraza.substring(0, i)) == true){
				impartire[i - 1] = 1;
				cuvinte[i - 1] = fraza.substring(0, i);
			}
			else
				// testeam in cate cuvinte se mai poate imparti fraza intorcandu-ne inapoi caracter cu caracter
				// practic aplicam procedeul care l-am aplicat mai sus mergand inainte, insa acum mergem inapoi
				for(int j = i - 1; j >= 0; j--){
					if(dictionar.contains(fraza.substring(j, i)) == true){
						impartire[i - 1] = impartire[j - 1] + 1;
						cuvinte[i - 1] = fraza.substring(j, i);
					}
				}
		}
		
		// Selectam cuvintele in care am impartit fraza
		index = fraza.length() - 1;
		do{
			cuvinteFraza.add(cuvinte[index]);
			index -= cuvinte[index].length();
		}while(index > 0);
		
		System.out.print("Fraza " + fraza +" se poate imparti in minim " + impartire[fraza.length() - 1] + " cuvinte: ");
		for(int i = cuvinteFraza.size() - 1; i >= 0; i--){
			System.out.print(cuvinteFraza.get(i) + " ");
		}
	}
}
