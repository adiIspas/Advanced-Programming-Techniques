package book;

import exceptions.ExistElementException;
import exceptions.NoExistElementException;
import java.io.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws ExistElementException, NoExistElementException, IOException {
		//Book test = new Book("Little Mermaid","Hans Christian Andersen");
		
		/*test.add("The Beginning");
		test.addSubchapter("The Beginning", "The Ocean");
		test.addSubchapter("The Beginning", "The Youngest Sister");
		test.addParagraph("The Beginning", "The Ocean", "Far out in the ocean");
		test.addParagraph("The Beginning", "The Ocean", "We must not imagine that there");
		test.addParagraph("The Beginning", "The Youngest Sister", "The Sea King had been a widower for many years");
		
		test.add("My Turn To Meet The Humans");
		test.addSubchapter("My Turn To Meet The Humans", "Fifteen");
		test.addParagraph("My Turn To Meet The Humans", "Fifteen", "At last she reached her fifteenth year");
		
		test.add("Test", 1);
		test.addSubchapter("The Beginning", "The Ocean v2", 1);
		test.addParagraph("The Beginning", "The Ocean", "Far out in the ocean v2", 1);
		*/
		PrintWriter pw = new PrintWriter("output.txt");
		
		//test.printTable(pw);
		
		//test.printChapter("The Beginning",pw);
		Book carte;
		String titlu = null, autor = null;
		String titluCapitol = null, titluSubcapitol = null, paragraf = null;
		//test.printBook(pw);
		//pw.println(test.index());
		
		File file = new File("F:\\Java WorkSpace\\The Book\\src\\book\\input.txt");
		Scanner input = new Scanner(file);
		
		//Titlu carte
		titlu = input.nextLine();
		//Autor
		autor = input.nextLine();
		carte = new Book(titlu,autor);
		
		while(input.hasNextLine()){
			titlu = input.next();
			if(titlu.compareTo("Chapter") == 0)
			{
				titluCapitol = input.nextLine();
				carte.add(titluCapitol);
			}
			
			if(titlu.compareTo("Subchapter") == 0)
			{
				titluSubcapitol = input.nextLine();
				carte.addSubchapter(titluCapitol, titluSubcapitol);
			}
			
			if(titlu.compareTo("Paragraph") == 0)
			{
				paragraf = input.nextLine();
				carte.addParagraph(titluCapitol, titluSubcapitol, paragraf);
			}
		}
		
		carte.printBook(pw);
		pw.println(carte.index());
		
		input.close();
		pw.flush();
		pw.close();
		System.out.println("Done! :)");
		
	}

}
