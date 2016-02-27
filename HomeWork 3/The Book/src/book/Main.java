package book;

import exceptions.ExistElementException;
import exceptions.NoExistElementException;
import java.io.*;

public class Main {

	public static void main(String[] args) throws ExistElementException, NoExistElementException, IOException {
		Book test = new Book("Little Mermaid","Hans Christian Andersen");
		
		test.add("The Beginning");
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
		
		PrintWriter pw = new PrintWriter("output.txt");
		
		//test.printTable(pw);
		
		//test.printChapter("The Beginning",pw);
		
		test.printBook(pw);
		pw.println(test.index());

		//pw.flush();
		pw.close();
		System.out.println("Done! :)");
			
	}

}
