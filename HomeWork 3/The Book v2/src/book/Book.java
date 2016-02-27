package book;
import java.io.*;
import java.util.*;
import exceptions.ExistElementException;
import exceptions.NoExistElementException;

import interfaces.Indexable;

public class Book extends BookElement implements Indexable{
	ArrayList<String> authors;
	
	Book(String title, String... authors){
		this.title = title;
		this.authors = new ArrayList<>();
		
		for(String author:authors)
			this.authors.add(author);
	}
	
	public void printBook(PrintWriter out){
		out.println(title);
		for(String author:authors)
			out.print(author + " ");
		out.println("\n");
		
		int chapter = 1, subchapter = 1;
		for(BookElement e1:elements){
			out.println("Chapter " + chapter + ": " + e1); 
				for(BookElement e2:e1.elements){
					out.println(" Subchapter " + chapter + "." + subchapter + ": " + e2); 
						((Subchapter)(e2)).print(chapter, subchapter, out);
						subchapter++;
						}
				chapter++;
				out.println();
				subchapter = 1;
				}
	
		}
	
	public void printChapter(String chapterTitle, PrintWriter out) throws NoExistElementException{
		Chapter chapter = new Chapter(chapterTitle);
		
		if(this.elements.contains(chapter) == false)
			throw new NoExistElementException();
		
		int chap = this.elements.indexOf(chapter) + 1, subchapter = 1;
		out.println("Chapter " + chap + ": " + chapter.title);
		for(BookElement e1:this.elements.get(this.elements.indexOf(chapter)).elements){
			out.println(" Subchapter " + chap + "." + subchapter + ": " + e1); 
			((Subchapter)(e1)).print(chap,subchapter, out);
			subchapter++;
			}
		chap++;
		}
	
	public void printTable(PrintWriter out){
		out.println(title);
		for(String author:authors)
			out.print(author + " ");
		out.println("\n");
		
		int chapter = 1, subchapter = 1;
		for(BookElement e1:elements){
			out.println("Chapter " + chapter + ": " + e1);
				for(BookElement e2:e1.elements){
					out.println(" Subchapter " + chapter + "." + subchapter + ": " + e2);
					subchapter++;
					}
				chapter++;
				subchapter = 1;
				out.println();
				}
	}
	
	@Override
	public void add(String chapterTitle) throws ExistElementException {
		Chapter chapter = new Chapter(chapterTitle);
		
		if(this.elements.contains(chapter) == false){
			this.elements.add(chapter);
		}
		else
			throw new ExistElementException();
		
	}

	@Override
	public void add(String chapterTitle, int position) throws ExistElementException {
		Chapter chapter = new Chapter(chapterTitle);
		
		if(this.elements.contains(chapter) == false){
			this.elements.add(position,chapter);
		}
		else
			throw new ExistElementException();
		
	}
	
	void addSubchapter(String chapterTitle, String subchapterTitle) throws NoExistElementException, ExistElementException {
		Chapter chapter = new Chapter(chapterTitle);
		
		if(this.elements.contains(chapter) == false)
			throw new NoExistElementException();
		else
		{
			this.elements.get(this.elements.indexOf(chapter)).add(subchapterTitle);
		}
		
	}
	
	void addSubchapter(String chapterTitle, String subchapterTitle, int position) throws NoExistElementException, ExistElementException {
		Chapter chapter = new Chapter(chapterTitle);
		
		if(this.elements.contains(chapter) == false)
			throw new NoExistElementException();
		else
		{
			this.elements.get(this.elements.indexOf(chapter)).add(subchapterTitle, position);
		}
		
	}
	
	public void addParagraph(String chapterTitle, String subchapterTitle, String... paragraphs) throws NoExistElementException{ 
		Chapter chapter = new Chapter(chapterTitle);
		if(this.elements.contains(chapter) == true){
			((Chapter)(this.elements.get(this.elements.indexOf(chapter)))).addParagraph(subchapterTitle, paragraphs);
		}
		else
			throw new NoExistElementException();
	}
	
	public void addParagraph(String chapterTitle, String subchapterTitle, String paragraphTitle, int position) throws NoExistElementException, ExistElementException{
		Chapter chapter = new Chapter(chapterTitle);
		if(this.elements.contains(chapter) == true){
			((Chapter)this.elements.get(this.elements.indexOf(chapter))).addParagraph(subchapterTitle, paragraphTitle, position);
		}
		else
			throw new NoExistElementException();
	}
	
	public String index(){
		int index = this.title.hashCode() + this.authors.hashCode();
		if(index < 0)
			index = -1 * index;
		
		index = index % 100_000;
		return "Index " + this.title + ": " + index;
	}
	
	@Override
	public boolean remove(String chapterTitle) {
		Chapter chapter = new Chapter(chapterTitle);
		
		if(this.elements.contains(chapter) == true){
			this.elements.remove(chapter);
			return true;
		}
		
		return false;
	}
	
	public boolean remove(String chapterTitle, String subchapterTitle){
		Chapter chapter = new Chapter(chapterTitle);
		if(this.elements.contains(chapter) == true){
			return ((Chapter)(this.elements.get(this.elements.indexOf(chapter)))).remove(subchapterTitle);
		}
		return false;
	}
	
	public boolean remove(String chapterTitle, String subchapterTitle, String paragraph){
		Chapter chapter = new Chapter(chapterTitle);
		if(this.elements.contains(chapter) == true){
			return ((Chapter)(this.elements.get(this.elements.indexOf(chapter)))).remove(subchapterTitle, paragraph);
		}
		return false;
	}
}
