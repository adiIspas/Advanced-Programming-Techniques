package book;

import java.io.PrintWriter;
import java.util.ArrayList;
import exceptions.ExistElementException;

public class Subchapter extends BookElement {
	ArrayList<String> paragraphs;
	
	Subchapter(String title){
		this.title = title;
		this.paragraphs = new ArrayList<>();
	}

	@Override
	public void add(String paragraphTitle) throws ExistElementException {
		this.paragraphs.add(paragraphTitle);
		
	}

	@Override
	public void add(String paragraphTitle, int position) throws ExistElementException {
		this.paragraphs.add(position, paragraphTitle);
		
	}
	
	public void addParagraphs(String... paragraphs){
		for(String paragraph : paragraphs)
			this.paragraphs.add(paragraph);
	}
	
	@Override
	public boolean remove(String paragraphTitle) {
		if(this.paragraphs.contains(paragraphTitle) == true){
			this.paragraphs.remove(paragraphTitle);
			return true;
		}
		return false;
	}
	
	public void print(int chapter, int subchapter, PrintWriter out){
		int par = 1;
		for(String paragraph:paragraphs){
			out.println("  Paragraph " + chapter + "." + subchapter + "." + par + ": " + paragraph);
			par++;
		}
	}
}
